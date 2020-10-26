package client.game.impl;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.common.Size;
import client.game.ActionQueue;
import client.game.Projector;
import client.game.View;
import client.game.ViewQueue;

class ProjectorImpl extends JPanel implements Projector{
	private ViewQueue viewQueue;
	private ActionQueue actionQueue;
	private JFrame frame = null;
	private View view;
	
	public ProjectorImpl(JFrame frame) {
		setPreferredSize(new Dimension(Size.FRAME_W, Size.FRAME_H));
		addKeyListener(this);
		
		this.frame = frame;
		this.view = Views.MainView.getView();
		frame.add(this);
		
		
		new Thread(this).start();
		requestFocus();
		setFocusable(true);
	}
	
	@Override
	public void show(View view) {
		setScreen(view);
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
		if(view!=null)
			view.paint(g2d,this);
	}
	
	private void setScreen(View view) {
		this.view = view;
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
		view.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
	@Override
	public void setQueue(ActionQueue actionQueue, ViewQueue viewQueue) {
		this.actionQueue = actionQueue;
		this.viewQueue = viewQueue;
	}
	

}
