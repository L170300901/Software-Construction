package P3;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class goPosition implements Position {
    public void function(ArrayList<String> golist) throws IOException {
        for(int i = 0;i < 18 ; i++) {
            for(int j =0 ;j < 18; j ++) {
                System.out.print(golist.get(18*i+j) + " ");
            }
            System.out.println(" ");
        }
        String fileName = "src/P3/godata.temp";
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(fileName) );
        output.writeObject(golist);
        output.close();
    }
}
