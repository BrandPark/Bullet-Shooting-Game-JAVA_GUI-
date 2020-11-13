package client.game1.impl.view.view_3_ingame;

import client.game1.Bullet;

enum BulletType {
	UserBullet1{
		public Bullet getBullet(int x, int y) {
			return new UserBullet1(x, y);
		}
	},
	EnemyBullet1{
		public Bullet getBullet(int x, int y) {
			return new EnemyBullet1(x, y);
		}
	};
	
	
	abstract public Bullet getBullet(int x, int y);
}
