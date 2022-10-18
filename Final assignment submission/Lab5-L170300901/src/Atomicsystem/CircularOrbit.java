package Atomicsystem;

/**
 * 인터페이스.
 * 
 * @author 정민채
 *
 * @param <L> Element를 담을 그릇
 * @param <E> Electon을 담을 그릇
 */
public interface CircularOrbit<L, E> {

  void setTrack(Element element);

  void removeTrack(Element element);

  void setElement(Element element);

  void removeElement(Element element);

  void transit(Element element, int track);

}
