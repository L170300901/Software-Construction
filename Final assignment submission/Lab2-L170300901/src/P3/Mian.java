package P3;
import java.io.IOException;

public class Mian {
    public static void main(String[] Zing) throws IOException {//别忘了最后在所有的路径上都加上p3！！！
        Game game1 = Game.empty("chess");
        //Game game1 = Game.empty("go");
        game1.function();//进行游戏
    }
}
