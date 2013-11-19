package lis.tictactoe.controller;

import java.util.Observable;
import java.util.Observer;

import org.apache.log4j.Logger;

import lis.tictactoe.App;
import lis.tictactoe.model.AppModel;
import lis.tictactoe.model.Cell;
import lis.tictactoe.model.EPlayer;
import lis.tictactoe.model.EToken;
import lis.tictactoe.model.Event;
import lis.tictactoe.model.IAppModel;
import lis.tictactoe.model.Line;
import lis.tictactoe.model.Position;
import lis.tictactoe.model.ai.EAI;

/**
 * Tic Tac Toe Game Controller.
 * Marek Lis
 */
public class AppController implements IAppController {
	
	private IAppModel _model;
	
	private Logger _log = Logger.getLogger(AppController.class);

	public AppController(AppModel model) {
		_model = model;
	}
	
	public void init() {
		_model.clear();
		_model.setAI(EAI.LOOKUP);
		_model.setPlayer(EPlayer.COMPUTER);
		_model.setTurn(EToken.TIC);
		_log.info(_model.toString());
	}
	
	public void update(Observable obj, Object o) {
		Event event = (Event) o;
		String type = event.getType();
		if (type.equals(Event.V_MENU_NEW_GAME_CLICK)) {
			_log.info(Event.V_MENU_NEW_GAME_CLICK);
			_model.clear();
		} else
		if (type.equals(Event.V_MENU_PLAYER_HUMAN_CLICK)) {
			_log.info(Event.V_MENU_PLAYER_HUMAN_CLICK);
			_model.setPlayer(EPlayer.HUMAN);
		} else
		if (type.equals(Event.V_MENU_PLAYER_COMPUTER_CLICK)) {
			_log.info(Event.V_MENU_PLAYER_COMPUTER_CLICK);
			_model.setPlayer(EPlayer.COMPUTER);
		} else
		if (type.equals(Event.V_MENU_EXIT_GAME_CLICK)) {
			_log.info(Event.V_MENU_EXIT_GAME_CLICK);
			System.exit(0);
		} else
		if (type.equals(Event.V_CELL_CLICK)) {
			Cell cell = (Cell) event.getParams();
			_log.info(Event.V_CELL_CLICK+" "+cell.toString());
			if (_model.getWinner() == null) {
				_model.setCell(cell.getPosition(), _model.getTurn());
				_model.changeTurn();
			}
			if (_model.getPlayer() == EPlayer.COMPUTER) {
				if (_model.getWinner() == null) {
					_model.move();
					_model.changeTurn();
				}
			}
		}
		_log.info(_model.toString());
	}
	
}
