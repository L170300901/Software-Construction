package P3;
import java.io.*;
import java.util.ArrayList;

public interface Piece {
    public void Piece(int a,int b) throws IOException;
    public void Piece(int a,int b,int c,int d) throws FileNotFoundException, IOException;
    public static Piece empty(String a){
        if(a.equals("chess")){
            return new chessPiece();
        }
        return new goPiece();
    }
}
