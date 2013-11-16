package lis.java.tictactoe.view;

/**
 * Tic Tac Toe game view.
 * Marek Lis
 */
import lis.java.tictactoe.App;
import lis.java.tictactoe.controller.AppController;
import lis.java.tictactoe.model.AppModel;

public class AppView {
	
	private AppModel model;
	private AppController controller;

	public AppView(AppModel model, AppController controller) {
		this.model = model;
		this.controller = controller;
		controller.clear();
	}
	
}
