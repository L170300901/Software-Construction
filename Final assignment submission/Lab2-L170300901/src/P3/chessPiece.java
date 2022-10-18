package P3;
import java.io.*;
import java.util.ArrayList;

public class chessPiece implements Piece{

    public void Piece(int a,int b) {
         ;
    }
    public void Piece(int a1,int a2,int a3,int a4) throws IOException {
        ArrayList<String> chesslist = new ArrayList();
        ObjectInputStream input = new ObjectInputStream(
                new FileInputStream("src/P3/chessdata.temp") );
        try {
            while( (chesslist=(ArrayList<String>)input.readObject()) != null ) {
                ;
            }
        } catch(ClassNotFoundException ex) {}
        catch(EOFException eofex) {} catch (IOException e) {
            e.printStackTrace();
        }
        input.close();

        if(chesslist.get(a1*8+a2).contains("没有")||(a1<0)||(a1>7)||(a2<0)||(a2>7)||(a3<0)||(a3>7)||(a4<0)||(a4>7)||(chesslist.get(a1*8 + (a2)).contains("黑")&&chesslist.get(a3*8 + (a4)).contains("黑"))||(chesslist.get(a1*8 + (a2)).contains("白")&&chesslist.get(a3*8 + (a4)).contains("白"))) {
            System.out.println("错了~喵喵喵~~~");
        }else {
            if(chesslist.get(64).equals("hei")) {
                chesslist.remove(64);
                chesslist.add("bai");
                String temp;
                temp = chesslist.get(a1*8 + (a2));
                chesslist.remove(a1*8 + (a2));
                chesslist.add(a1*8 + (a2),"没有");
                chesslist.remove(a3*8 + (a4));
                chesslist.add(a3*8 + (a4),temp);
            }else {
                chesslist.remove(64);
                chesslist.add("hei");
                String temp;
                temp = chesslist.get(a1*8 + (a2));
                chesslist.remove(a1*8 + (a2));
                chesslist.add(a1*8 + (a2),"没有");
                chesslist.remove(a3*8 + (a4));
                chesslist.add(a3*8 + (a4),temp);
            }
        }
        Position l = Position.empty("chess");
        l.function(chesslist);
    }
}
