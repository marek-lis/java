package lis.java.tictactoe.model;

import lis.java.tictactoe.model.ai.EAI;
import lis.java.tictactoe.model.ai.IAI;

public interface IAppModel {
	
	public void clear();
	public void move();
	public boolean isFull();
	public void setTurn(EToken token);
	public EToken getTurn();
	public void changeTurn();
	public EToken getWinner();
	public void setAI(EAI ai);
	public IAI getAI();
	public void setCell(Position pos, EToken token);
	public EToken getCell(Position pos);
	public void setPlayer(EPlayer player);
	public EPlayer getPlayer();
	public EToken[][] getItems();
	public int getColsNum();
	public int getRowsNum();
	public int getAppWidth();
	public int getAppHeight();
}
