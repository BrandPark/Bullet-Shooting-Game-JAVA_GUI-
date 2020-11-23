package client.game.impl.view.view_3_ingame;

import client.game.Bullet;
import client.game.BulletType;

public class UserBulletType1 implements BulletType{

	@Override
	public Bullet getBullet(int x, int y) {
		return new UserBullet1(x, y);
	}

}
