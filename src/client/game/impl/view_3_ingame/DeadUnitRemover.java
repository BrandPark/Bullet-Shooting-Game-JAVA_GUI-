package client.game.impl.view_3_ingame;

import java.util.List;

import client.game.Bullet;
import client.game.Enemy;
import client.game.HitBox;
import client.game.User;

class DeadUnitRemover {
	private List<Bullet> userBullets;
	private List<Bullet> enemyBullets;
	private User user;
	
	public DeadUnitRemover(List<Bullet> userBullets, List<Bullet> enemyBullets, User user) {
		this.userBullets = userBullets;
		this.enemyBullets = enemyBullets;
		this.user = user;
	}
	public void remove(Phase phase) {
		removeEnemy(phase);
		removeEnemyBulletOverFrame();
		removeEnemyBulletHitUser();
		removeUserBulletOverFrame();
		removeUserBulletHitEnemy(phase);
	}
	private void removeEnemy(Phase phase) {
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
	private void removeUserBulletHitEnemy(Phase phase) {
		int size = userBullets.size();
		for(int i=0;i<size; i++) {
			Bullet bullet = userBullets.get(i);
			int hitEnemyIndex = getHitEnemyIndex(bullet.getHitBox(), phase);
			if(hitEnemyIndex != -1) {
				bullet.remove();
				userBullets.remove(bullet);
				size--;
				phase.get(hitEnemyIndex).damage(bullet.getPower());
			}
		}
	}
	
	private int getHitEnemyIndex(HitBox hitBox, Phase phase) {
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
