package P3;
import java.io.IOException;

public interface Board {//初始化的时候用了一下
   public static Board function(String a){
      if(a.equals("chess")){
         return new chessBoard();
      }else{
         return new goBoard();
      }
   }
   public void initBoard() throws IOException;
}
