package Solarsystem;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Solarsystem.Planet;
import Solarsystem.Stellar;

public class ConcreteCircularOrbit<L,E> implements CircularOrbit<L,E>{

	Set<Double> track = new HashSet<>();
	Stellar centralobj;
	List<Planet> physicalobj = new ArrayList<>();
	Set<Double> trackOn = new HashSet<>();
	final static Instant start = Instant.parse("2019-01-01T00:00:00Z");
	
	@Override
	public void setTrack(double radius) {
		// TODO Auto-generated method stub
	    assert radius > 0;
	    track.add(radius);
	}
	
	@Override
	public void removeTrack(double radius) {
		// TODO Auto-generated method stub
		assert radius > 0;
		track.remove(radius);
		for(int i=0; i<physicalobj.size(); i++) {
			if(physicalobj.get(i).getOrbitradius() == radius) {
				physicalobj.get(i).onTrack = false;
			}
		}
	}

    @Override
	public void setCentralObject(Stellar central) {
		// TODO Auto-generated method stub
    	if(centralobj == null) centralobj = central;
		
		else if(centralobj != null) {
			removeCentralObject(centralobj);
			centralobj = central;
		}
		
	}

	@Override
	public void removeCentralObject(Stellar central) {
		// TODO Auto-generated method stub
		if(centralobj == central) centralobj = null;
		
	}

	@Override
	public void setPhysicalObject(Planet orbitobject) {
		// TODO Auto-generated method stub
		
		if(track.contains(orbitobject.getOrbitradius())){
	       if(!trackOn.contains(orbitobject.getOrbitradius())) {
			   
	    	   physicalobj.add(orbitobject);
	    	   trackOn.add(orbitobject.getOrbitradius());
	    	   orbitobject.setOnTrack(true);
	       }
	    }
	 }

	@Override
	public void removePhysicalObject(Planet orbitobject) {
		// TODO Auto-generated method stub
		if(physicalobj.contains(orbitobject)) {
			physicalobj.remove(orbitobject);
			trackOn.remove(orbitobject.getOrbitradius());
			orbitobject.setOnTrack(false);
		}
		
	}

	@Override
	public Stellar findCentralObject(Planet orbitobject) {
		// TODO Auto-generated method stub
		if(centralobj != null) {
			return centralobj;
		}
		else return null;
		
	}
	@Override
	public Planet findPhysicalObject(String name) {
		// TODO Auto-generated method stub
		for(int i=0; i<physicalobj.size(); i++) {
			if(physicalobj.get(i).getName() == name) {
				return physicalobj.get(i);
			}
		}
		return null;
		
	}

	@Override
	public List<Planet> relationship(Stellar central) {
		// TODO Auto-generated method stub
		if(central == centralobj && !physicalobj.contains(null)) {
			return physicalobj;
		}
		return null;
	}
	
    public static double calculateAngle(Planet orbitobject) {
		
		double circumference = orbitobject.getOrbitradius()*Math.PI*(double)2;
		double angelpersecond = orbitobject.getIdlevelocity()/(circumference/(double)360);
		
		return angelpersecond;
	}
	
	

	

}




