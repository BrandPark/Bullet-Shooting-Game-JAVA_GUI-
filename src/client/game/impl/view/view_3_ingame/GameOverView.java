package client.game.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import client.game.KeyHandler;
import client.game.Model;
import client.game.View;

class GameOverView implements View{
	private Model model;
	private KeyHandler menuHandler;
	
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		return false;
	}

	@Override
	public void stopView() {
		// TODO Auto-generated method stub
		
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
