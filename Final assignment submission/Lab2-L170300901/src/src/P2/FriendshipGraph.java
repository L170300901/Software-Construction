package P2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import P1.graph.ConcreteVerticesGraph;

public class FriendshipGraph extends ConcreteVerticesGraph<String>{
 
    static List<Person> list = new ArrayList<>();
    
    /*public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Map<String, Integer> map3 = new HashMap<>();
        Map<String, Integer> map4 = new HashMap<>();
        
        Person rachel = new Person("Rachel", map1);
        Person ross = new Person("Ross", map2);
        Person ben = new Person("Ben", map3);
        Person kramer = new Person("Kramer", map4);
        
        FriendshipGraph.addVertex(rachel);
        FriendshipGraph.addVertex(ross);
        FriendshipGraph.addVertex(ben);
        FriendshipGraph.addVertex(kramer);
        
        FriendshipGraph.addEdge(rachel,ross);
        FriendshipGraph.addEdge(ross,rachel);
        FriendshipGraph.addEdge(ross,ben);
        FriendshipGraph.addEdge(ben,ross);
        

        System.out.println(FriendshipGraph.getDistance(rachel,ross));
        FriendshipGraph.init();
        System.out.println(FriendshipGraph.getDistance(ross,kramer));
        FriendshipGraph.init();
        System.out.println(FriendshipGraph.getDistance(rachel,ben));
    }*/
    
    public static void addEdge(Person p1,Person p2){
        p1.nextVertex.put(p2.getName(), 1);
    }
    
    public static void addVertex(Person p){
        for(Person person:list)
        {
            if(person.getName().equals(p.getName()))   throw new RuntimeException("same");
        }
        list.add(p);
    }
    
    public static Person getPerson(String name) {
        int length = list.size();
        Person person = null;
        for(int i=0;i<length;i++)
        {
             person = list.get(i);
             if(person.getName().equals(name))
                 return person;
        }
        throw new RuntimeException("not have");
    }
    
    public static void init() {
        for(Person person:list)
        {
            person.isVisited = false;
        }
    }
    public static int getDistance(Person p1,Person p2) {
        Person p = null;
        int location = 0;
        boolean isFinded = false;
        int flag = 1;
        List<String> list = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        for(Entry<String, Integer> map:p1.nextVertex.entrySet()){
            list.add(map.getKey());
        }
        for(int j=0;;j++) {
        	if(list.size() == 0) {
        		break;
        	}
        	String name = list.get(location);
            p = getPerson(name);
            p.isVisited = true;
            if(p.getName().equals(p2.getName())||p.getName()==p2.getName()){
                isFinded = true;
            }
            else{
                for(String key:p.nextVertex.keySet()){
                   if(getPerson(key).isVisited==false){
                       list1.add(key);
                   }
                }
            }
            if(isFinded)
                return flag;
            location++;
            if(location==list.size()){
                list = new ArrayList<>();
                for(int i=0;i<list1.size();i++)
                    list.add(list1.get(i));
                flag++;
                list1 = new ArrayList<>();
                location = 0;
            }
        }
        return -1;
    }
}
