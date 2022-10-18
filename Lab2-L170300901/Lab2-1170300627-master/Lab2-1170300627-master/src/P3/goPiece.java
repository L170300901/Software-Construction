package P3;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class goPiece implements Piece{
    public void Piece(int a1,int a2) throws  IOException {
        ArrayList<String> golist = new ArrayList();
        ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("src/P3/godata.temp") );
        try {
            while( (golist=(ArrayList<String>)input.readObject()) != null ) {
                ;
            }
        } catch(ClassNotFoundException ex) {}
        catch(EOFException eofex) {}
        input.close();
        if((a1<0||a1>17)||(a2<0||a2>17)) {
            System.out.println("哼唧~越界了~喵喵喵~~~");
        }else {
            if(golist.get(18*18).equals("hei")) {
                if(golist.get(a1*18+a2).contains("黑")) {
                    System.out.println("哼唧~自己不能吃自己~喵喵喵~~~");
                }
                else {
                    if(golist.get(a1*18+a2).contains("白")) {
                        golist.remove(a1*18+a2);
                        golist.add(a1*18+a2, "没有");
                    }else {
                        golist.add(a1*18+a2, "黑子");
                        golist.remove(18*18);
                        golist.add(18*18,"bai");
                    }
                }
            }else {
                if(golist.get(a1*18+a2).contains("白")) {
                    System.out.println("哼唧~自己不能吃自己~喵喵喵~~~");
                }
                else {
                    if(golist.get(a1*18+a2).contains("黑")) {
                        golist.remove(a1*18+a2);
                        golist.add(a1*18+a2, "没有");
                    }else {
                        golist.add(a1*18+a2, "白子");
                        golist.remove(18*18);
                        golist.add(18*18,"hei");
                    }
                }
            }
        }
       Position ll = Position.empty("go");
        ll.function(golist);
    }
    public void Piece(int a,int b,int c,int d) {
            ;
    }
}
