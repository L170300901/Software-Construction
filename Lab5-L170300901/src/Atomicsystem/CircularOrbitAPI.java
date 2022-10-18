package Atomicsystem;

public class CircularOrbitAPI<L, E> {

  static void getDifference(Element e1, Element e2) {

    int m;
    if (e1.numberofelecton.size() > e2.numberofelecton.size()) {
      m = e1.numberofelecton.size();

    } else {
      m = e2.numberofelecton.size();
    }

    for (int i = 0; i < m; i++) {
      int size = e1.numberofelecton.get(i) - e2.numberofelecton.get(i);
      System.out.println("number of orbit " + (i + 1) + " diffrence of 1 and 2 " + size);

    }
  }
}
