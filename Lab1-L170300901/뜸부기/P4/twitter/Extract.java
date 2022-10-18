package P4.twitter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extract consists of methods that extract information from a list of tweets.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Extract {

    /**
     * Get the time period spanned by tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return a minimum-length time interval that contains the timestamp of every
     *         tweet in the list.
     */
    public static Timespan getTimespan(List<Tweet> tweets) {
        // throw new RuntimeException("not implemented");
        int tsize = tweets.size(), a = 0, b = 0;
        long min, max;
        min = tweets.get(0).getTimestamp().getEpochSecond();
        max = tweets.get(0).getTimestamp().getEpochSecond();
        for (int i = 0; i < tsize; i++) {
            if (tweets.get(i).getTimestamp().getEpochSecond() <= min) {
                a = i;
                min = tweets.get(i).getTimestamp().getEpochSecond();
            }
            if (tweets.get(i).getTimestamp().getEpochSecond() >= max) {
                b = i;
                max = tweets.get(i).getTimestamp().getEpochSecond();
            }
        }
        Timespan timespan = new Timespan(tweets.get(a).getTimestamp(), tweets.get(b).getTimestamp());
        return timespan;
    }

    /**
     * Get usernames mentioned in a list of tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return the set of usernames who are mentioned in the text of the tweets. A
     *         username-mention is "@" followed by a Twitter username (as defined by
     *         Tweet.getAuthor()'s spec). The username-mention cannot be immediately
     *         preceded or followed by any character valid in a Twitter username.
     *         For this reason, an email address like bitdiddle@mit.edu does NOT
     *         contain a mention of the username mit. Twitter usernames are
     *         case-insensitive, and the returned set may include a username at most
     *         once.
     */
    public static Set<String> getMentionedUsers(List<Tweet> tweets) {
        // throw new RuntimeException("not implemented");
        Set<String> Users = new HashSet<String>();
        Pattern p = Pattern.compile("[^A-Za-z_-]@[A-Za-z0-9_-]+");
        for (int i = 0; i < tweets.size(); i++) {
            String text = tweets.get(i).getText();
            Matcher m = p.matcher(text);

            while (m.find()) {
                String[] Mentioned = m.group().split("@");
                Users.add(Mentioned[1].toLowerCase());
            }
        }
        p = Pattern.compile("\\A@[A-Za-z0-9_-]+");
        for (int i = 0; i < tweets.size(); i++) {
            String text = tweets.get(i).getText();
            Matcher m = p.matcher(text);

            while (m.find()) {
                String[] Mentioned = m.group().split("@");
                Users.add(Mentioned[1].toLowerCase());
            }
        }
        return Users;
    }
}
