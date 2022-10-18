/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;

import org.junit.Test;


/**
 * Tests for ConcreteEdgesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteEdgesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteEdgesGraphTest extends GraphInstanceTest {
    

    @Override public Graph<String> emptyInstance() {
        return new ConcreteEdgesGraph<String>();
    }
    

    @Test
    public void toStringTest()
    {
        ConcreteEdgesGraph<String> graph = new ConcreteEdgesGraph<String>();
        String s = "zmclch5lchmjm6mjmxjh5";
        graph.set("zmc", "lch", 5);
        graph.set("lch", "mjm", 6);
        graph.set("mjm", "xjh", 5);
        assertEquals(s, graph.toString());
    }
  
    @Test
    public void edgeTest()
    {
        Edge edge = new Edge("a", "b", 5);
        assertEquals("a", edge.getSource());
        assertEquals(edge.getTarget(), "b");
        assertEquals(5, edge.getWeight(),0);
        Edge edge1 = new Edge("a", "b", 5);
        assertEquals(edge.toString(), edge1.toString());
    }
    

    @Test
    public void checkrepTest(){
        Edge edge = new Edge("a", "b", 5);
        assertFalse(!edge.checkRep());
    }
}