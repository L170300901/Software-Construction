package Atomicsystem;
import java.util.ArrayList;
import java.util.List;



public interface CircularOrbit<L,E> {

	void setTrack(Element element);
	
	void removeTrack(Element element);
	
	void setElement(Element element);
	
	void removeElement(Element element);
	
	void transit(Element element, int track);
		 
}
