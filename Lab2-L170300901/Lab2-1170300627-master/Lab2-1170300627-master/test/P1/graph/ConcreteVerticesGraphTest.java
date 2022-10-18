/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Tests for ConcreteVerticesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteVerticesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteVerticesGraphTest extends GraphInstanceTest {


    @Override
    public Graph<String> emptyInstance() {
        return new ConcreteVerticesGraph<String>();
    }


    @Test
    public void toStringTest() {
        ConcreteVerticesGraph<String> graph = new ConcreteVerticesGraph<String>();
        graph.set("a", "b", 5);
        graph.set("b", "c", 6);
        graph.set("c", "d", 5);
        String s = "abcd";
        //System.out.println(graph.toString());
        assertEquals(graph.toString(), s);
        // System.out.println(graph.toString());
    }

    // TODO tests for operations of Vertex
    @Test
    public void VertexTest() {
        Map<String, Integer> map = new HashMap<>();
        map.put("b", 5);
        map.put("c", 6);
        Vertex vertex = new Vertex("a", map);
        assertEquals("a", vertex.getName());
        assertEquals(map, vertex.nextVertex);
    }
    @Test
    public void checkRepTest()
    {
        ConcreteVerticesGraph<String> graph = new ConcreteVerticesGraph<String>();
        graph.set("a", "b", 5);
        graph.set("b", "c", 6);
        graph.set("c", "d", 5);
        graph.checkRep();
    }
}
