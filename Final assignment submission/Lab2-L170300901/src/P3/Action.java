package P3;
import java.io.IOException;

public interface Action {//action负责解析字符串，分类送给go或者chess
    public static Action  action(String a){
        String[] choices = a.split(",");
        int size = choices.length;
        if(size==2){
               ;
        }else{
            int a1 = Integer.valueOf(choices[0]).intValue();
            int a2 = Integer.valueOf(choices[1]).intValue();
            int a3 = Integer.valueOf(choices[2]).intValue();
            int a4 = Integer.valueOf(choices[3]).intValue();
            return new chessAction(a1,a2,a3,a4);
        }
        int a1 = Integer.valueOf(choices[0]).intValue();
        int a2 = Integer.valueOf(choices[1]).intValue();
        return new goAction(a1,a2);
    }
    public void function() throws IOException;
}
