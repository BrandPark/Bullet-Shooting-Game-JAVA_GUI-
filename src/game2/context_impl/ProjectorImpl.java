package game2.context_impl;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.common.Size;
import game2.Projector;
import game2.View;
import game2.context_impl.view.ViewFactory;

class ProjectorImpl extends JPanel implements Projector, KeyListener, Runnable{
	private View activeView;
	private JFrame frame;
	
	public ProjectorImpl() {
		setPreferredSize(new Dimension(Size.FRAME_W, Size.FRAME_H));
		
		showMain();
		frameInit();
		
		addKeyListener(this);
		requestFocus();
		setFocusable(true);
		
		Thread thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(true) {
			repaint();
			revalidate();
			setFrameDelay(300);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		if(activeView!=null)
			activeView.paint(g2d,this);
	}

	@Override
	public void showMain() {
		clearView();
		activeView = ViewFactory.getMainView();
	}

	@Override
	public void showSelectUnit() {
		
	}

	@Override
	public void showInGame() {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	private void frameInit() {
		frame = new JFrame("Bullet Shooting Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void setFrameDelay(int speed) {
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void clearView() {
		if(activeView != null)
			activeView.stopView();
	}
}
