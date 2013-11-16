package lis.java.tictactoe.model;

/**
 * Tic Tac Toe token line.
 * Marek Lis
 */
public class Line {

	public Position first;
	public Position last;
	public Token token;
	
	public Line(Position first, Position last, Token token) {
		this.first = first;
		this.last = last;
		this.token = token;
	}
	
}
