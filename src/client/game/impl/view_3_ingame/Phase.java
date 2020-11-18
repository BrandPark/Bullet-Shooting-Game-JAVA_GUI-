package client.game.impl.view_3_ingame;

import java.util.ArrayList;
import java.util.List;

import client.game.Bullet;
import client.game.Enemy;

public class Phase extends ArrayList<Enemy>{
	public List<Bullet> getEnemyBullets() {
		List<Bullet> bullets = new ArrayList<>();
		for(int i=0;i<size();i++) {
			bullets.addAll(get(i).getBullets());
		}
		return bullets;
	}
	public void startPhase() {
		for(Enemy enemy : this) {
			enemy.startMove();
		}
	}
}
