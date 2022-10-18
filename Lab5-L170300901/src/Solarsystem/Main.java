package Solarsystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Main obj = new Main();


    ConcreteCircularOrbit<Stellar, Planet> ste = new ConcreteCircularOrbit<>();
    Stellar Sun = new Stellar("Sun", 6.96392e5, 1.9885e30);
    Planet Earth = new Planet("Earth", "Solid", "Blue", 6378.137, 1.49e8, 29.783, "CW", 0);
    Planet Mars = new Planet("Mars", "Silid", "Red", 637.137, 9.99e10, 1000.93, "CCW", 110);
    Planet Earth1 = new Planet("Earth", "Solid", "Blue", 6378.137, 1.49e8, 29.783, "CW", 0);

    ste.setCentralObject(Sun);
    ste.setTrack(1.49e8);
    ste.setTrack(9.99e10);
    ste.setPhysicalObject(Earth);
    ste.setPhysicalObject(Mars);
    ste.setPhysicalObject(Earth1);



    ste.presentPosition();
    CircularOrbitAPI<Stellar, Planet> api = new CircularOrbitAPI<>();

    try (BufferedReader bw = new BufferedReader(new FileReader("String.txt"))) {

      int str;

      while (true) {
        str = bw.read();
        if (str == -1) {
          break;
        }
        System.out.println((char) str);
      }

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }


  }


}
