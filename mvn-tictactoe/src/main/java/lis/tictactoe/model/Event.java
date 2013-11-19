package lis.tictactoe.model;

/**
 * Tic Tac Toe Game Events.
 * Marek Lis
 */
public class Event {

	public final static String M_CLEAR = "onModelClear";
	public final static String M_SET_CELL = "onModelSetCell";
	public final static String M_SET_PLAYER = "onModelSetPlayer";
	public final static String M_CHANGE_TURN = "onModelChangeTurn";
	public final static String M_GAME_COMPLETE = "onModelGameComplete";
	
	public final static String V_CELL_CLICK = "onViewCellClick";
	public final static String V_MENU_NEW_GAME_CLICK = "onViewMenuNewGameClick";
	public final static String V_MENU_PLAYER_HUMAN_CLICK = "onViewMenuPlayerHumanClick";
	public final static String V_MENU_PLAYER_COMPUTER_CLICK = "onViewMenuPlayerComputerClick";
	public final static String V_MENU_EXIT_GAME_CLICK = "onViewMenuExitGameClick";
	
	private String _type; 
	private Object _params;
	
	public Event(String type, Object params) {
		_type = type;
		_params = params;
	}
	
	public String getType() {
		return _type;
	}
	
	public Object getParams() {
		return _params;
	}
}
