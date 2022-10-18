package P4.twitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Filter consists of methods that filter a list of tweets for those matching a
 * condition.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Filter {

    /**
     * Find tweets written by a particular user.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param username
     *            Twitter username, required to be a valid Twitter username as
     *            defined by Tweet.getAuthor()'s spec.
     * @return all and only the tweets in the list whose author is username, in the
     *         same order as in the input list.
     */
    public static List<Tweet> writtenBy(List<Tweet> tweets, String username) {
        // throw new RuntimeException("not implemented");
        List<Tweet> list = new ArrayList<Tweet>();
        int tsize = tweets.size();
        for (int i = 0; i < tsize; i++) {
            if (tweets.get(i).getAuthor().equalsIgnoreCase(username))
                list.add(tweets.get(i));
        }
        return list;
    }

    /**
     * Find tweets that were sent during a particular timespan.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param timespan
     *            timespan
     * @return all and only the tweets in the list that were sent during the
     *         timespan, in the same order as in the input list.
     */
    public static List<Tweet> inTimespan(List<Tweet> tweets, Timespan timespan) {
        // throw new RuntimeException("not implemented");
        long timestart = timespan.getStart().getEpochSecond(), timeend = timespan.getEnd().getEpochSecond();
        List<Tweet> list = new ArrayList<Tweet>();
        int tsize = tweets.size();
        for (int i = 0; i < tsize; i++) {
            long time = tweets.get(i).getTimestamp().getEpochSecond();
            if (time >= timestart && time <= timeend)
                list.add(tweets.get(i));
        }
        return list;
    }

    /**
     * Find tweets that contain certain words.
     * 
     * @param tweets
     *            a list of tweets with distinct ids, not modified by this method.
     * @param words
     *            a list of words to search for in the tweets. A word is a nonempty
     *            sequence of nonspace characters.
     * @return all and only the tweets in the list such that the tweet text (when
     *         represented as a sequence of nonempty words bounded by space
     *         characters and the ends of the string) includes *at least one* of the
     *         words found in the words list. Word comparison is not
     *         case-sensitive,0 so "Obama" is the same as "obama". The returned
     *         tweets are in the same order as in the input list.
     */
    public static List<Tweet> containing(List<Tweet> tweets, List<String> words) {
        // throw new RuntimeException("not implemented");
        ArrayList<Tweet> list = new ArrayList<Tweet>();
        int tsize = tweets.size();
        int wsize = words.size();
        boolean flag;
        for (int i = 0; i < tsize; i++) {
            flag = false;
            String[] temp = tweets.get(i).getText().split(" ");
            for (int j = 0; j < wsize; j++) {
                for (int k = 0; k < temp.length; k++) {
                    if (temp[k].equalsIgnoreCase(words.get(j)))
                        flag = true;
                }
            }
            if (flag)
                list.add(tweets.get(i));
        }
        return list;
    }

}
