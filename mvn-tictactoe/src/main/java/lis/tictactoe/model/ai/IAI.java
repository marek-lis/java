package lis.tictactoe.model.ai;

import lis.tictactoe.model.Cell;
import lis.tictactoe.model.EToken;

public interface IAI {
	
	public EAI getAI();
	public Cell makeMove(EToken token);
	
}
