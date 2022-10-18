package P4.twitter;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class FilterTest {

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
    private static final Instant d7 = Instant.parse("2016-02-17T10:45:00Z");
    private static final Instant d8 = Instant.parse("2016-02-16T14:00:00Z");
    private static final Instant d9 = Instant.parse("2016-02-17T10:15:00Z");
    
    private static final Tweet tweet1 = new Tweet(1, "alyssa", "@henry, it's so good!", d1);
    private static final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes #hype", d2);
    private static final Tweet tweet3 = new Tweet(3, "henry", "what a nice day #paris @alyssa", d3);
    private static final Tweet tweet4 = new Tweet(4, "peter", "he's wonderful player #C7 #soccer #RealMadrid", d4);
    private static final Tweet tweet5 = new Tweet(5, "kate", "Harry kane! #tottenham #soccer", d5);
    private static final Tweet tweet6 = new Tweet(6, "annie", "my delicious dinner @Henry", d6);
    private static final Tweet tweet7 = new Tweet(7, "jane", "@kate It's Son! #tottenham #soccer", d7);
    private static final Tweet tweet8 = new Tweet(8, "jim", "My team~ #tottenham", d8);
    private static final Tweet tweet9 = new Tweet(9, "victor", "hello my buddy myemail@email.co.kr #hype", d9);
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testWrittenByMultipleTweetsSingleResult() {
        List<Tweet> writtenBy = Filter.writtenBy(Arrays.asList(tweet1,tweet2,tweet3,tweet4,tweet5,tweet6,tweet7,tweet8,tweet9), "alyssa");
        
        assertEquals("expected singleton list", 1, writtenBy.size());
        assertTrue("expected list to contain tweet", writtenBy.contains(tweet1));
    }
    
    @Test
    public void testInTimespanMultipleTweetsMultipleResults() {
        Instant testStart = Instant.parse("2016-02-17T09:00:00Z");
        Instant testEnd = Instant.parse("2016-02-17T10:30:00Z");
        
        List<Tweet> inTimespan = Filter.inTimespan(Arrays.asList(tweet1,tweet2,tweet3,tweet4,tweet5,tweet6,tweet7,tweet8,tweet9), new Timespan(testStart, testEnd));
        
        assertFalse("expected non-empty list", inTimespan.isEmpty());
        assertTrue("expected list to contain tweets", inTimespan.containsAll(Arrays.asList(tweet1, tweet4,tweet9)));
        assertEquals("expected same order", 0, inTimespan.indexOf(tweet1));
    }
    
    @Test
    public void testContaining() {
        List<Tweet> containing = Filter.containing(Arrays.asList(tweet1,tweet2,tweet3,tweet4,tweet5,tweet6,tweet7,tweet8,tweet9), Arrays.asList("it's"));
        
        assertFalse("expected non-empty list", containing.isEmpty());
        assertTrue("expected list to contain tweets", containing.containsAll(Arrays.asList(tweet1, tweet7)));
        assertEquals("expected same order", 0, containing.indexOf(tweet1));
    }

    /*
     * Warning: all the tests you write here must be runnable against any Filter
     * class that follows the spec. It will be run against several staff
     * implementations of Filter, which will be done by overwriting
     * (temporarily) your version of Filter with the staff's version.
     * DO NOT strengthen the spec of Filter or its methods.
     * 
     * In particular, your test cases must not call helper methods of your own
     * that you have put in Filter, because that means you're testing a stronger
     * spec than Filter says. If you need such helper methods, define them in a
     * different class. If you only need them in this test class, then keep them
     * in this test class.
     */

}
