package Atomicsystem;

import java.util.ArrayList;
import java.util.List;



public class ConcreteCircularOrbit<L, E> implements CircularOrbit<L, E> {

  List<Integer> track = new ArrayList<>();// array list로 몇 번째 트랙을 표현
  List<Integer> trackOn = new ArrayList<>();// 트랙에 전자가 있을 때 1 없을 때 0
  List<Element> elem = new ArrayList<>();
  public int numberofatom;
  int numberoftrack;

  public Element readname(Element orbitobj) throws SameException {

    for (int i = 0; i < elem.size(); i++) {
      if ((elem.get(i).getName()).equals(orbitobj.getName()) || (elem.get(i).electon).equals(orbitobj.electon)) {
        throw new SameException();
      }
    }

    return orbitobj;

  }

  @Override
  public void setTrack(Element element) {
    // 전자를 담을 트랙만 생성해놓는다.
    // TODO Auto-generated method stub
    for (int i = 0; i < element.numberofelecton.size(); i++) {
      if (track.isEmpty()) {
        track.add(i, 0);
      }
    }

  }

  @Override
  public void removeTrack(Element element) {
    // 모든 트랙을 삭제한다.
    // TODO Auto-generated method stub
    if (!track.isEmpty()) {
      track.removeAll(track);
    }

  }

  @Override
  public void setElement(Element element) {
    // 트랙에 element를 설정한다
    // TODO Auto-generated method stub
    try {
      readname(element);
      if (!track.isEmpty()) {
        for (int i = 0; i < element.electon.size(); i++) {
          track.add(i, element.electon.get(i).size());
          elem.add(i, element);

          for (int j = 0; j < element.electon.get(i).size(); j++) {

            element.electon.get(i).get(j).onTrack = true;
            // 트랙위에 올라갔을 때 onTrack의 값이 true로 됨
          }
        }
      }
      numberoftrack = track.size();
    } catch (SameException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());
    }
  }


  @Override
  public void removeElement(Element element) {
    // TODO Auto-generated method stub
    if (!track.isEmpty()) {
      for (int i = 0; i < element.numberofelecton.size(); i++) {
        track.remove(i);
        track.add(i, 0);
      }
    }
  }

  @Override
  public void transit(Element element, int track) {
    // TODO Auto-generated method stub
    int max;
    Electon ele = new Electon();

    if (track - 2 >= 0) {

      for (int i = 0; i < element.numberofelecton.size(); i++) {
        for (int j = 0; j < element.numberofelecton.size(); j++) {
          while (element.numberofelecton.get(track - 2) != null) {
            max = (int) (2 * (Math.pow(track, 2)));

            while (element.numberofelecton.get(track - 1) < max) {
              if (element.electon.get(i) != null) {

                element.electon.get(i).remove(j);
                element.numberofelecton.add(element.numberofelecton.get(i) - 1);

                if (element.electon.get(track - 1).get(j) == null) {

                  element.electon.get(track - 1).add(j, ele);
                  element.electon.get(track - 1).get(j).numberthoforbit = track - 1;
                }

              }
            }
          }

        }
      }

      for (int i = 0; i < element.numberofelecton.size(); i++) {
        for (int j = 0; j < element.numberofelecton.size(); j++) {
          while (element.numberofelecton.get(track - 2) != null) {
            max = (int) (2 * (Math.pow(track + 1, 2)));

            while (element.numberofelecton.get(track) < max) {

              if (element.electon.get(i) != null) {

                element.electon.get(i).remove(j);
                element.numberofelecton.add(element.numberofelecton.get(i) - 1);

                if (element.electon.get(track - 1).get(j) == null) {

                  element.electon.get(track - 1).add(j, ele);
                  element.electon.get(track - 1).get(j).numberthoforbit = track - 1;
                }

              }
            }
          }

        }
      }
      for (int i = 0; i < element.numberofelecton.size(); i++) {
        for (int j = 0; j < element.numberofelecton.size(); j++) {
          while (element.numberofelecton.get(track - 2) != null) {
            max = (int) (2 * (Math.pow(track + 2, 2)));

            while (element.numberofelecton.get(track + 1) < max) {

              if (element.electon.get(i) != null) {

                element.electon.get(i).remove(j);
                element.numberofelecton.add(element.numberofelecton.get(i) - 1);

                if (element.electon.get(track - 1).get(j) == null) {

                  element.electon.get(track - 1).add(j, ele);
                  element.electon.get(track - 1).get(j).numberthoforbit = track - 1;
                }

              }
            }
          }

        }
      }
    }


  }



}


