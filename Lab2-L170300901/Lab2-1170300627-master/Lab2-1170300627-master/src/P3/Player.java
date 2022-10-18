package P3;
public interface Player {
     public void getname();
     public static Player empty(String a){
         if(a.equals("chess")){
             return new chessPlayer();
         }else{
             return new goPlayer();
         }
     }
}
