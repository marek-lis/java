package lis.tictactoe.model;

/**
 * Tic Tac Toe Token Line.
 * Marek Lis
 */
public class Line {

	private Position _first;
	private Position _last;
	private EToken _token;
	
	public Line(Position first, Position last, EToken token) {
		_first = first;
		_last = last;
		_token = token;
	}
	
	public Position getFirst() {
		return _first;
	}
	
	public Position getLast() {
		return _last;
	}
	
	public EToken getToken() {
		return _token;
	}
	
}
