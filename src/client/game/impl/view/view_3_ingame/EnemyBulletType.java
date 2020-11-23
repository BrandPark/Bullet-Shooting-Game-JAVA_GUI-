package client.game.impl.view.view_3_ingame;

import client.game.Bullet;
import client.game.BulletType;

public class EnemyBulletType implements BulletType{

	@Override
	public Bullet getBullet(int x, int y) {
		return new EnemyBullet1(x, y);
	}

}
