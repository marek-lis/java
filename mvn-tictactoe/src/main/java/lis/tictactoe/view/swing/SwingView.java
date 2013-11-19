package lis.tictactoe.view.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.SwingConstants;

import lis.tictactoe.controller.AppController;
import lis.tictactoe.model.AppModel;
import lis.tictactoe.model.Cell;
import lis.tictactoe.model.EToken;
import lis.tictactoe.model.Event;
import lis.tictactoe.model.Position;
import lis.tictactoe.view.AppView;

/**
 * Tic Tac Toe Game Swing View.
 * Marek Lis
 */
public class SwingView extends AppView {
	
	private static final String Cell = null;
	private JPanel _game;
	private JFrame _frame;
	private JPanel _statusBar;
	private JLabel _statusLabel;

	public SwingView(AppModel model, AppController controller) {
		super(model, controller);
		//initMenuUI();
		initMenuUIFactory();
		initGameUI();
		initStatusBarUI();
	}
	
	private void initMenuUI() {
		JMenuBar menuBar;
		JMenu menu;
		JMenu subMenu;
		JMenuItem item;
		JRadioButtonMenuItem subItem;
		ButtonGroup radioGroup;
		menuBar = new JMenuBar();
		menu = new JMenu("Game");
		menu.setMnemonic(KeyEvent.VK_G);
		item = new JMenuItem("New");
		item.setMnemonic(KeyEvent.VK_N);
		item.setToolTipText("Start New Game");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setChanged();
				notifyObservers(new Event(Event.V_MENU_NEW_GAME_CLICK, null));
			}
		});
		menu.add(item);
		subMenu = new JMenu("Player");
		subMenu.setMnemonic(KeyEvent.VK_P);
		subMenu.setToolTipText("Choose Second Player");
		subMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
			}
		});
		menu.add(subMenu);
		radioGroup = new ButtonGroup();
		subItem = new JRadioButtonMenuItem("Computer", true);
		subItem.setMnemonic(KeyEvent.VK_C);
		subItem.setToolTipText("Second Player = Computer");
		subItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setChanged();
				notifyObservers(new Event(Event.V_MENU_PLAYER_COMPUTER_CLICK, null));
			}
		});
		subMenu.add(subItem);
		radioGroup.add(subItem);
		subItem = new JRadioButtonMenuItem("Human", false);
		subItem.setMnemonic(KeyEvent.VK_H);
		subItem.setToolTipText("Second Player = Human");
		subItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setChanged();
				notifyObservers(new Event(Event.V_MENU_PLAYER_HUMAN_CLICK, null));
			}
		});
		subMenu.add(subItem);
		radioGroup.add(subItem);
		item = new JMenuItem("Exit");
		item.setMnemonic(KeyEvent.VK_E);
		item.setToolTipText("Exit Game");
		item.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setChanged();
				notifyObservers(new Event(Event.V_MENU_EXIT_GAME_CLICK, null));		
			}
		});
		menu.add(item);
		menuBar.add(menu);
		_frame = new JFrame();
		_frame.setTitle("Tic Tac Toe");
		_frame.setJMenuBar(menuBar);
		_frame.setSize(_model.getAppWidth(), _model.getAppHeight());
		_frame.setLocationRelativeTo(null);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.setVisible(true);
		_frame.setResizable(false);
	}
	
	private void initMenuUIFactory() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = (JMenu) SwingFactory.createMenuItem(ItemTypes.MENU, "Game", "Game Options", KeyEvent.VK_G, null);
		menu.add((JMenuItem) SwingFactory.createMenuItem(ItemTypes.ITEM, "New", "Start New Game", KeyEvent.VK_N, 
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					setChanged();
					notifyObservers(new Event(Event.V_MENU_NEW_GAME_CLICK, null));
				}
			}
		));
		JMenu submenu = (JMenu) SwingFactory.createMenuItem(ItemTypes.MENU, "Player", "Choose Second Player", KeyEvent.VK_P, 
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {}
			}
		);
		ButtonGroup group = new ButtonGroup();
		submenu.add((JRadioButtonMenuItem) SwingFactory.createMenuItem(ItemTypes.RADIO, "Computer", "Second Player = Computer", KeyEvent.VK_C, 
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					setChanged();
					notifyObservers(new Event(Event.V_MENU_PLAYER_COMPUTER_CLICK, null));
				}
			}, true, group
		));
		submenu.add((JRadioButtonMenuItem) SwingFactory.createMenuItem(ItemTypes.RADIO, "Human", "Second Player = Human", KeyEvent.VK_H, 
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						setChanged();
						notifyObservers(new Event(Event.V_MENU_PLAYER_HUMAN_CLICK, null));
					}
				}, false, group
		));
		menu.add(submenu);
		menu.add((JMenuItem) SwingFactory.createMenuItem(ItemTypes.ITEM, "Exit", "Exit Game", KeyEvent.VK_E, 
				new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						setChanged();
						notifyObservers(new Event(Event.V_MENU_EXIT_GAME_CLICK, null));	
					}
				}
			));
		menuBar.add(menu);
		_frame = new JFrame();
		_frame.setTitle("Tic Tac Toe");
		_frame.setJMenuBar(menuBar);
		_frame.setSize(_model.getAppWidth(), _model.getAppHeight());
		_frame.setLocationRelativeTo(null);
		_frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		_frame.setVisible(true);
		_frame.setResizable(false);
	}
	
	private void initGameUI() {
		_game = new JPanel();
		_game.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		_game.setLayout(new GridLayout(3,3,3,3));
		int cols = _model.getColsNum();
		int rows = _model.getRowsNum();
		int col = 0, row = 0;
		SwingButton button;
		for (row=0; row<rows; row++) {
			for (col=0; col<cols; col++) {
				button = new SwingButton();
				button.setName(col+"_"+row);
				button.setToken(EToken.TAC);
				button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent event) {
						String id = ((JButton)event.getSource()).getName();
						int col = Integer.parseInt(id.split("_")[0]);
						int row = Integer.parseInt(id.split("_")[1]);
						setChanged();
						notifyObservers(new Event(Event.V_CELL_CLICK, new Cell(new Position(col, row), EToken.TIC)));
					}
				});
				_game.add(button);
			}
		}
		_frame.add(_game);
	}
	
	private void initStatusBarUI() {
		_statusBar = new JPanel();
		_statusBar.setPreferredSize(new Dimension(_frame.getWidth(), 20));
		_statusBar.setLayout(new BoxLayout(_statusBar, BoxLayout.X_AXIS));
		_statusBar.setBorder(BorderFactory.createEmptyBorder(0,  5,  5,  0));
		_frame.add(_statusBar, BorderLayout.SOUTH);
		_statusLabel = new JLabel("Tic Tac Toe - Sample Java Application by Marek Lis");
		_statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
		_statusBar.add(_statusLabel);
	}
	
	public void update(Observable obj, Object o) {
		super.update(obj, o);
		Event event = (Event) o;
		String type = event.getType();
		int num, col, row;
		int cols = _model.getColsNum();
		int rows = _model.getRowsNum();
		Cell cell = null;
		SwingButton button = null;
		if (type.equals(Event.M_SET_CELL)) {
			cell = (Cell)event.getParams();
			num = cell.getPosition().getCol() + cell.getPosition().getRow() * _model.getRowsNum();
			button = (SwingButton)_game.getComponent(num);
			button.setToken(cell.getToken());
			button.setEnabled(false);
		} else
		if (type.equals(Event.M_CLEAR)) {
			for (row=0; row<rows; row++) {
				for (col=0; col<cols; col++) {
					num = col + row * rows;
					button = (SwingButton)_game.getComponent(num);
					button.setToken(EToken.TAC);
					button.setEnabled(true);
				}
			}
		} else
		if (type.equals(Event.M_GAME_COMPLETE)) {
			for (row=0; row<rows; row++) {
				for (col=0; col<cols; col++) {
					num = col + row * rows;
					button = (SwingButton)_game.getComponent(num);
					if (button.getToken() == EToken.TAC) {
						button.setEnabled(false);
					}
				}
			}
		}
	}
	
}
