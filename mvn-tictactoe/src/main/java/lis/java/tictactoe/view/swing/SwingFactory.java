package lis.java.tictactoe.view.swing;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;

/**
 * Tic Tac Toe Game UI Factory.
 * Marek Lis
 */
public class SwingFactory {
	
	public static AbstractButton createMenuItem(ItemTypes type, String label, String tooltip, int keyCode, ActionListener listener) {
		AbstractButton result = null;
		if (type.equals(ItemTypes.MENU)) {
			result = createMenu(label,tooltip,keyCode,listener);
		} else
		if (type.equals(ItemTypes.ITEM)) {
			result = createMenuItem(label, tooltip, keyCode, listener);
		}
		return result;
	}
	
	public static AbstractButton createMenuItem(ItemTypes type, String label, String tooltip, int keyCode, ActionListener listener, boolean selected) {
		AbstractButton result = null;
		if (type.equals(ItemTypes.CHECKBOX)) {
			result = createMenuCheckBoxItem(label, tooltip, keyCode, listener, selected);
		}
		return result;
	}
	
	public static AbstractButton createMenuItem(ItemTypes type, String label, String tooltip, int keyCode, ActionListener listener, boolean selected, ButtonGroup group) {
		AbstractButton result = null;
		if (type.equals(ItemTypes.RADIO)) {
			result = createMenuRadioItem(label, tooltip, keyCode, listener, selected, group);
		}
		return result;
	}
	
	
	private static JMenuItem createMenu(String label, String tooltip, int keyCode, ActionListener listener) {
		JMenu item = new JMenu(label);
		item.setMnemonic(keyCode);
		item.setToolTipText(tooltip);
		item.addActionListener(listener);
		return item;
	}
	
	private static JMenuItem createMenuItem(String label, String tooltip, int keyCode, ActionListener listener) {
		JMenuItem item = new JMenuItem(label);
		item.setMnemonic(keyCode);
		item.setToolTipText(tooltip);
		item.addActionListener(listener);
		return item;
	}
	
	private static JMenuItem createMenuRadioItem(String label, String tooltip, int keyCode, ActionListener listener, boolean selected, ButtonGroup group) {
		JRadioButtonMenuItem item = new JRadioButtonMenuItem(label);
		item.setMnemonic(keyCode);
		item.setToolTipText(tooltip);
		item.setSelected(selected);
		item.addActionListener(listener);
		group.add(item);
		return item;
	}
	
	private static JMenuItem createMenuCheckBoxItem(String label, String tooltip, int keyCode, ActionListener listener, boolean selected) {
		JCheckBoxMenuItem item = new JCheckBoxMenuItem(label);
		item.setMnemonic(keyCode);
		item.setToolTipText(tooltip);
		item.setSelected(selected);
		item.addActionListener(listener);
		return item;
	}
	
}
