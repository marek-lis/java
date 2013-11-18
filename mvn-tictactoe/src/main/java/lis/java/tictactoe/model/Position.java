package lis.java.tictactoe.model;

/**
 * Token Position.
 * Marek Lis
 */
public class Position {
	
	private int _col;
	private int _row;
	
	public Position(int col, int row) {
		_col = col;
		_row = row;
		
	}
	
	public int getCol() {
		return _col;
	}
	
	public int getRow() {
		return _row;
	}
	
	public boolean equals(Object arg0) {
		boolean result = false;
		if (arg0 instanceof Position) {
			Position pos = (Position) arg0;
			result = pos.getCol() == _col && pos.getRow() == _row;
		}
		return result;
	}
	
}
