package Solarsystem;

class Stellar {

	public String name;
	public Double radius;
	public Double mass;
	
	public Stellar(String name, Double radius, Double mass) {
		this.name = name;
		this.radius = radius;
		this.mass = mass;
	}
	
	public String getName() {
		return name;
	}
	public Double getRadius() {
		return radius;
	}
	public Double getMass() {
		return mass;
	}
}
