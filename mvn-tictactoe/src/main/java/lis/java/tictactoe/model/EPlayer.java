package lis.java.tictactoe.model;

/**
 * Tic Tac Toe Game Players.
 * Marek Lis
 */
public enum EPlayer {
	COMPUTER,
	HUMAN;
	
	@Override
	public String toString() {
		String result = "";
		if (equals(COMPUTER)) result = "Computer";
		else if (equals(HUMAN)) result = "Human";
		return result;
	}
}
