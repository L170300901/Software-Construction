package P3;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class chessBoard implements Board{
    public  void initBoard()throws IOException {
        ArrayList<String> chesslist = new ArrayList();
        for(int i = 0;i < 8;i ++) {
            for(int j =0;j < 8;j++) {
                if(i==0) {
                    chesslist.add("黑车");
                    chesslist.add("黑马");
                    chesslist.add("黑象");
                    chesslist.add("黑后");
                    chesslist.add("黑王");
                    chesslist.add("黑象");
                    chesslist.add("黑马");
                    chesslist.add("黑车");
                    break;
                }
                if(i==1) {
                    chesslist.add("黑兵");
                    chesslist.add("黑兵");
                    chesslist.add("黑兵");
                    chesslist.add("黑兵");
                    chesslist.add("黑兵");
                    chesslist.add("黑兵");
                    chesslist.add("黑兵");
                    chesslist.add("黑兵");
                    break;
                }
                if(i==7) {
                    chesslist.add("白车");
                    chesslist.add("白马");
                    chesslist.add("白象");
                    chesslist.add("白后");
                    chesslist.add("白王");
                    chesslist.add("白象");
                    chesslist.add("白马");
                    chesslist.add("白车");
                    break;
                }
                if(i==6) {
                    chesslist.add("白兵");
                    chesslist.add("白兵");
                    chesslist.add("白兵");
                    chesslist.add("白兵");
                    chesslist.add("白兵");
                    chesslist.add("白兵");
                    chesslist.add("白兵");
                    chesslist.add("白兵");
                    break;
                }
                chesslist.add("没有");
            }
        }
        chesslist.add("hei");
        String fileName = "src/P3/chessdata.temp";
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(fileName) );
        output.writeObject(chesslist);
        output.close();

    }
}
