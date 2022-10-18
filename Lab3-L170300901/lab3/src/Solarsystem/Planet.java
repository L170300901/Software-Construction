package Solarsystem;

public class Planet {

	public String name;
	public String form;
	public String color;
	public double planetradius;
	public double orbitradius;
	public double idlevelocity;
	public String direction;
	public double angle;
	public boolean onTrack = false;
	
	public Planet(String name, String form, String color, double planetradius, 
			     double orbitradius, double idlevelocity,String direction, double angle) {
		
		this.name = name;
		this.form = form;
		this.color = color;
		this.planetradius = planetradius;
		this.orbitradius = orbitradius;
		this.idlevelocity = idlevelocity;
		this.direction = direction;
		this.angle = angle;
	}
	
	

	public String getName() {
		return name;
	}
	public String getForm() {
		return form;
	}
	public String getColor() {
		return color;
	}
	public double getPlanetradius() {
		return planetradius;
	}
	public double getOrbitradius() {
		return orbitradius;
	}
	public double getIdlevelocity() {
		return idlevelocity;
	}
	public String getDirection() {
		return direction;
	}
	public double getAngle() {
		return angle; 
	}			
	public boolean setOnTrack(boolean s) {
		return onTrack = s;
	}
	
}
