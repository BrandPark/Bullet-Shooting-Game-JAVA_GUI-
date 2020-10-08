package dispatcher_service.impl;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.Screen;
import client.Viewer;
import client.common.Size;

public class ViewerImpl extends JPanel implements Viewer{
	private Screen screen = null;
	
	public ViewerImpl() {
		setPreferredSize(new Dimension(Size.FRAME_W, Size.FRAME_H));
		addKeyListener(this);
		new Thread(this).start();
		requestFocus();
		setFocusable(true);
	}
	
	@Override
	public void addTo(JFrame frame) {
		frame.add(this);
	}
	
	@Override
	public void show(Screen screen) {
		setScreen(screen);
	}

	@Override
	public void run() {
		while(true) {
			repaint();
			revalidate();
			gameSpeed(30);
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(screen!=null)
			screen.paint(g2d,this);
	}
	
	private void setScreen(Screen screen) {
		this.screen = screen;
	}
	private void gameSpeed(int speed) {
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent e) {
		screen.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		screen.keyReleased(e);
	}

	

}
