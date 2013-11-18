package lis.java.tictactoe.model.ai;

import lis.java.tictactoe.model.Cell;
import lis.java.tictactoe.model.EToken;

public interface IAI {
	
	public EAI getAI();
	public Cell makeMove(EToken token);
	
}
