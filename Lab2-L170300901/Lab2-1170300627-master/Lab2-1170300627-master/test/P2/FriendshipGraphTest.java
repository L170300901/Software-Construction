package P2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class FriendshipGraphTest {

    /**
     * 
     */
    @Test
    public void getDistanceTest() {
       // fail("Not yet implemented");
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();
        Map<String, Integer> map4 = new HashMap<>();
        Map<String, Integer> map5 = new HashMap<>();
        Map<String, Integer> map6 = new HashMap<>();
        Map<String, Integer> map7 = new HashMap<>();
        
        Person P1 = new Person("1",map1);
        Person P2 = new Person("2",map2);
        Person P3 = new Person("3",map3);
        Person P4 = new Person("4",map4);
        Person P5 = new Person("5",map5);
        Person P6 = new Person("6",map6);
        Person P7 = new Person("7",map7);
        
        FriendshipGraph.addVertex(P1);
        FriendshipGraph.addVertex(P2);
        FriendshipGraph.addVertex(P3);
        FriendshipGraph.addVertex(P4);
        FriendshipGraph.addVertex(P5);
        FriendshipGraph.addVertex(P6);
        FriendshipGraph.addVertex(P7);

        FriendshipGraph.addEdge(P1,P2);
        FriendshipGraph.addEdge(P2,P1);
        FriendshipGraph.addEdge(P1,P3);
        FriendshipGraph.addEdge(P3,P1);
        FriendshipGraph.addEdge(P2,P4);
        FriendshipGraph.addEdge(P4,P2);
        FriendshipGraph.addEdge(P3,P4);
        FriendshipGraph.addEdge(P4,P3);
        FriendshipGraph.addEdge(P3,P5);
        FriendshipGraph.addEdge(P5,P3);
        FriendshipGraph.addEdge(P5,P6);
        FriendshipGraph.addEdge(P6,P5);

        assertEquals(2, FriendshipGraph.getDistance(P1,P4));
        assertEquals(3, FriendshipGraph.getDistance(P1,P6));
        assertEquals(-1, FriendshipGraph.getDistance(P2,P7));
    }
    
    @Test
    public void addVertexTest()
    {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();
        Map<String, Integer> map4 = new HashMap<>();
        
        Person rachel = new Person("Rachel",map1);
        Person ross = new Person("Ross",map2);
        Person ben = new Person("Ben",map3);
        Person kramer = new Person("Kramer",map4);
        
        ArrayList<Person> al = new ArrayList<Person>();
        al.add(rachel);
        al.add(ross);
        al.add(ben);
        al.add(kramer);

        for(int i=0;i<FriendshipGraph.list.size();i++)
            assertEquals(((Person)al.get(i)).getName(), ((Person)FriendshipGraph.list.get(i)).getName());
    }
    
    @Test
    public void addEdgeTest()
    {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();
        Map<String, Integer> map4 = new HashMap<>();
        
        Person rachel = new Person("Rachel",map1);
        Person ross = new Person("Ross",map2);
        Person ben = new Person("Ben",map3);
        Person kramer = new Person("Kramer",map4);
        
        rachel.nextVertex.put(ross.getName(), 1);
        ross.nextVertex.put(rachel.getName(),1);
        ross.nextVertex.put(ben.getName(),1);
        ben.nextVertex.put(ross.getName(), 1);
        
        ArrayList<Person> al = new ArrayList<Person>();
        al.add(rachel);
        al.add(ross);
        al.add(ben);
        al.add(kramer);

        for(int i=0;i<FriendshipGraph.list.size();i++)
        {
            assertEquals(((Person)al.get(i)).nextVertex,(FriendshipGraph.list.get(i)).nextVertex);
        }
    }
}