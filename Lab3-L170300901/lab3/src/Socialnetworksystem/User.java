package Socialnetworksystem;

public class User {

	public String name;
	public int age;
	public String sex;
	
	public User(String name, int age, String sex){
		
		this.name =  name;
		this.age =  age;
		this.sex =  sex;
		
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getSex() {
		return sex;
	}
	
}
