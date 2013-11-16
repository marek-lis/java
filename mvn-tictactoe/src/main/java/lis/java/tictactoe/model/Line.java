package lis.java.tictactoe.model;

/**
 * Tic Tac Toe token line.
 * Marek Lis
 */
public class Line {

	public Position first;
	public Position last;
	public int token;
	
	public Line(Position first, Position last, int token) {
		this.first = first;
		this.last = last;
		this.token = token;
	}
	
}
