/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

/**
 * Tests for static methods of Graph.
 *
 * To facilitate testing multiple implementations of Graph, instance methods are
 * tested in GraphInstanceTest.
 */
public class GraphStaticTest {
    
    // Testing strategy
    //   empty()
    //     no inputs, only output is empty graphS
    //     observe with vertices()
    
    @Test(expected=AssertionError.class)
    public void testAssertionsEnabled() {
        assert false; // make sure assertions are enabled with VM argument: -ea
    }
    
    @Test
    public void testEmptyVerticesEmpty() {
        assertEquals("expected empty() graph to have no vertices",
                Collections.emptySet(), Graph.empty().vertices());
    }
    
    // TODO test other vertex label types in Problem 3.2
    /**
     * Test the add method
     * Comparing graph objects vertices with preset set collection class
     */
    @Test
    public void addTest(){
        Graph<String> graph = new ConcreteEdgesGraph<String>();
        graph.add("a");
        graph.set("a", "c", 5);
        Set<String> set = new HashSet<>();
        set.add("a");
        assertEquals(set.size(), graph.vertices().size());
    }
    /**
     * Test whether the contents of the graph are in the corresponding position
     */
    @Test
    public void setTest(){
        Graph<String> graph = new ConcreteEdgesGraph<String>();
        graph.set("a", "b", 5);
        graph.set("b", "c", 6);
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        assertEquals(5, graph.sources("b").get("a").intValue());
    }
    /**
     * First add some points to the graph, then delete these points, 
     * and finally test if graph.vertices is empty
     */
    @Test
    public void edgeRemoveTest(){
        Graph<String> graph = new ConcreteEdgesGraph<String>();
        graph.add("a");
        graph.add("b");
        graph.remove("a");
        graph.remove("b");
        assertEquals(graph.vertices(), Collections.EMPTY_SET);
    }
    /**
     * Since the data type we set before is String, and the data type in the interface is L, 
     * we can only use the set method to add, and then add the node and then delete it to compare it.
     */
    @Test
    public void verticesRemoveTest(){
        Graph<String> graph = new ConcreteVerticesGraph<String>();
        graph.set("a", "b", 5);
        graph.remove("a");
        graph.remove("b");
        assertEquals(graph.vertices(), Collections.EMPTY_SET);
    }
    /**
     * Test whether the targets method actually returns the map we need
     */
    @Test
    public void targetsTest(){
        Graph<String> graph = new ConcreteEdgesGraph<String>();
        graph.set("a", "b", 5);
        graph.set("b", "c", 6);
        Map<String, Integer> map = new HashMap<>();
        map.put("b", 5);
        assertEquals(graph.targets("a"), map);
    }
    
    @Test
    public void sourcesTest(){
        Graph<String> graph = new ConcreteEdgesGraph<String>();
        graph.set("a", "b", 5);
        graph.set("b", "c", 6);
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 5);
        assertEquals(graph.sources("b"), map);
    }
}
