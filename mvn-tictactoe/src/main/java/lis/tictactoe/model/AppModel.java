package lis.tictactoe.model;

import java.util.Observable;

import lis.tictactoe.model.ai.EAI;
import lis.tictactoe.model.ai.IAI;
import lis.tictactoe.model.ai.LookupAI;
import lis.tictactoe.model.ai.RuleBasedAI;

/**
 * Tic Tac Toe Game Model.
 * Marek Lis
 */
public class AppModel extends Observable implements IAppModel {
	
	private int _cols;
	private int _rows;
	private int _appWidth;
	private int _appHeight;
	private IAI _ai;
	private EToken _turn;
	private EPlayer _player;
	private EToken _winner;
	private EToken[][] _items;

	/**
	 * Tic Tac Toe game model.
	 * Marek Lis
	 */
	public AppModel() {
		_cols = 3;
		_rows = 3;
		_turn = EToken.TAC;
		_appWidth = 320;
		_appHeight = 383;
		_player = EPlayer.COMPUTER;
		_winner = null;
		_items = new EToken[_cols][_rows];
	}
	
	public void clear() {
		_winner = null;
		int row, col;
		for (row=0; row<_rows; row++) {
			for (col=0; col<_cols; col++) {
				_items[col][row] = EToken.TAC;
			}
		}
		setChanged();
		notifyObservers(new Event(Event.M_CLEAR, null));
	}
	
	public void move() {
		if (_ai != null) {
			Cell cell = _ai.makeMove(_turn);
			if (cell != null) {
				setCell(cell.getPosition(), cell.getToken());
			}
		}
	}
	/*
	public boolean isEmpty(Position pos) {
		return _items[pos.getCol()][pos.getRow()] == EToken.TAC;
	}*/
	
	public boolean isFull() {
		boolean result = true;
		int row, col;
		for (row=0; row<_rows; row++) {
			for (col=0; col<_cols; col++) {
				if (_items[col][row] == EToken.TAC) {
					result = false;
					break;
				}
			}
		}
		return result;
	}
	
	public void changeTurn() {
		_turn = ((_turn == EToken.TOE) ? EToken.TIC : (_turn == EToken.TIC ? EToken.TOE : EToken.TIC));
		setChanged();
		notifyObservers(new Event(Event.M_CHANGE_TURN, _turn));
	}
	
	public void setTurn(EToken token) {
		if (_turn != token) {
			_turn = token;
		}
	}
	
	public EToken getTurn() {
		return _turn;
	}
	
	public void setAI(EAI ai) {
		if (_ai == null || _ai.getAI() != ai) {
			if (ai == EAI.LOOKUP) {
				_ai = new LookupAI(ai, _items, _cols, _rows);
			} else
			if (ai == EAI.RULE_BASED) {
				_ai = new RuleBasedAI(ai, _items, _cols, _rows);
			}
		}
	}
	
	public IAI getAI() {
		return _ai;
	}
	
	public EToken getWinner() {
		return _winner;
	}
	
	public void setCell(Position pos, EToken token) {
		if (!getCell(pos).equals(token)) {
			_items[pos.getCol()][pos.getRow()] = token;
			setChanged();
			notifyObservers(new Event(Event.M_SET_CELL, new Cell(pos, token)));
			checkCells();
		}
	}
	
	public EToken getCell(Position pos) {
		return _items[pos.getCol()][pos.getRow()];
	}
	
	public void setPlayer(EPlayer player) {
		if (!_player.equals(player)) {
			_player = player;
			setChanged();
			notifyObservers(new Event(Event.M_SET_PLAYER, _player));
		}
	}
	
	public EPlayer getPlayer() {
		return _player;
	}
	
	public EToken[][] getItems() {
		return _items;
	}
	
	public int getRowsNum() {
		return _rows;
	}
	
	public int getColsNum() {
		return _cols;
	}
	
	public int getAppWidth() {
		return _appWidth;
	}
	
	public int getAppHeight() {
		return _appHeight;
	}
	
	public void checkCells() {
		Line result;
		result = checkHorizontal();
		if (result == null) result = checkVertical();
		if (result == null) result = checkDiagonal();
		if (result != null || isFull()) {
			_winner = result != null ? result.getToken() : EToken.TAC;
			setChanged();
			notifyObservers(new Event(Event.M_GAME_COMPLETE, _winner));
		}
	}
	
	public Line checkHorizontal() {
		Line result = null;
		int row = 0, col = 0;
		EToken token;
		for (row=0; row<_rows; row++) {
			token = _items[col][row];
			if (token != EToken.TAC && _items[col+1][row] == token && _items[col+2][row] == token) {
				result = new Line(new Position(col, row), new Position(col+2, row), token);
				break;
			}
		}
		return result;
	}
	
	public Line checkVertical() {
		Line result = null;
		int row = 0, col = 0;
		EToken token;
		for (col=0; col<_cols; col++) {
			token = _items[col][row];
			if (token != EToken.TAC && _items[col][row+1] == token && _items[col][row+2] == token) {
				result = new Line(new Position(col, row), new Position(col, row+2), token);
				break;
			}
		}
		return result;
	}
	
	public Line checkDiagonal() {
		Line result = null;
		int row = 1, col = 1;
		EToken token;
		token = _items[col][row];
		if (token != EToken.TAC) {
			if (_items[col-1][row-1] == token && _items[col+1][row+1] == token) {
				result = new Line(new Position(col-1, row-1), new Position(col+1, row+1), token);
			} else
			if (_items[col+1][row-1] == token && _items[col-1][row+1] == token) {
				result = new Line(new Position(col+1, row-1), new Position(col-1, row+1), token);
			}
		}
		return result;
	}
	
	public String toString() {
		String result = "\n";
		int row, col;
		for (row=0; row<_rows; row++) {
			for (col=0; col<_cols; col++) {
				result += _items[col][row].toString() + ", ";
			}
			result += "\n";
		}
		return result;
	}
	
}
