package P3;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class goBoard implements Board{
    public   void initBoard()throws IOException {
        ArrayList<String> golist = new ArrayList();
        for(int i = 0;i < 18;i ++) {
            for(int j =0;j < 18;j++) {
                golist.add("没有");
            }
        }
        golist.add("hei");
        String fileName = "src/P3/godata.temp";
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(fileName) );
        output.writeObject(golist);
        output.close();
    }
}
