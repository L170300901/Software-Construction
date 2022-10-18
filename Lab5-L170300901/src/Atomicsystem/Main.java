package Atomicsystem;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    ConcreteCircularOrbit<Electon, Element> ato = new ConcreteCircularOrbit<>();
    CircularOrbitAPI<Electon, Element> api = new CircularOrbitAPI<>();



    Element rb = new Element("Rb", 5, Arrays.asList(2, 8, 18, 8, 1));
    Element rc = new Element("Rc", 5, Arrays.asList(2, 8, 15, 6, 2));
    Element rd = new Element("Rb", 5, Arrays.asList(2, 8, 15, 6, 2));

    api.getDifference(rb, rc);
    ato.setTrack(rb);
    ato.setTrack(rd);
    ato.setElement(rb);
    ato.setElement(rd);


    SBox box1 = new SBox("rb");

    try (ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream("Object.dat"))) {

      oo.writeObject(box1);

    } catch (FileNotFoundException e) { // TODO Auto-generated catch block e.printStackTrace();
    }

    catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
    }



  }
}


