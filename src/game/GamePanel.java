package game;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import common.Size;
import common.UnitLocation;
import common.UnitName;

public class GamePanel extends JPanel implements Runnable, KeyListener{
	private UserUnit userUnit;
	
	public GamePanel() {
		setPreferredSize(new Dimension(Size.FRAME_W,Size.FRAME_H));
		setLayout(null);
		
		userUnit = new UserUnit(UnitName.USER_UNIT1);
		userUnit.setSize(Size.USER_W, Size.USER_H);
		userUnit.setLocation(UnitLocation.USER_X,UnitLocation.USER_Y);
		add(userUnit);
		
		addKeyListener(this);

		setFocusable(true);
		requestFocus();
	}
	
	
	@Override
	public void run() {
		while(true) {
			userUnit.move();
			repaint();
			revalidate();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		userUnit.keyReleased(e);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		userUnit.keyPressed(e);
	}

	
}
