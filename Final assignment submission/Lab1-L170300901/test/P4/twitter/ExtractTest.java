package P4.twitter;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.Set;

import org.junit.Test;

public class ExtractTest {

    /*
     * TODO: your testing strategies for these methods should go here.
     * See the ic03-testing exercise for examples of what a testing strategy comment looks like.
     * Make sure you have partitions.
     */
    
    private static final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    private static final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    private static final Instant d3 = Instant.parse("2016-02-18T11:00:00Z");
    private static final Instant d4 = Instant.parse("2016-02-17T10:30:00Z");
    private static final Instant d5 = Instant.parse("2016-02-16T10:00:00Z");
    private static final Instant d6 = Instant.parse("2016-02-17T11:15:00Z");
    
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "@henry, it's so good!", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "RT @peter: rivest talk in 30 minutes #hype", d2);
    private static final Tweet tweet3 = new Tweet(3, "henry", "what a nice day #paris @alyssa", d3);
    private static final Tweet tweet4 = new Tweet(4, "peter", "@Kate he's wonderful player #C7 #soccer #RealMadrid", d4);
    private static final Tweet tweet5 = new Tweet(5, "kate", "Harry kane! #tottenham #soccer", d5);
    private static final Tweet tweet6 = new Tweet(6, "annie", "my delicious dinner @Henry", d6);
   
    
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testGetTimespanTwoTweets() {
        Timespan timespan = Extract.getTimespan(Arrays.asList(tweet1, tweet2, tweet3, tweet4,tweet5, tweet6));
        
        assertEquals("expected start", d5, timespan.getStart());
        assertEquals("expected end", d3, timespan.getEnd());
    }
    
    @Test
    public void testGetMentionedUsersNoMention() {
        Set<String> mentionedUsers = Extract.getMentionedUsers(Arrays.asList(tweet1, tweet2, tweet3, tweet4,tweet5, tweet6));
        
        assertEquals("expected empty set", false,mentionedUsers.isEmpty());
        assertEquals("expected does not exist", true,mentionedUsers.contains("alyssa"));
        assertEquals("expected does not exist", true,mentionedUsers.contains("henry"));
        assertEquals("expected does not exist", true,mentionedUsers.contains("kate"));
        assertEquals("expected does not exist", true,mentionedUsers.contains("peter"));
        assertEquals("expected does not exist", false,mentionedUsers.contains("email"));
    }

    /*
     * Warning: all the tests you write here must be runnable against any
     * Extract class that follows the spec. It will be run against several staff
     * implementations of Extract, which will be done by overwriting
     * (temporarily) your version of Extract with the staff's version.
     * DO NOT strengthen the spec of Extract or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in Extract, because that means you're testing a
     * stronger spec than Extract says. If you need such helper methods, define
     * them in a different class. If you only need them in this test class, then
     * keep them in this test class.
     */

}
