package lis.tictactoe.model;

/**
 * Tic Tac Toe Game Tokens.
 * Marek Lis
 */
public enum EToken { 
	TIC, 
	TAC, 
	TOE;
	
	@Override
	public String toString() {
		String result = "";
		if (equals(TIC)) result = "X";
		else if (equals(TAC)) result = "?";
		else if (equals(TOE)) result = "O";
		return result;
	}
}