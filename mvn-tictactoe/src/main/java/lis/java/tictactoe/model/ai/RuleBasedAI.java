package lis.java.tictactoe.model.ai;

import lis.java.tictactoe.model.Cell;
import lis.java.tictactoe.model.EToken;

public class RuleBasedAI extends AbstractAI implements IAI {

	public RuleBasedAI(EAI ai, EToken[][] items, int cols, int rows) {
		super(ai, items, cols, rows);
	}
	
	@Override
	public Cell makeMove(EToken token) {
		Cell result = null;
		return result;
	}

}
