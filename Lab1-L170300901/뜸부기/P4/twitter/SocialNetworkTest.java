package P4.twitter;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

public class SocialNetworkTest {

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
    
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "@peter£¬it's so good!", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes @alyssa #hype", d2);
    private static final Tweet tweet3 = new Tweet(3, "henry", "what a nice day #paris @alyssa", d3);
    private static final Tweet tweet4 = new Tweet(4, "peter", "he's wonderful player #messi #soccer myemail@email.co.kr", d4);
    private static final Tweet tweet5 = new Tweet(5, "kate", "winner winner chicken dinner #pubg", d5);
    private static final Tweet tweet6 = new Tweet(6, "annie", "my delicious dinner @Henry, @KaTE", d6);
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testGuessFollowsGraphEmpty() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet1, tweet2, tweet3, tweet4,tweet5, tweet6));
        
        assertFalse("expected empty graph", followsGraph.isEmpty());
        assertEquals("expected doesn't have data", 1,followsGraph.get(tweet1.getAuthor()).size());
        assertEquals("expected doesn't have data", 1,followsGraph.get(tweet2.getAuthor()).size());
        assertEquals("expected doesn't have data", 1,followsGraph.get(tweet3.getAuthor()).size());
        assertEquals("expected doesn't have data", 0,followsGraph.get(tweet4.getAuthor()).size());
        assertEquals("expected doesn't have data", 0,followsGraph.get(tweet5.getAuthor()).size());
        assertEquals("expected doesn't have data", 2,followsGraph.get(tweet6.getAuthor()).size());
        assertEquals("data discorrect", 6,followsGraph.size());
    }
    
    @Test
    public void testInfluencersEmpty() {
        Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(Arrays.asList(tweet1, tweet2, tweet3, tweet4,tweet5, tweet6));
        List<String> influencers = SocialNetwork.influencers(followsGraph);
        
        // print the top-N influencers
        int i=0;
        for (String username : influencers.subList(0, influencers.size())) {
            switch(i++) {
            case 0:
                assertEquals("data discorrect", "alyssa",username);
                break;
            case 1:
                assertEquals("data discorrect", "henry",username);
                break;
            case 2:
                assertEquals("data discorrect", "peter",username);
                break;
            case 3:
                assertEquals("data discorrect", "kate",username);
                break;
            }
        }
    }

    /*
     * Warning: all the tests you write here must be runnable against any
     * SocialNetwork class that follows the spec. It will be run against several
     * staff implementations of SocialNetwork, which will be done by overwriting
     * (temporarily) your version of SocialNetwork with the staff's version.
     * DO NOT strengthen the spec of SocialNetwork or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in SocialNetwork, because that means you're testing a
     * stronger spec than SocialNetwork says. If you need such helper methods,
     * define them in a different class. If you only need them in this test
     * class, then keep them in this test class.
     */

}
