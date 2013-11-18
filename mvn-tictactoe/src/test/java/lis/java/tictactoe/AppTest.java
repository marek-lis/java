package lis.java.tictactoe;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import lis.java.tictactoe.model.AppModel;
import lis.java.tictactoe.model.Position;
import lis.java.tictactoe.model.EToken;

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
        testCheckDiagonalLeftRight();
        testCheckDiagonalLeftRightFail();
        testCheckDiagonalRightLeft();
        testCheckDiagonalRightLeftFail();
    }
    
    public void testCheckHorizontal() {
    	AppModel board = new AppModel();
    	board.clear();
    	board.setCell(new Position(0,0), EToken.TIC);
    	board.setCell(new Position(1,0), EToken.TIC);
    	board.setCell(new Position(2,0), EToken.TIC);
    	assertNotNull("Check Horizontal Test ", board.checkHorizontal());
    }
    
    public void testCheckHorizontalFail() {
    	AppModel board = new AppModel();
    	board.clear();
    	board.setCell(new Position(0,0), EToken.TIC);
    	board.setCell(new Position(1,0), EToken.TOE);
    	board.setCell(new Position(2,0), EToken.TIC);
    	assertNull("Check Horizontal Test Failed ", board.checkHorizontal());
    }
    
    public void testCheckVertical() {
    	AppModel board = new AppModel();
    	board.clear();
    	board.setCell(new Position(0,0), EToken.TOE);
    	board.setCell(new Position(0,1), EToken.TOE);
    	board.setCell(new Position(0,2), EToken.TOE);
    	assertNotNull("Check Vertical Test ", board.checkVertical());
    }
    
    public void testCheckVerticalFail() {
    	AppModel board = new AppModel();
    	board.clear();
    	board.setCell(new Position(0,0), EToken.TOE);
    	board.setCell(new Position(0,1), EToken.TIC);
    	board.setCell(new Position(0,2), EToken.TOE);
    	assertNull("Check Vertical Test Failed ", board.checkVertical());
    }
    
    public void testCheckDiagonalLeftRight() {
    	AppModel board = new AppModel();
    	board.clear();
    	board.setCell(new Position(0,0), EToken.TOE);
    	board.setCell(new Position(1,1), EToken.TOE);
    	board.setCell(new Position(2,2), EToken.TOE);
    	assertNotNull("Check Diagonal Left Right Test ", board.checkDiagonal());
    }
    
    public void testCheckDiagonalLeftRightFail() {
    	AppModel board = new AppModel();
    	board.clear();
    	board.setCell(new Position(0,0), EToken.TOE);
    	board.setCell(new Position(1,1), EToken.TIC);
    	board.setCell(new Position(2,2), EToken.TOE);
    	assertNull("Check Diagonal Left Right Test Failed ", board.checkDiagonal());
    }
    
    public void testCheckDiagonalRightLeft() {
    	AppModel board = new AppModel();
    	board.clear();
    	board.setCell(new Position(2,0), EToken.TOE);
    	board.setCell(new Position(1,1), EToken.TOE);
    	board.setCell(new Position(0,2), EToken.TOE);
    	assertNotNull("Check Diagonal Right Left Test ", board.checkDiagonal());
    }
    
    public void testCheckDiagonalRightLeftFail() {
    	AppModel board = new AppModel();
    	board.clear();
    	board.setCell(new Position(2,0), EToken.TOE);
    	board.setCell(new Position(1,1), EToken.TIC);
    	board.setCell(new Position(0,2), EToken.TOE);
    	assertNull("Check Diagonal Right Left Test Failed ", board.checkDiagonal());
    }
    
    
}
