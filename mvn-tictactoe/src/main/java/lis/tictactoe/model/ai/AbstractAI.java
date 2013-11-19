package lis.tictactoe.model.ai;

import lis.tictactoe.model.Cell;
import lis.tictactoe.model.EToken;

public abstract class AbstractAI {

	protected EAI _ai;
	protected int _rows;
	protected int _cols;
	protected EToken[][] _items;

	public AbstractAI(EAI ai, EToken[][] items, int cols, int rows) {
		_ai = ai;
		_items = items;
		_cols = cols;
		_rows = rows;
	}
	
	public EAI getAI() {
		return _ai;
	}
	
	public abstract Cell makeMove(EToken token);
	
}
