package P3;
import java.io.IOException;
import java.util.Scanner;

public class goGame implements  Game {
    public void function() throws IOException {
        Player shit =  Player.empty("go");
        shit.getname();
        Board booshit = Board.function("go");
        booshit.initBoard();
        Scanner sc = new Scanner(System.in);
        for(int i =0;;i ++){
            String choice = sc.nextLine();
            if(choice.equals("end")){
                System.out.println("good game for go");
                break;
            }
            Action a = Action.action(choice);
            a.function();
        }
    }


}
