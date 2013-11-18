package lis.java.tictactoe;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import lis.java.tictactoe.controller.AppController;
import lis.java.tictactoe.model.AppModel;
import lis.java.tictactoe.model.Position;
import lis.java.tictactoe.model.EToken;
import lis.java.tictactoe.view.swing.SwingView;

/**
 * Tic Tac Toe Game.
 * Marek Lis
 */
public class App 
{
	
	private static AppModel model;
	private static AppController controller;
	private static SwingView view;
	
	//public final static Logger log = Logger.getLogger(App.class);
	
	public static AppModel getModel() {
		return model;
	}
	
	public static AppController getController() {
		return controller;
	}
	
	public static SwingView getView() {
		return view;
	}
	
    public static void main( String[] args )
    {
    	BasicConfigurator.configure();
    	
		model = new AppModel();
		controller = new AppController(model);
		view = new SwingView(model, controller);
		
		model.addObserver(view);
		view.addObserver(controller);
		
		controller.init();
    }
}
