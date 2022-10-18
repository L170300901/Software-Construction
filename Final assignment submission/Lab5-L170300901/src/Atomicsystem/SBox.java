package Atomicsystem;


/**
 * 입출력의 대상이 되는 인스턴스의 클래스는 java.....을 구현해야한다.
 * 
 * @author 정민채
 *
 */
public class SBox implements java.io.Serializable {
  String s;

  public SBox(String s) {
    this.s = s;
  }

  public String get() {
    return s;
  }

}
