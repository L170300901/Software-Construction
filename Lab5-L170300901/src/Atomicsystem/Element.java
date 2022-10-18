package Atomicsystem;

import java.util.ArrayList;
import java.util.List;

public class Element {

  public String name;// �̸�,٣�
  public int numberoftrack;// Ʈ���� ��
  List<Integer> numberofelecton = new ArrayList<>();// i+1�˵��� �����ϴ� ������ ����
  List<List<Electon>> electon = new ArrayList<>();// �˵� �ϳ����� ���ڵ��� ����
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

    for (int i = 0; i < this.numberofelecton.size(); i++) {// electon ����Ʈ�� ��ȣ�� �ű� �� �� ��ȣ�ȿ� ���ڵ��� ��ü��
                                                           // ����ִ´�
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
