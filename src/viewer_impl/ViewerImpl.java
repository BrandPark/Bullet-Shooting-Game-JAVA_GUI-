package viewer_impl;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import common.static_data.Size;
import interfaces.screen.Screen;
import interfaces.screen.ScreenName;
import interfaces.viewer.Viewer;

public class ViewerImpl extends JPanel implements Viewer{
	private Screen screen = null;
	private JFrame frame = null;
	
	public ViewerImpl(JFrame frame) {
		this.frame = frame;
		setPreferredSize(new Dimension(Size.FRAME_W, Size.FRAME_H));
		frame.add(this);
		addKeyListener(this);
		new Thread(this).start();
		
		requestFocus();
		setFocusable(true);
	}
	
	@Override
	public void show(ScreenName name) {
		if(name == null) {
			firstStart();
			return;
		}
		removeScreen(screen);
		setScreen(name.getScreen());
	}

	@Override
	public void run() {
		while(true) {
			repaint();
			revalidate();
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(screen!=null)
			screen.paint(g2d);
	}
	
	
	private void firstStart() {
		if(screen == null) {
			this.screen = ScreenName.MainScreen.getScreen();
			setScreen(screen);
		}
	}
	private void setScreen(Screen screen) {
		this.screen = screen;
	}
	private void removeScreen(Screen screen) {
		if(screen != null) 
			screen.remove();
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		screen.keyPressed(e);
		System.out.println("입력!");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		screen.keyReleased(e);
		System.out.println("입력!");
	}
}
