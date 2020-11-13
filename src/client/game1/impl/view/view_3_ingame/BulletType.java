package client.game1.impl.view.view_3_ingame;

import client.game1.Bullet;

enum BulletType {
	Bullet1{
		public Bullet getBullet(int x, int y) {
			return new Bullet1(x, y);
		}
	};
	
	abstract public Bullet getBullet(int x, int y);
}
