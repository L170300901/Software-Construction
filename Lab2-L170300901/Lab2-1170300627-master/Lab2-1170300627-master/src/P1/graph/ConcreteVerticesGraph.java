/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteVerticesGraph<L> implements Graph<String> {
    
    private final List<Vertex> vertices = new ArrayList<>();
    
    // Abstraction function:
    //   Represent a graph using a list of vertices
    
    // Representation invariant:
    // Vertice can't be null
    
    // Safety from rep exposure:
    //   A point can be connected to other points in the list
    
    // TODO constructor
    public ConcreteVerticesGraph() {
        // TODO Auto-generated constructor stub        
    }
    // TODO checkRep
    public void checkRep() {
        for(int i=0;i<vertices.size();i++)
        {
            assert(vertices.get(i).nextVertex.size() < vertices.size());
        }
    }
    @Override public boolean add(String vertex) {
        //throw new RuntimeException("not implemented");
        for(Vertex list:vertices)
        {
            if(list.getName().equals(vertex))
            {
                return false;
            }
        }
        
        Map<String, Integer> nextVertex = new HashMap<>();
        Vertex v = new Vertex(vertex, nextVertex);
        vertices.add(v);
        return true;
    }
    
    @Override public int set(String source, String target, int weight) {
        //throw new RuntimeException("not implemented");
        if(weight<0)
            throw new RuntimeException("Invalid weight");
        if(source.equals(target))
            throw new RuntimeException("Invalid input");
        boolean targetisExist = true;
        for (Vertex list : vertices) {
            if (list.getName().equals(target))
                targetisExist = false;
            if (list.getName().equals(source)) {
                if (list.nextVertex.containsKey(target)) {
                    list.nextVertex.remove(target);
                    if (weight > 0) {
                        list.nextVertex.put(target, weight);
                        if (targetisExist) {
                            Map<String, Integer> map1 = new HashMap<>();
                            Vertex vertex1 = new Vertex(target, map1);
                            vertices.add(vertex1);
                        }
                        return weight;
                    }
                    return weight;
                } else {
                    if (weight > 0) {
                        if (targetisExist) {
                            Map<String, Integer> map1 = new HashMap<>();
                            Vertex vertex1 = new Vertex(target, map1);
                            vertices.add(vertex1);
                        }
                        list.nextVertex.put(target, weight);
                        return weight;
                    }
                    return weight;
                }
            }
        }

        if (weight > 0) {
            Map<String, Integer> map = new HashMap<>();
            map.put(target, weight);
            Vertex vertex = new Vertex(source, map);
            vertices.add(vertex);
            if (targetisExist) {
                Map<String, Integer> map1 = new HashMap<>();
                Vertex vertex1 = new Vertex(target, map1);
                vertices.add(vertex1);
            }
        }

        return weight;  
    }
    
    @Override public boolean remove(String vertex) {
        //throw new RuntimeException("not implemented");
        for (Vertex list : vertices)
        {
            if(list.getName().equals(vertex))
            {
                vertices.remove(list);
                return true;
            }
        }
        
        return false;
    }
    
    @Override public Set<String> vertices() {
        //throw new RuntimeException("not implemented");
        Set<String> set = new HashSet<>();
        for(Vertex list:vertices)
        {
            set.add(list.getName());
        }
        
        return set;
    }
    
    @Override public Map<String, Integer> sources(String target) {
        //throw new RuntimeException("not implemented");
        Map<String, Integer> map = new HashMap<>();
        for(Vertex list:vertices)
        {
            for(int i=0;i<list.nextVertex.size();i++)
                map.put(list.getName(), list.nextVertex.get(i));
        }
        
        return map;
    }
    
    @Override public Map<String, Integer> targets(String source) {
        //throw new RuntimeException("not implemented");
        Map<String, Integer> map = new HashMap<>();
        for(Vertex list:vertices)
        {
            map.putAll(list.nextVertex);
        }
        
        return map;
    }
    
    // TODO toString()
    @Override
    public String toString(){
        String ending = new String();
        for(int i = 0; i < vertices.size();i ++) {
        ending = ending + vertices.get(i).getName();
        }
        return ending;
    }
}

/**
 * TODO specification
 * Mutable.
 * This class is internal to the rep of ConcreteVerticesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Vertex{
    
    // TODO fields
    private String name;
    Map<String, Integer> nextVertex = new HashMap<>();
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Map<String, Integer> getNextVertex() {
        return nextVertex;
    }
    public void setNextVertex(Map<String, Integer> nextVertex) {
        this.nextVertex = nextVertex;
    }   
    public Vertex(String name,Map<String, Integer> nextVertex){
        this.name = name;
        this.nextVertex = nextVertex;
    }
    // TODO constructor
    
    // TODO checkRep
    public void checkRep(){
    	ArrayList<String> ckeck = new ArrayList<>();
    	for(String key:nextVertex.keySet())
        {
        	ckeck.add(key);
        }
    	for(int i =0;i < ckeck.size();i ++) {
    		if(ckeck.get(i).equals(name)) {
    			System.out.println("wrong");
    		}
    	}
    }
    // TODO methods
    
    // TODO toString()
    public String toSring() {
        String ending = new String();
        for(String key:nextVertex.keySet())
        {
        	ending = ending + "name :" + key+" "+nextVertex.get(key);
        }
        return ending;
    }
}

