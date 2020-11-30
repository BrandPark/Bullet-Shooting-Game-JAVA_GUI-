package client.game.impl;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import client.game.Model;
import client.game.Projector;
import client.game.User;
import client.game.View;
import client.game.common.Size;
import client.game.impl.view.ViewFactory;

class ProjectorImpl extends JPanel implements Projector, KeyListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private View view;
	private JFrame frame;
	private Image buffImg;
	private Graphics2D buffg;
	
	public ProjectorImpl() {
		setPreferredSize(new Dimension(Size.FRAME_W, Size.FRAME_H));
		frameInit();
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		createImgBuff();
		update(g);
	}
	
	@Override
	public void update(Graphics g) {
		clearBuffg();
		viewPaint(g);
	}
	
	@Override
	public void showMain(Model model) {
		clearView();
		view = ViewFactory.getMainView(model);
	}

	@Override
	public void showSelectUnit(Model model) {
		clearView();
		view = ViewFactory.getSelectUnitView(model);
	}

	@Override
	public void showInGame(User unit, Model model) {
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
	
	private void viewPaint(Graphics g) {
		if(view != null && view.paint(buffg,this)) {
			Graphics2D g2d = (Graphics2D)g;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.drawImage(buffImg,0,0,this);
			repaint();
		}
	}
	private void clearView() {
		if(view != null)
			view.stopView();
	}
	private void createImgBuff() {
		if(buffg == null) {
			buffImg = createImage(Size.FRAME_W,Size.FRAME_H);
			buffg = (Graphics2D) buffImg.getGraphics();
			buffg.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
		}
	}
	private void clearBuffg() {
		buffg.clearRect(0, 0, Size.FRAME_W, Size.FRAME_H);
		buffg.setBackground(new Color(80,188,223));
	}
}
