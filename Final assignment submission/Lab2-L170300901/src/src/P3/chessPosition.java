package P3;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class chessPosition implements Position {
    public void function(ArrayList<String> chesslist) throws IOException {
        for(int i = 0;i < 8 ; i++) {
            for(int j =0 ;j < 8; j ++) {
                System.out.print(chesslist.get(8*i+j) + " ");
            }
            System.out.println(" ");
        }
        String fileName = "src/P3/chessdata.temp";
        ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream(fileName) );
        output.writeObject(chesslist);
        output.close();
    }




}
