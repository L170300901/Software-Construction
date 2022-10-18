/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 */
public class ConcreteEdgesGraph<L> implements Graph<String> {
    
    private final Set<String> vertices = new HashSet<>();
    private final List<Edge> edges = new ArrayList<>();
    
    // Abstraction function:
    //   TODO
    @Override public boolean add(String vertex) {
        //throw new RuntimeException("not implemented");
    	for(String it : vertices) {
    		if(it.equals(vertex)) return false;
    	}
    	vertices.add(vertex);
        return true;
    }

    @Override public int set(String source, String target, int weight) {
        //throw new RuntimeException("not implemented");
        if (source.equals(target)) throw new RuntimeException("Invalid input");
        for(int i = 0;i < edges.size();i ++) {
        	if(edges.get(i).getSource().equals(edges.get(i).getTarget())) {
        		if(weight == 0) {
        			int ending = edges.get(i).getWeight();
        			edges.remove(i);
        			return ending;
        		}else {
        			int ending = edges.get(i).getWeight();
        			edges.remove(i);
        			edges.add(new Edge(source,target,weight));
        			return ending;
        		}
        	}
        }
        edges.add(new Edge(source,target,weight));
        return 0;
    	
    }

    @Override public boolean remove(String vertex) {
        //throw new RuntimeException("not implemented");
    	if(!vertices.contains(vertex)) return false;
    	Iterator<Edge> it=edges.iterator();    	 
        while(it.hasNext()){
            Edge e=it.next();
            if(e.getSource().equals(vertex)||e.getTarget().equals(vertex)) it.remove();
        }
        vertices.remove(vertex);
        return true;
    }

    @Override public Set<String> vertices() {
        //throw new RuntimeException("not implemented");
    	 HashSet<String> ending =new HashSet<>();
    	 for(String it : vertices) {
    		 ending.add(new String(it));
    	 }
    	return ending; 	
    }
  
    @Override public Map<String, Integer> sources(String target) {
        //throw new RuntimeException("not implemented");
    	TreeMap<String, Integer> ending = new TreeMap<>();
    	for(Edge it : edges) {
    		if(it.getTarget().equals(target)) ending.put(new String(it.getSource()), new Integer(it.getWeight()));
    	}
    	return ending;
    }
  
    @Override public Map<String, Integer> targets(String source) {
        //throw new RuntimeException("not implemented");
    	TreeMap<String, Integer> ending = new TreeMap<>();
    	for(Edge it : edges) {
    		if(it.getSource().equals(source)) ending.put(new String(it.getTarget()), new Integer(it.getWeight()));
    	}
    	return ending;
    }
    // TODO constructor
    public ConcreteEdgesGraph() {
    }
    // TODO checkRep
    public void checkRep() {
        assert(edges.size() < vertices.size()*vertices.size());
    }
    // TODO toString()
    @Override 
    public String toString() {
        String ending = new String();
        for(Edge it : edges) {
        	ending = ending + it.getSource();
        	ending = ending + it.getTarget();
        	ending = ending + it.getWeight();
        }
        return ending;
    }
}

/**
 * TODO specification
 * Immutable.
 * This class is internal to the rep of ConcreteEdgesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Edge {
    
    // TODO fields
	// Representation invariant:
    //   TODO 
	private final String source;
    private final String target;
    private final String source1;
    private final String target1;
    private final Integer weight1; 
    private final Integer weight; 
    // TODO constructor
    public Edge(String source, String target, int weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
        this.source1 = source;
        this.target1 = target;
        this.weight1 = weight;
    }
    // TODO checkRep
    public boolean checkRep() {
        if(!source.equals(source1)) return false;
        if(!target.equals(target1)) return false;
        if(!weight.equals(weight1)) return false;
        return true;
    }
    // TODO methods
    // Safety from rep exposure:
    //   TODO 
    // Abstraction function:
    //   TODO 
    public Integer getWeight() {
    	 return new Integer(weight);//¶ÑÄÚ´æÖÐ
    }
    public String getSource() {
        return new String(source);
    }
    public String getTarget() {
    	return new String(target);
    }
    // TODO toString()
    @Override
    public String toString() {
        return source.toString() + "spaceforsplit" + target.toString() + "spaceforsplit" + weight.toString() ;
    }   
}
