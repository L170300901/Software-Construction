/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.poet;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import P1.graph.Graph;

/**
 * A graph-based poetry generator.
 * 
 * <p>GraphPoet is initialized with a corpus of text, which it uses to derive a
 * word affinity graph.
 * Vertices in the graph are words. Words are defined as non-empty
 * case-insensitive strings of non-space non-newline characters. They are
 * delimited in the corpus by spaces, newlines, or the ends of the file.
 * Edges in the graph count adjacencies: the number of times "w1" is followed by
 * "w2" in the corpus is the weight of the edge from w1 to w2.
 * 
 * <p>For example, given this corpus:
 * <pre>    Hello, HELLO, hello, goodbye!    </pre>
 * <p>the graph would contain two edges:
 * <ul><li> ("hello,") -> ("hello,")   with weight 2
 *     <li> ("hello,") -> ("goodbye!") with weight 1 </ul>
 * <p>where the vertices represent case-insensitive {@code "hello,"} and
 * {@code "goodbye!"}.
 * 
 * <p>Given an input string, GraphPoet generates a poem by attempting to
 * insert a bridge word between every adjacent pair of words in the input.
 * The bridge word between input words "w1" and "w2" will be some "b" such that
 * w1 -> b -> w2 is a two-edge-long path with maximum-weight weight among all
 * the two-edge-long paths from w1 to w2 in the affinity graph.
 * If there are no such paths, no bridge word is inserted.
 * In the output poem, input words retain their original case, while bridge
 * words are lower case. The whitespace between every word in the poem is a
 * single space.
 * 
 * <p>For example, given this corpus:
 * <pre>    This is a test of the Mugar Omni Theater sound system.    </pre>
 * <p>on this input:
 * <pre>    Test the system.    </pre>
 * <p>the output poem would be:
 * <pre>    Test of the system.    </pre>
 * 
 * <p>PS2 instructions: this is a required ADT class, and you MUST NOT weaken
 * the required specifications. However, you MAY strengthen the specifications
 * and you MAY add additional methods.
 * You MUST use Graph in your rep, but otherwise the implementation of this
 * class is up to you.
 */
public class GraphPoet {
    
    private final Graph<String> graph = Graph.empty();
    
    // Abstraction function:
    //   TODO
    // Representation invariant:
    //   TODO
    // Safety from rep exposure:
    //   TODO
    
    /**
     * Create a new poet with the graph from corpus (as described above).
     * 
     * @param corpus text file from which to derive the poet's affinity graph
     * @throws IOException if the corpus file cannot be found or read
     */
    public GraphPoet(File corpus) throws IOException {
        //throw new RuntimeException("not implemented");
        Scanner sc = new Scanner(corpus);
        sc.useDelimiter("\\s|[.,]");
        List<String> list = new ArrayList<>();
        while(sc.hasNext()){
            String string = sc.next();
            if(string.length()>0)
                list.add(string.toLowerCase());
        }
        sc.close();        
        int i=0;
        while(i<list.size()-1){
            String start = list.get(i);
            String end = list.get(i+1);
            int count = 1;
            i++;
            while(i<list.size()-1&&list.get(i+1).equals(end)){
                i++;count++;
            }
            
            graph.set(start, end, count);
        }
    }
    
    // TODO checkRep
    
    /**
     * Generate a poem.
     * 
     * @param input string from which to create the poem
     * @return poem (as described above)
     */
    public String poem(String input) {
       // throw new RuntimeException("not implemented");
    	String ending = new String();
    	if(input.length()<=0) throw new RuntimeException("Ilegal input");
    	Scanner sc = new Scanner(input);
        sc.useDelimiter("\\s");
        ArrayList<String> words = new ArrayList<>();
        while(sc.hasNext()){
            String temp = sc.next();
            if(temp.length()>0)
                words.add(temp);
        }
        sc.close();
        for(int i = 0; i < words.size() - 1;i ++) {
        	String source1 = words.get(i);
        	String target1 = words.get(i + 1);
        	int max = 0;
        	String addf = new String();
        	Map<String,Integer> start=  graph.targets(source1.toLowerCase());
        	for(String it1 : start.keySet()) {
        		int inttemp1 = start.get(it1.toLowerCase());
        		Map<String,Integer> startt=  graph.targets(it1.toLowerCase());
        		for(String it2 : startt.keySet()) {
        			int inttemp2 = startt.get(it2);
        			if(inttemp1 + inttemp2 >=max&&it2.equals(target1)) {
        				max = inttemp1 +inttemp2;
        				addf = it1;
        			}
        		}
        	}
        	if(addf.length()!=0) words.add(i + 1, addf);
        }
        String ending0 = new String();
        for(int i = 0 ;i < words.size();i++) {
        	ending0 = ending0 + words.get(i);
        	if(i!=words.size()-1) ending0 = ending0 + " ";
        }
        return ending0;
    }
    
    // TODO toString()
    public String toString() {
        return graph.toString();
    }
}
