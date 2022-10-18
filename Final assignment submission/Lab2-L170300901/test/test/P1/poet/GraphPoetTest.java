/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.poet;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Test;

/**
 * Tests for GraphPoet.
 */
public class GraphPoetTest {
    
    // Testing strategy
    // 1. empty graph
    // 2. empty input
    // 3. input with multiple two-edge-long paths 
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; 
    }
    @Test
    public void testLengthOneInput() throws IOException {
        GraphPoet graph = new GraphPoet(new File("test/P1/poet/text1.txt"));
       // System.out.println(graph.poem("A"));
        assertEquals("A", graph.poem("A"));
    }
    
}
