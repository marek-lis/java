package lis.tictactoe.controller;

import java.util.Observable;
import java.util.Observer;

public interface IAppController extends Observer {

	public void init();
	public void update(Observable obj, Object o);
	
}
