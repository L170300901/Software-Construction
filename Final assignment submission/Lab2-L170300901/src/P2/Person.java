package P2;

import java.util.HashMap;
import java.util.Map;

public class Person {   
    boolean isVisited = false;
    private String name;
    Map<String, Integer> nextVertex = new HashMap<>();

    public String getName() {
        return name;
    }

    public Map<String, Integer> getNextVertex() {
        return nextVertex;
    }

    public void setNextVertex(Map<String, Integer> nextVertex) {
        this.nextVertex = nextVertex;
    }
    
    public Person(String name,Map<String, Integer> nextVertex){
        this.name = name;
        this.nextVertex = nextVertex;
    }
    
    public String toSring() {
        String ending = new String();
        for(String key:nextVertex.keySet())
        {
            ending = ending + key;
        }
        
        return ending;
    }
}
