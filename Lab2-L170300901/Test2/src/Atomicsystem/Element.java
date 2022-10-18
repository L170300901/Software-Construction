package Atomicsystem;

import java.util.ArrayList;
import java.util.List;

public class Element {

  public String name;// 이름,名字
  public int numberoftrack;// 트랙의 수
  List<Integer> numberofelecton = new ArrayList<>();// i+1궤도의 존재하는 전자의 갯수
  List<List<Electon>> electon = new ArrayList<>();// 궤도 하나당의 전자들의 집합
  List<Electon> realelecton = new ArrayList<>();

  /**
   * 
   */
  public void checkRep() {
    assert name != null;
    assert numberoftrack > 0;
    assert numberofelecton != null;
  }

  private void buildElectronic(int numberoftrack, String trackdata) throws Same {

    String[] args = trackdata.split("[;/]");
    assert args.length == numberoftrack * 2;
  }

  public Element(String name, int numberoftrack, List<Integer> numberofelecton) {


    Electon ele = new Electon();

    this.name = name;
    this.numberoftrack = numberoftrack;
    this.numberofelecton = numberofelecton;
    checkRep();

    for (int i = 0; i < this.numberofelecton.size(); i++) {// electon 리스트에 번호를 매긴 후 그 번호안에 전자들의 객체를
                                                           // 집어넣는다
      for (int j = 0; j < this.numberofelecton.get(i); j++) {

        try {
          realelecton.add(j, ele);
          realelecton.get(j).numberthoforbit = i + 1;
        } catch (ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException e) {
          e.getMessage();
        }

      }
      electon.add(i, realelecton);
    }
  }

  public String getName() {
    return name;
  }

  public int numberofatom() {
    return numberoftrack;
  }

  public List<Integer> getNumberofeleton() {
    return numberofelecton;
  }

}
