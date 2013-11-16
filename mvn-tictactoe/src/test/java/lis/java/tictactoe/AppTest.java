package lis.java.tictactoe;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import lis.java.tictactoe.model.Board;
import lis.java.tictactoe.model.Constants;
import lis.java.tictactoe.model.Position;
import lis.java.tictactoe.model.Token;

/**
 * Unit test for Tic Tac Toe game.
 * Marek Lis
 */
public class AppTest extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        testCheckHorizontal();
        testCheckHorizontalFail();
        testCheckVertical();
        testCheckVerticalFail();
        testCheckDiagonalLR();
        testCheckDiagonalLRFail();
        testCheckDiagonalRL();
        testCheckDiagonalRLFail();
    }
    
    public void testCheckHorizontal() {
    	Board board = new Board();
    	board.clear();
    	board.setCell(new Position(0,0), Token.TIC);
    	board.setCell(new Position(1,0), Token.TIC);
    	board.setCell(new Position(2,0), Token.TIC);
    	assertNotNull("Check Horizontal Test ", board.checkHorizontal());
    }
    
    public void testCheckHorizontalFail() {
    	Board board = new Board();
    	board.clear();
    	board.setCell(new Position(0,0), Token.TIC);
    	board.setCell(new Position(1,0), Token.TOE);
    	board.setCell(new Position(2,0), Token.TIC);
    	assertNull("Check Horizontal Test Failed ", board.checkHorizontal());
    }
    
    public void testCheckVertical() {
    	Board board = new Board();
    	board.clear();
    	board.setCell(new Position(0,0), Token.TOE);
    	board.setCell(new Position(0,1), Token.TOE);
    	board.setCell(new Position(0,2), Token.TOE);
    	assertNotNull("Check Vertical Test ", board.checkVertical());
    }
    
    public void testCheckVerticalFail() {
    	Board board = new Board();
    	board.clear();
    	board.setCell(new Position(0,0), Token.TOE);
    	board.setCell(new Position(0,1), Token.TIC);
    	board.setCell(new Position(0,2), Token.TOE);
    	assertNull("Check Vertical Test Failed ", board.checkVertical());
    }
    
    public void testCheckDiagonalLR() {
    	Board board = new Board();
    	board.clear();
    	board.setCell(new Position(0,0), Token.TOE);
    	board.setCell(new Position(1,1), Token.TOE);
    	board.setCell(new Position(2,2), Token.TOE);
    	assertNotNull("Check Diagonal LR Test ", board.checkDiagonal());
    }
    
    public void testCheckDiagonalLRFail() {
    	Board board = new Board();
    	board.clear();
    	board.setCell(new Position(0,0), Token.TOE);
    	board.setCell(new Position(1,1), Token.TIC);
    	board.setCell(new Position(2,2), Token.TOE);
    	assertNull("Check Diagonal LR Test Failed ", board.checkDiagonal());
    }
    
    public void testCheckDiagonalRL() {
    	Board board = new Board();
    	board.clear();
    	board.setCell(new Position(2,0), Token.TOE);
    	board.setCell(new Position(1,1), Token.TOE);
    	board.setCell(new Position(0,2), Token.TOE);
    	assertNotNull("Check Diagonal RL Test ", board.checkDiagonal());
    }
    
    public void testCheckDiagonalRLFail() {
    	Board board = new Board();
    	board.clear();
    	board.setCell(new Position(2,0), Token.TOE);
    	board.setCell(new Position(1,1), Token.TIC);
    	board.setCell(new Position(0,2), Token.TOE);
    	assertNull("Check Diagonal RL Test Failed ", board.checkDiagonal());
    }
    
    
}
