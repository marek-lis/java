package lis.tictactoe.view;

import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import lis.tictactoe.App;
import lis.tictactoe.controller.AppController;
import lis.tictactoe.controller.IAppController;
import lis.tictactoe.model.AppModel;
import lis.tictactoe.model.Cell;
import lis.tictactoe.model.EPlayer;
import lis.tictactoe.model.EToken;
import lis.tictactoe.model.Event;
import lis.tictactoe.model.IAppModel;

/**
 * Tic Tac Toe Game View.
 * Marek Lis
 */
public class AppView extends Observable implements IAppView{
	
	protected IAppModel _model;
	protected IAppController _controller;
	
	protected Logger _log = Logger.getLogger(AppView.class);
	
	public AppView(AppModel model, AppController controller) {
		_model = model;
		_controller = controller;
	}
	
	public void update(Observable obj, Object o) {
		Event event = (Event) o;
		String type = event.getType();
		if (type.equals(Event.M_CHANGE_TURN)) {
			_log.info(Event.M_CHANGE_TURN + " " + ((EToken)event.getParams()).toString());
		} else
		if (type.equals(Event.M_SET_CELL)) {
			_log.info(Event.M_SET_CELL + " " + ((Cell)event.getParams()).toString());
		} else
		if (type.equals(Event.M_SET_PLAYER)) {
			_log.info(Event.M_SET_PLAYER + " " + ((EPlayer)event.getParams()).toString());
		} else
		if (type.equals(Event.M_GAME_COMPLETE)) {
			_log.info(Event.M_GAME_COMPLETE + " WINNER IS: " + _model.getWinner().toString());
		} else
		if (type.equals(Event.M_CLEAR)) {
			_log.info(Event.M_CLEAR);
		}
	}
	
}
