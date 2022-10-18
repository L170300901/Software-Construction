package P3;

import java.util.ArrayList;

public class FriendshipGraph {
	  ArrayList<Person> list1=new ArrayList();
	  ArrayList<Person> list2=new ArrayList();
	public void addVertex(Person name) {
		list1.add(name);
		 }
		public ArrayList<Person> GetArray()
		 {
		  return list1;
		 }
		 public void addEdge(Person name1,Person name2){
		  list1.get(list1.indexOf(name1)).friend(name2);
		  list1.get(list1.indexOf(name2)).friend(name1);
		 }
		 public int getDistance(Person name1,Person name2) {
			  int dis=-1;
			  int arr[][]=new int [list1.size()][list1.size()];
			  int path[][]=new int [list1.size()][list1.size()];
			  for(int i=0;i<list1.size();i++)
			  {
			   for(int j=0;j<list1.size();j++)
			   {
			    arr[i][j]=999;
			    path[i][j]=-1;
			   }
			  }
			  for(int i=0;i<list1.size();i++)
			  {
			   list2=list1.get(i).friendship();
			   for(int j=0;j<list2.size();j++)
			   {
			    arr[list1.indexOf(list1.get(i))][list1.indexOf(list2.get(j))]=1;
			    arr[list1.indexOf(list2.get(j))][list1.indexOf(list1.get(i))]=1;
			   }
			  }
			  for(int k=0;k<list1.size();k++)
			  {
			   for(int i=0;i<list1.size();i++)
			   {
			    for(int j=0;j<list1.size();j++)
			    {
			     if(i!=j&&i!=k&&j!=k&&arr[i][k]+arr[k][j]<arr[i][j]) {
			                     arr[i][j]=arr[i][k]+arr[k][j];
			                     path[i][j]=arr[i][j];
			                 }
			    }
			   }
			  }
			  dis=arr[list1.indexOf(name1)][list1.indexOf(name2)];
			  if(list1.indexOf(name1)==list1.indexOf(name2))
			  {
			   dis=0;
			  }
			  if(dis==999)
			  {
			   dis=-1;
			  }
			  return dis;
			 }

			
	public static void main(String[] args) {
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		System.out.println(graph.getDistance(rachel, ross)); 
		//should print 1
		System.out.println(graph.getDistance(rachel, ben)); 
		//should print 2
		System.out.println(graph.getDistance(rachel, rachel)); 
		//should print 0
		System.out.println(graph.getDistance(rachel, kramer)); 
		//should print -1


	}

}
