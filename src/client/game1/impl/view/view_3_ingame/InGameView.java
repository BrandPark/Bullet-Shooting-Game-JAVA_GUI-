package client.game1.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import client.game1.Bullet;
import client.game1.Enemy;
import client.game1.HitBox;
import client.game1.KeyHandler;
import client.game1.Model;
import client.game1.User;
import client.game1.View;

class InGameView implements View{
	private final List<Enemy> enemys;
	private final List<Bullet> bullets;
	private final Model model;
	private final User unit;
	private final KeyHandler userHandler;
	public InGameView(Model model, User user) {
		this.model = model;
		this.unit = user;
		this.bullets = user.getBullets();
		this.enemys = Collections.synchronizedList(new ArrayList<Enemy>());
		this.userHandler = new UserHandler(user);
		
		enemys.add(new Enemy1(400,100));
		enemys.add(new Enemy1(200,100));
	}
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		if(!unit.paint(g2d, imageObserver))
			return false;
		if(!enemysPaint(g2d, imageObserver))
			return false;
		if(!bulletsPaint(g2d, imageObserver))
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
	
	
	private boolean enemysPaint(Graphics2D g2d, ImageObserver imageObserver) {
		removeDeadEnemy();
		for(Enemy enemy : enemys) {
			if(!enemy.paint(g2d, imageObserver))
				return false;
		}
		return true;
	}
	
	private boolean bulletsPaint(Graphics2D g2d, ImageObserver imageObserver) {
		synchronized(bullets) {
			removeBulletOverFrame();
			removeBulletHitEnemy();
			
			int size = bullets.size();
			for(int i=0;i<size;i++) {
				Bullet bullet = bullets.get(i);
				if(!bullet.paint(g2d, imageObserver)) 
					return false;
			}
		}
		return true;
	}
	private void removeDeadEnemy() {
		int size = enemys.size();
		for(int i=0; i<size;i++) {
			Enemy enemy = enemys.get(i);
			if(enemy.isDead()) {
				enemys.remove(enemy);
				size--;
			}
		}
	}
	
	private void removeBulletOverFrame() {
		int size = bullets.size();
		for(int i=0;i<size; i++) {
			Bullet bullet = bullets.get(i);
			
			if(!bullet.isInFrame()) {
				bullet.remove();
				bullets.remove(bullet);
				size--;
			}
		}
	}
	private void removeBulletHitEnemy() {
		int size = bullets.size();
		for(int i=0;i<size; i++) {
			Bullet bullet = bullets.get(i);
			int hitEnemyIndex = getHitEnemyIndex(bullet.getHitBox());
			if(hitEnemyIndex != -1) {
				bullet.remove();
				bullets.remove(bullet);
				size--;
				enemys.get(hitEnemyIndex).damage(bullet.getPower());
			}
		}
	}
	
	private int getHitEnemyIndex(HitBox hitBox) {
		for(Enemy enemy : enemys) {
			if(enemy.isHit(hitBox))
				return enemys.indexOf(enemy);
		}
		return -1;
	}
}
