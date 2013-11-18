package lis.java.tictactoe.model.ai;

import lis.java.tictactoe.model.Cell;
import lis.java.tictactoe.model.EToken;
import lis.java.tictactoe.model.Position;

public class LookupAI extends AbstractAI implements IAI {

	private int[][] _moves = {
		{1, 1}, 
		{0, 0}, 
		{0, 2}, 
		{2, 0}, 
		{2, 2}, 
		{0, 1}, 
		{1, 0}, 
		{1, 2}, 
		{2, 1}
	};

	
	public LookupAI(EAI ai, EToken[][] items, int cols, int rows) {
		super(ai, items, cols, rows);
	}
	
	@Override
	public Cell makeMove(EToken token) {
		Cell result = null;
		int len = _moves.length;
		int col, row, i = 0;
		for (i=0; i<len; i++) {
			col = _moves[i][0];
			row = _moves[i][1];
			if (_items[col][row] == EToken.TAC) {
				result = new Cell(new Position(col,row), token);
				break;
			}
		}
		return result;
	}

}
