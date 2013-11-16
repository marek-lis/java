package lis.java.tictactoe.controller;

import lis.java.tictactoe.model.AppModel;
import lis.java.tictactoe.model.Constants;

/**
 * Tic Tac Toe game controller.
 * Marek Lis
 */
public class AppController {
	
	private AppModel model;

	public AppController(AppModel model) {
		this.model = model;
	}
	
	public void clear() {
		model.board.clear();
	}
	
}
