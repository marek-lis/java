package lis.tictactoe.model;

/**
 * Tic Tac Toe Game Cell Representation.
 * Marek Lis
 */
public class Cell {
	
	private Position _position;
	private EToken _token;

	public Cell(Position pos, EToken token) {
		_position = pos;
		_token = token;
	}
	
	public Position getPosition() {
		return _position;
	}
	
	public EToken getToken() {
		return _token;
	}
	
	@Override
	public String toString() {
		return "(" + _position.getCol() + "," + _position.getRow() + ") = " + _token.toString();
	}
	
}
