package P3;
import java.io.IOException;
import java.util.ArrayList;

public interface Position {//position负责输出图形
    public static Position empty(String a){
        if(a.equals("chess")){
            return new chessPosition();
        }
        return new goPosition();
    }
    public void function(ArrayList<String> a) throws IOException;
}
