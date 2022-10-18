package Solarsystem;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class ConcreteCircularOrbit<L, E> implements CircularOrbit<L, E> {

  Set<Double> track = new HashSet<>();
  Stellar centralobj;
  List<Planet> physicalobj = new ArrayList<>();
  Set<Double> trackOn = new HashSet<>();// 占쎈뱜占쎌삌占쎈퓠 占쎈뻬占쎄쉐占쎌뵠 占쎌뿳占쎈뮉筌욑옙 占쎈씨占쎈뮉筌욑옙�몴占� 占쎄돌占쏙옙占쎄땀占쎈뮉
                                        // 占쎈퉸占쎈룴占쎈��, 占쎈뻬占쎄쉐占쎌뵠
                                        // 占쎌뿳占쎈뼄筌롳옙 占쎈퉸占쎈뼣占쎈뱜占쎌삌占쎌벥 獄쏆꼷占썹뵳袁⑹뵠
                                        // 占쏙옙占쎌삢占쎈┷占쎈선占쎌뿳占쎈뼄占쎄랬�렰耀붴몾嫄よ쯁占�,占쎌맋雅╈넂�맋�깗�슙�궃占쎌돦
                                        // hash set �산퇌�삏占쎌맋�깗�슙�궃塋딅슗沅볢�띠꼯占쏙옙沅띹쯁�굠�돁占쎄괭占쎌돦占쎈쐡耶껓옙
  final static Instant start = Instant.parse("2019-01-01T00:00:00Z");

  public Planet readname(Planet orbitobj) throws SameException {

    for (int i = 0; i < physicalobj.size(); i++) {
      if ((physicalobj.get(i).getName()).equals(orbitobj.getName())) {
        throw new SameException();
      }
    }

    return orbitobj;

  }

  @Override
  public void setTrack(double radius) {
    // TODO Auto-generated method stub
    assert radius > 0;
    track.add(radius);
  }

  @Override
  public void removeTrack(double radius) {
    // TODO Auto-generated method stub
    assert radius > 0;
    track.remove(radius);
    for (int i = 0; i < physicalobj.size(); i++) {
      if (physicalobj.get(i).getOrbitradius() == radius) {
        physicalobj.get(i).onTrack = false;
      }
    }
  }

  @Override
  public void setCentralObject(Stellar central) {
    // TODO Auto-generated method stub
    if (centralobj == null)
      centralobj = central;

    else if (centralobj != null) {

      try {
        removeCentralObject(centralobj);
        centralobj = central;
      } catch (NullPointerException e) {
        e.getMessage();
      }
    }

  }

  @Override
  public void removeCentralObject(Stellar central) {
    // TODO Auto-generated method stub
    if (centralobj == central)
      centralobj = null;

  }

  @Override
  public void setPhysicalObject(Planet orbitobject) {
    // TODO Auto-generated method stub

    try {
      if (track.contains(readname(orbitobject).getOrbitradius())) {
        if (!trackOn.contains(readname(orbitobject).getOrbitradius())) {// 占쎈뱜占쎌삌占쎈퓠 占쎈툡�눧占�
                                                                        // 占쎈뻬占쎄쉐占쎈즲 占쎈씨占쎌뱽
                                                                        // 野껋럩�뒭占쎈퓠塋딅슜�녉占쎄괭鼇앸�源뱄옙�맋繞볦궊�맟�깗�슙�궃占쎈옅

          physicalobj.add(readname(orbitobject));
          trackOn.add(orbitobject.getOrbitradius());
          orbitobject.setOnTrack(true);
        }
      }
    } catch (SameException e) {
      // TODO Auto-generated catch block
      System.out.println(e.getMessage());

    }

  }

  @Override
  public void removePhysicalObject(Planet orbitobject) {
    // TODO Auto-generated method stub
    if (physicalobj.contains(orbitobject)) {
      physicalobj.remove(orbitobject);
      trackOn.remove(orbitobject.getOrbitradius());
      orbitobject.setOnTrack(false);
    }

  }

  @Override
  public Stellar findCentralObject(Planet orbitobject) {
    // TODO Auto-generated method stub
    if (centralobj != null) {
      return centralobj;
    } else
      return null;

  }

  @Override
  public Planet findPhysicalObject(String name) {
    // TODO Auto-generated method stub
    for (int i = 0; i < physicalobj.size(); i++) {
      if (physicalobj.get(i).getName().equals(name)) {
        return physicalobj.get(i);
      }
    }
    return null;

  }

  @Override
  public List<Planet> relationship(Stellar central) {
    // TODO Auto-generated method stub
    if (central == centralobj && !physicalobj.contains(null)) {
      return physicalobj;
    }
    return null;
  }

  @SuppressWarnings("finally")
  public static double calculateAngle(Planet orbitobject) {

    double circumference = orbitobject.getOrbitradius() * Math.PI * 2;// 占쎌뜚占쎌벥 占쎈ぎ占쎌쟿,占쎌맆占쎌돦占쎈쳟占쎌럪
    double angelpersecond = 0;
    try {
      angelpersecond = orbitobject.getIdlevelocity() / (circumference / 360);// 1�룯�뜄�뼣
                                                                             // 占쏙옙筌욊낯�뵠占쎈뮉
                                                                             // 揶쏄낮猷꾤쳥�슙罹��뇖誘㏓츚�뇖�궍�뮣占쎌돦欲뀀�ｋ꺌
    } catch (ArithmeticException e) {
      e.getMessage();
    } finally {

      return angelpersecond;
    }



  }

  @SuppressWarnings("finally")
  public double presentAngle(Planet orbitobject) {

    Instant now = Instant.now();
    Duration between = Duration.between(start, now);
    double therestangle;
    int sec = (int) between.toSeconds();// 占쎄퐬占쎌젟占쎈퉸占쎈꼦占쏙옙 占쎈뻻揶쏄쑨�궢 占쎌겱占쎌삺占쎈뻻揶쏄쑴�벥 筌△뫀占쏙옙 �룯�뜄以�
                                        // 占쎄돌占쏙옙占쎄퉪塋딅슙�깙埇쎈툋占쎌뼃痢ｏ옙�돦占쎈옅占쎈였�썒�슗琉뉛옙�젧占쎌몛占쎌돦占쎈옅占쎈였占쎌돦�뿥占쏙옙占�
    try {
      therestangle = (calculateAngle(orbitobject) * sec) % 360;// �⑤벊�읈占쎌뱽 占쎈립 占쎌뜎
                                                               // 360占쎈즲嚥∽옙 占쎄돌占쎈떊占쎄퐣
                                                               // 占쎄돌�솒紐꾬옙 揶쏄낮猷꾤몴占�
                                                               // �뤃�뗫맙,癲됯퇊��俑앹늺彛쒍쉴占�
    } catch (NoSuchMethodError e) {
      e.getMessage();
    } finally {

      therestangle = (calculateAngle(orbitobject) * sec) % 360;

      if (orbitobject.getDirection() == "CW") {// �⑤벊�읈獄쎻뫚堉�占쎌뵠 占쎈뻻�④쑬媛묕옙堉�占쎌뵬
                                               // 占쎈르塋딅슗�띌쪛�꾨섬占쎈┣占쎌궦囹덈렇肉띰옙萸뱄옙堉띰옙由뀐옙肉�
        double presentangle = therestangle + orbitobject.getAngle();
        return presentangle;

      } else {// �⑤벊�읈 獄쎻뫚堉�占쎌뵠 獄쏆꼷�뻻�⑨옙 獄쎻뫚堉�占쎌뵬 占쎈르塋딅슗�띌쪛�꾨섬占쎈┣占쎌궦囹덈렇肉띰옙萸뱄옙猷륅옙堉띰옙由뀐옙肉�
        double presentangle = -(therestangle) + orbitobject.getAngle();
        return presentangle;
      }
    }


  }



  public void presentPosition() {// 筌뤴뫀諭븝옙六억옙苑�占쎌벥 占쎌겱占쎌삺 揶쏄낮猷꾤몴占�
                                 // 占쎄돌占쏙옙占쎄땀占쎈선餓λ슪�렰占쎌깙埇쎈렇占쏙옙�맋占쎌돦�깗�슙�궃占쎌돦欲뀀�ｋ꺌

    try {
      for (int i = 0; i < physicalobj.size(); i++) {
        System.out.println(physicalobj.get(i).getName() + " " + presentAngle(physicalobj.get(i)));
        System.out.println();
      }
    } catch (NumberFormatException e) {
      e.getMessage();
    }

  }



}


