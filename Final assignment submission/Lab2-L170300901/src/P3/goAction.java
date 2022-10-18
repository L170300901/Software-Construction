package P3;
import java.io.IOException;

public class goAction implements Action{
    int a1 = 0;
    int a2 = 0;
    public goAction(int a1,int a2){
    this.a1 = a1;
    this.a2 = a2;
    }
    public void function() throws IOException {

            Piece a = Piece.empty("go");
            a.Piece(a1,a2);

    }
}
