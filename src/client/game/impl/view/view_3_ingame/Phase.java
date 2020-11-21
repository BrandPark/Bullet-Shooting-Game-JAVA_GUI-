package client.game.impl.view.view_3_ingame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import client.game.Bullet;
import client.game.Enemy;

public class Phase implements Iterable<Enemy> {
	private List<Enemy> enemys = new ArrayList<Enemy>();
	
	public List<Bullet> getEnemyBullets() {
		List<Bullet> bullets = new ArrayList<>();
		for(int i=0;i<enemys.size();i++) {
			bullets.addAll(enemys.get(i).getBullets());
		}
		return bullets;
	}
	
	@Override
	public Iterator<Enemy> iterator() {
		return enemys.iterator();
	}
	
	public void startPhase() {
		for(Enemy enemy : this) {
			enemy.startMove();
		}
	}
	
	public void remove(Enemy enemy) {
		enemys.remove(enemy);
	}
	
	public void add(Enemy enemy) {
		enemys.add(enemy);
	}
	
	public int size() {
		return enemys.size();
	}
	
	public Enemy get(int index) {
		return enemys.get(index);
	}
	public int indexOf(Enemy enemy) {
		return enemys.indexOf(enemy);
	}
}
