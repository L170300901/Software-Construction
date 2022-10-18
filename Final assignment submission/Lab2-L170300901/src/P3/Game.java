package P3;
import java.io.FileNotFoundException;
import java.io.IOException;

public interface Game {//在game中调用了player
    public static Game empty(String name) {
        if (name.equals("chess")) {
            return new chessGame();
        }else{
            return new goGame();
        }
    }
    public void function() throws IOException;
}
