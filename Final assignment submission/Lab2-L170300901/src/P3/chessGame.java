package P3;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class chessGame implements Game{
    public void function() throws IOException {
    Player shit =  Player.empty("chess");
    shit.getname();
    Board booshit = Board.function("chess");
    booshit.initBoard();
    Scanner sc = new Scanner(System.in);
    for(int i =0;;i ++){
        String choice = sc.nextLine();
        if(choice.equals("end")){
            System.out.println("good game for chess");
            break;
        }
        Action a = Action.action(choice);
        a.function();
    }
    }



}
