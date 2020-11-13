package client.game1.impl;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.common.Size;
import client.game1.Model;
import client.game1.Projector;
import client.game1.User;
import client.game1.View;
import client.game1.impl.view.ViewFactory;

class ProjectorImpl extends JPanel implements Projector, KeyListener{
	private View view;
	private JFrame frame;
	private Model model;
	private Image buffImg;
	private Graphics2D buffg;
	
	public ProjectorImpl(Model model) {
		setPreferredSize(new Dimension(Size.FRAME_W, Size.FRAME_H));
		this.model = model;
		
		showMain();
		frameInit();
	}

	@Override
	public void startProjector() {
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		if(buffg == null) {
			buffImg = createImage(Size.FRAME_W,Size.FRAME_H);
			buffg = (Graphics2D) buffImg.getGraphics();
			buffg.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		}
		update(g);
	}
	@Override
	public void update(Graphics g) {
		buffg.clearRect(0, 0, Size.FRAME_W, Size.FRAME_H);
		
		if(view != null && view.paint(buffg,this)) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.drawImage(buffImg,0,0,this);
			
			repaint();
		}
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
	public void showInGame(User unit) {
		clearView();
		view = ViewFactory.getInGameView(model, unit);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		view.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		view.keyReleased(e);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
	private void frameInit() {
		frame = new JFrame("Bullet Shooting Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		addKeyListener(this);
		requestFocus();
		setFocusable(true);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	private void clearView() {
		if(view != null)
			view.stopView();
	}
}
