package Atomicsystem;

/**
 * �������̽�.
 * 
 * @author ����ä
 *
 * @param <L> Element�� ���� �׸�
 * @param <E> Electon�� ���� �׸�
 */
public interface CircularOrbit<L, E> {

  void setTrack(Element element);

  void removeTrack(Element element);

  void setElement(Element element);

  void removeElement(Element element);

  void transit(Element element, int track);

}
