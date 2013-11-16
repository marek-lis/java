package lis.java.tictactoe.model;

public class Board {
	
	private int cols;
	private int rows;
	private int[][] items;
	
	/**
	 * Tic Tac Toe game board.
	 * Marek Lis
	 */
	public Board() {
		cols = 3;
		rows = 3;
		items = new int[cols][rows];
	}
	
	public void clear() {
		int row, col;
		for (row=0; row<rows; row++) {
			for (col=0; col<cols; col++) {
				items[col][row] = Constants.TAC;
			}
		}
	}
	
	public boolean isEmpty(Position pos) {
		return items[pos.col][pos.row] == Constants.TAC;
	}
	
	public void setCell(Position pos, int token) {
		items[pos.col][pos.row] = token;
	}
	
	public int getCell(Position pos) {
		return items[pos.col][pos.row];
	}
	
	public Line checkHorizontal() {
		Line result = null;
		int row = 0, col = 0, token;
		for (row=0; row<rows; row++) {
			token = items[col][row];
			if (token != Constants.TAC && items[col+1][row] == token && items[col+2][row] == token) {
				result = new Line(new Position(col, row), new Position(col+2, row), token);
				break;
			}
		}
		return result;
	}
	
	public Line checkVertical() {
		Line result = null;
		int row = 0, col = 0, token;
		for (col=0; col<cols; col++) {
			token = items[row][col];
			if (token != Constants.TAC && items[col][row+1] == token && items[col][row+2] == token) {
				result = new Line(new Position(col, row), new Position(col, row+2), token);
				break;
			}
		}
		return result;
	}
	
	public Line checkDiagonal() {
		Line result = null;
		int row = 1, col = 1, token;
		token = items[col][row];
		if (token != Constants.TAC) {
			if (items[col-1][row-1] == token && items[col+1][row+1] == token) {
				result = new Line(new Position(col-1, row-1), new Position(col+1, row+1), token);
			} else
			if (items[col+1][row-1] == token && items[col-1][row+1] == token) {
				result = new Line(new Position(col+1, row-1), new Position(col-1, row+1), token);
			}
		}
		return result;
	}

}
