package Solarsystem;

import java.util.List;

import Solarsystem.Planet;

public interface CircularOrbit<L,E> {

	 void setTrack(double radius);//make a track
	 
	 void removeTrack(double radius);//remove a track
	 
	 void setCentralObject(Stellar central);//set central object
	 
	 void removeCentralObject(Stellar central);//remove central object
	 
	 void setPhysicalObject(Planet orbitobject);//set physical object
	 
	 void removePhysicalObject(Planet orbitobject);//remove physical object
	 
	 Stellar findCentralObject(Planet orbitobject);
	 
	 Planet findPhysicalObject(String name);
	 
	 List<Planet> relationship(Stellar central);

	 
}
