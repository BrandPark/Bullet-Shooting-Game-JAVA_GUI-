package screen_2_selectunit.view;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

import interfaces.screen.Screen;

public class SelectUnitScreen implements Screen{

	@Override
	public void paint(Graphics2D g2d) {
		g2d.setColor(Color.BLACK);
		g2d.fillRect(100,100,100,100);
	}


	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
