package P3;
import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;

import java.io.IOException;

import org.junit.Test;

import P3.Piece;
import P3.Player;
import P3.Position;
import P3.Board;
import P3.Action;
import P3.chessAction;
import P3.chessBoard;
import P3.chessGame;
import P3.chessPiece;
import P3.chessPlayer;
import P3.chessPosition;
import P3.Game;
import P3.goAction;
import P3.goBoard;
import P3.goGame;
import P3.goPiece;
import P3.goPlayer;
import P3.goPosition;
import P3.Mian;

public class ChessGameTest {
	Game chessinit=Game.empty("chess");
	Game goinit=Game.empty("go");
	@Test
    public void chesseatTest() throws IOException
    {
		
		chessinit.function();
        chess.function("1,1,3,4");
        chess.function("7,7,3,4");
        chess.function("0,0,3,4");
        chess.function("7,6,3,4");
        chess.function("0,1,3,4");
        chess.function("6,6,3,4");
        assertEquals("没有", getchessdata.function().get(3*8+3));
    }
	@Test
	public void chesswrongputTest() throws IOException
    {
		chessinit.function();
        chess.function("1,1,0,0");
        assertEquals("黑车", getchessdata.function().get(0));
        assertEquals("黑兵", getchessdata.function().get(1*8 + 1));
    }
	@Test
    public void goeatTest() throws IOException
    {
		goinit.function();
		go.function("1,1");
        go.function("2,2");
        go.function("2,2");
        assertEquals("没有", getgodata.function().get(2*18+2));
    }
	@Test
	public void gowrongputTest() throws IOException
    {
		goinit.function();
        go.function("1,1");
        go.function("10,10");
        go.function("1,1");
        assertEquals("黑子", getgodata.function().get(1*18 + 1));
    }
}
