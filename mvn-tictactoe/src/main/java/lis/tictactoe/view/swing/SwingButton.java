package lis.tictactoe.view.swing;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JButton;

import lis.tictactoe.model.EToken;

public class SwingButton extends JButton {

	private EToken _token;
	
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //System.out.println("DRAW " + _token.toString() );
        drawToken(g, _token);
    }
    
	private void drawToken(Graphics image, EToken token) {
		int width = getWidth();
		int height = getHeight();
		int midX = width >> 1;
		int midY = height >> 1;
		int min = (int) (Math.min(width, height) * 0.75);
		image.setColor(Color.BLACK);
		if (token == EToken.TIC) {
			image.drawLine(width - min, height - min, min, min);
			image.drawLine(width - min, min, min, height - min);
		} else
		if (token == EToken.TOE) {
			image.drawOval((width - min) >> 1, (height - min) >> 1, min, min);
		}
	}
    
    public void setToken(EToken token) {
    	_token = token;
		//setText(_token.toString());
    }
    
    public EToken getToken() {
    	return _token;
    }
    
}
