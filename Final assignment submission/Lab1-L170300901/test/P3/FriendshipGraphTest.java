package P3;
import P3.Person;
import P3.FriendshipGraph;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
public class FriendshipGraphTest {
	Person abc=new Person("zyk");
	Person cde=new Person("zmc");
	Person efg=new Person("lch");
	Person ghi=new Person("gyl");
	ArrayList<Person> vertextest =new ArrayList<Person>();
	FriendshipGraph graph=new FriendshipGraph();
	
	
	@Test
	 public void addVertexTest() {
	  vertextest.add(abc);
	  graph.addVertex(abc);
	  assertEquals(vertextest, graph.GetArray());
	  
	  vertextest.add(cde);
	  graph.addVertex(cde);
	  assertEquals(vertextest, graph.GetArray());
	  graph.addVertex(efg);
	  vertextest.add(efg);
	  assertEquals(vertextest, graph.GetArray());
	  graph.addVertex(ghi);
	  vertextest.add(ghi);
	  assertEquals(vertextest, graph.GetArray());
	  
	  
	}
}
