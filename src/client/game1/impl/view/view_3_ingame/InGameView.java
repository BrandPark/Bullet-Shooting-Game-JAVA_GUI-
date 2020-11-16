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
	private final List<Bullet> enemyBullets;
	private List<Bullet> userBullets;
	private Phase phase;
	
	public InGameView(Model model, User user) {
		this.model = model;
		this.user = user;
		this.phaseManager = new PhaseManager();
		this.userHandler = new UserHandler(user);
		this.phase = phaseManager.nextPhase();
		this.userBullets = user.getBullets();
		this.enemyBullets = phaseManager.getBullets();
	}
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		if(!user.paint(g2d, imageObserver))
			return false;
		if(!enemysPaint(g2d, imageObserver))
			return false;
		if(!bulletsPaint(g2d, imageObserver))
			return false;
		if(isPhaseClear())
			nextPhase();
		if(user.isDead())
			model.addCommand("GAME_OVER");
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
	
	private void nextPhase() {
		phase = phaseManager.nextPhase();
		if(phase == null) {
			model.addCommand("CLEAR");
		}
	}
	private boolean isPhaseClear() {
		if(phase.size() == 0) {
			return true;
		}
		return false;
	}
	private boolean enemysPaint(Graphics2D g2d, ImageObserver imageObserver) {
		removeDeadEnemy();
		
		for(Enemy enemy : phase) {
			if(!enemy.paint(g2d, imageObserver))
				return false;
		}
		return true;
	}
	
	private boolean bulletsPaint(Graphics2D g2d, ImageObserver imageObserver) {
		removeUserBulletOverFrame();
		removeUserBulletHitEnemy();
		removeEnemyBulletOverFrame();
		removeEnemyBulletHitUser();
		if(!userBulletPaint(g2d, imageObserver))
			return false;
		if(!enemyBulletPaint(g2d, imageObserver))
			return false;
		return true;
	}

	private boolean enemyBulletPaint(Graphics2D g2d, ImageObserver imageObserver) {
		int size = enemyBullets.size();
		for(int i=0;i<size;i++) {
			Bullet bullet = enemyBullets.get(i);
			if(!bullet.paint(g2d, imageObserver)) 
				return false;
		}
		return true;
	}
	
	private boolean userBulletPaint(Graphics2D g2d, ImageObserver imageObserver) {
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
	private void removeEnemyBulletOverFrame() {
		int size = enemyBullets.size();
		for(int i=0;i<size; i++) {
			Bullet bullet = enemyBullets.get(i);
			
			if(!bullet.isInFrame()) {
				bullet.remove();
				enemyBullets.remove(bullet);
				size--;
			}
		}
	}
	private void removeEnemyBulletHitUser() {
		int size = enemyBullets.size();
		for(int i=0;i<size; i++) {
			Bullet bullet = enemyBullets.get(i);
			if(user.isHit(bullet.getHitBox())) {
				bullet.remove();
				enemyBullets.remove(bullet);
				size--;
				user.damage();
			}	
		}
	}
	private void removeUserBulletOverFrame() {
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
	private void removeUserBulletHitEnemy() {
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
