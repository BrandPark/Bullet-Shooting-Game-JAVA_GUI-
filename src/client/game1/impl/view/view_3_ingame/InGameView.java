package client.game1.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import client.game1.Bullet;
import client.game1.Button;
import client.game1.Display;
import client.game1.Enemy;
import client.game1.KeyHandler;
import client.game1.Model;
import client.game1.User;
import client.game1.View;

class InGameView implements View{
	private final List<Button> buttons = new ArrayList<>();
	private final List<Display> displays = new ArrayList<>();
	private final List<Bullet> bullets; 
	private final Model model;
	private final User unit;
	private Enemy enemy;
	private final KeyHandler userHandler;
	public InGameView(Model model, User unit) {
		this.model = model;
		this.unit = unit;
		this.bullets = unit.getBullets();
		userHandler = new UserHandler(unit);
		
		this.enemy = new Enemy1();
	}
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		if(!unit.paint(g2d, imageObserver))
			return false;
		if(!bulletsPaint(g2d, imageObserver))
			return false;
		if(!enemy.paint(g2d, imageObserver))
			return false;
		return true;
	}

	@Override
	public void stopView() {
	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		userHandler.keyPressed(e);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		userHandler.keyReleased(e);
	}
	
	private boolean bulletsPaint(Graphics2D g2d, ImageObserver imageObserver) {
		int size = bullets.size();
		for(int i=0;i<size; i++) {
			Bullet bullet = bullets.get(i);
			if(!bullet.isInFrame()) {
				bullet.remove();
				bullets.remove(bullet);
				size--;
				continue;
			}
			if(enemy.isHit(bullet.getHitBox())) {
				bullet.remove();
				bullets.remove(bullet);
				size--;
				System.out.println("명중");
				continue;
			}
			if(!bullet.paint(g2d, imageObserver)) 
				return false;
		}
		return true;
	}
	
}
