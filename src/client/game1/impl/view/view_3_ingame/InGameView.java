package client.game1.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.List;

import client.game1.Bullet;
import client.game1.Enemy;
import client.game1.HitBox;
import client.game1.KeyHandler;
import client.game1.Model;
import client.game1.User;
import client.game1.View;

class InGameView implements View{
	private final Model model;
	private final User user;
	private final KeyHandler userHandler;
	private final PhaseManager phaseManager;
	private Phase phase;
	
	public InGameView(Model model, User user) {
		this.model = model;
		this.user = user;
		this.phaseManager = new PhaseManager();
		this.userHandler = new UserHandler(user);
		this.phase = phaseManager.nextPhase();
	}
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		if(!user.paint(g2d, imageObserver))
			return false;
		if(!enemysPaint(g2d, imageObserver))
			return false;
		if(!bulletsPaint(g2d, imageObserver))
			return false;
		return true;
	}

	@Override
	public void stopView() {
		user.off();
		phaseManager.off();
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
		if(phase.size() == 0) {
			phase = phaseManager.nextPhase();
		}
		if(phase == null) {
			model.addCommand("CLEAR");
			return true;
		}
		
		for(Enemy enemy : phase) {
			if(!enemy.paint(g2d, imageObserver))
				return false;
		}
		return true;
	}
	
	private boolean bulletsPaint(Graphics2D g2d, ImageObserver imageObserver) {
		List<Bullet> userBullets = user.getBullets();
		
		removeBulletOverFrame(userBullets);
		removeBulletHitEnemy(userBullets);
		if(!userBulletPaint(g2d, imageObserver))
			return false;
		return true;
	}

	private boolean userBulletPaint(Graphics2D g2d, ImageObserver imageObserver) {
		List<Bullet> userBullets = user.getBullets();
		int size = userBullets.size();
		for(int i=0;i<size;i++) {
			Bullet bullet = userBullets.get(i);
			if(!bullet.paint(g2d, imageObserver)) 
				return false;
		}
		return true;
	}
 
	private void removeDeadEnemy() {
		int size = phase.size();
		for(int i=0; i<size;i++) {
			Enemy enemy = phase.get(i);
			if(enemy.isDead()) {
				phase.remove(enemy);
				size--;
			}
		}
	}
	
	private void removeBulletOverFrame(List<Bullet> userBullets) {
		int size = userBullets.size();
		for(int i=0;i<size; i++) {
			Bullet bullet = userBullets.get(i);
			
			if(!bullet.isInFrame()) {
				bullet.remove();
				userBullets.remove(bullet);
				size--;
			}
		}
	}
	private void removeBulletHitEnemy(List<Bullet> userBullets) {
		int size = userBullets.size();
		for(int i=0;i<size; i++) {
			Bullet bullet = userBullets.get(i);
			int hitEnemyIndex = getHitEnemyIndex(bullet.getHitBox());
			if(hitEnemyIndex != -1) {
				bullet.remove();
				userBullets.remove(bullet);
				size--;
				phase.get(hitEnemyIndex).damage(bullet.getPower());
			}
		}
	}
	
	private int getHitEnemyIndex(HitBox hitBox) {
		if(phase == null) {
			return -1;
		}
		for(Enemy enemy : phase) {
			if(enemy.isHit(hitBox))
				return phase.indexOf(enemy);
		}
		return -1;
	}
}
