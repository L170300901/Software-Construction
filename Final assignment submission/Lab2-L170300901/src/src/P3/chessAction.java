package P3;
import java.io.IOException;

public class chessAction implements Action{
    int aa = 0;
    int bb =0;
    int cc =0;
    int dd =0;
    public chessAction(int a1,int a2,int a3,int a4){
    this.aa =a1;
    this.bb =a2;
    this.cc =a3;
    this.dd =a4;
    }
    public void function() throws IOException {
    Piece a = Piece.empty("chess");
    a.Piece(aa,bb,cc,dd);
    }
}
