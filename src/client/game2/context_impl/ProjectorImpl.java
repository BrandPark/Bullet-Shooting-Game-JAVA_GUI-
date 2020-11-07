package client.game2.context_impl;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.common.Size;
import client.game2.Model;
import client.game2.Projector;
import client.game2.View;
import client.game2.context_impl.view.ViewFactory;

class ProjectorImpl extends JPanel implements Projector, KeyListener, Runnable{
	private View view;
	private JFrame frame;
	private Model model;
	
	public ProjectorImpl(Model model) {
		setPreferredSize(new Dimension(Size.FRAME_W, Size.FRAME_H));
		this.model = model;
		
		showMain();
		frameInit();
		
		addKeyListener(this);
		requestFocus();
		setFocusable(true);
	}

	@Override
	public void startProjector() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		while(true) {
			repaint();
			revalidate();
			setFrameDelay(30);
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

	@Override
	public void showMain() {
		clearView();
		view = ViewFactory.getMainView(model);
	}

	@Override
	public void showSelectUnit() {
		clearView();
		view = ViewFactory.getSelectUnitView(model);
	}

	@Override
	public void showInGame() {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		switch(code) {
		case KeyEvent.VK_UP: view.upKey();break;
		case KeyEvent.VK_DOWN: view.downKey();break;
		case KeyEvent.VK_LEFT: view.leftKey();break;
		case KeyEvent.VK_RIGHT: view.rightKey();break;
		case KeyEvent.VK_SPACE: view.spaceKey();break;
		}
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
		if(view != null)
			view.stopView();
	}
}
