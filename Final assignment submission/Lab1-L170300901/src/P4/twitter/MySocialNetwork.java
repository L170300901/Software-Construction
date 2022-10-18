package P4.twitter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MySocialNetwork {

    /**
     * guessFollowsGraph it can add #HashTag member
     * 
     * @param tweets
     *            a list of tweets providing the evidence, not modified by this
     *            method.
     * @return a social network (as defined above) in which Ernie follows Bert if
     *         and only if there is evidence for it in the given list of tweets. One
     *         kind of evidence that Ernie follows Bert is if Ernie. in addition,
     *         can add who has strongger evidence with other people as #HashTags.
     * 
     *         #Common HashTags. People who use the same hashtags in their tweets
     *         (e.g. #mit) may mutually influence each other. People who share a
     *         hashtag that isn¡¯t otherwise popular in the dataset, or people who
     *         share multiple hashtags, may be even stronger evidence. One kind of
     *         evidence that Ernie follows Bert and Bert also follows Ernie.
     * 
     */
    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
        // throw new RuntimeException("not implemented");
        Map<String, Set<String>> map = new HashMap<String, Set<String>>();
        int tsize = tweets.size();
        for (int i = 0; i < tsize; i++) {
            Set<String> set = Extract.getMentionedUsers(Arrays.asList(tweets.get(i)));
            map.put(tweets.get(i).getAuthor().toLowerCase(), set);
        }
        Map<String, Set<String>> hashtag = new HashMap<String, Set<String>>();
        for (int i = 0; i < tsize; i++) {
            Pattern p = Pattern.compile("[^\\x21-\\x7E]?#[\\x21-\\x7E]+");
            String text = tweets.get(i).getText();
            Matcher m = p.matcher(text);
            while (m.find()) {
                String hash = m.group().split("#")[1];
                if (!hashtag.keySet().contains(hash)) {
                    Set<String> set = new HashSet<String>();
                    hashtag.put(hash, set);
                }
                hashtag.get(hash).add(tweets.get(i).getAuthor().toLowerCase());
            }
        }
        for (String key : hashtag.keySet()) {
            for (String follow : hashtag.get(key)) {
                for (String name : hashtag.get(key)) {
                    if (!name.equalsIgnoreCase(follow)) {
                        map.get(follow).add(name);
                        map.get(name).add(follow);
                    }
                }
            }
        }
        return map;
    }
}
