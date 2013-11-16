package lis.java.tictactoe;

import lis.java.tictactoe.controller.AppController;
import lis.java.tictactoe.model.AppModel;
import lis.java.tictactoe.view.AppView;

/**
 * Tic Tac Toe game.
 * Marek Lis
 */
public class App 
{
	
	private static AppModel model;
	private static AppController controller;
	private static AppView view;
	
	public static AppModel getModel() {
		return model;
	}
	
	public static AppController getController() {
		return controller;
	}
	
	public static AppView getView() {
		return view;
	}
	
    public static void main( String[] args )
    {
		model = new AppModel();
		controller = new AppController(model);
        view = new AppView(model, controller);
    }
}
