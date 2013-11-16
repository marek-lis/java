package lis.java.tictactoe.model;

public class Board {
	
	private int cols;
	private int rows;
	private Token[][] items;
	
	/**
	 * Tic Tac Toe game board.
	 * Marek Lis
	 */
	public Board() {
		cols = 3;
		rows = 3;
		items = new Token[cols][rows];
	}
	
	public void clear() {
		int row, col;
		for (row=0; row<rows; row++) {
			for (col=0; col<cols; col++) {
				items[col][row] = Token.TAC;
			}
		}
	}
	
	public boolean isEmpty(Position pos) {
		return items[pos.col][pos.row] == Token.TAC;
	}
	
	public void setCell(Position pos, Token token) {
		items[pos.col][pos.row] = token;
	}
	
	public Token getCell(Position pos) {
		return items[pos.col][pos.row];
	}
	
	public Line checkHorizontal() {
		Line result = null;
		int row = 0, col = 0;
		Token token;
		for (row=0; row<rows; row++) {
			token = items[col][row];
			if (token != Token.TAC && items[col+1][row] == token && items[col+2][row] == token) {
				result = new Line(new Position(col, row), new Position(col+2, row), token);
				break;
			}
		}
		return result;
	}
	
	public Line checkVertical() {
		Line result = null;
		int row = 0, col = 0;
		Token token;
		for (col=0; col<cols; col++) {
			token = items[row][col];
			if (token != Token.TAC && items[col][row+1] == token && items[col][row+2] == token) {
				result = new Line(new Position(col, row), new Position(col, row+2), token);
				break;
			}
		}
		return result;
	}
	
	public Line checkDiagonal() {
		Line result = null;
		int row = 1, col = 1;
		Token token;
		token = items[col][row];
		if (token != Token.TAC) {
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
