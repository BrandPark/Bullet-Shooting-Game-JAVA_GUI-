package client.game1.impl.view.view_3_ingame;

import client.common.Size;
import client.game1.Bullet;

enum BulletType {
	UserBullet1{
		public Bullet getBullet(int x, int y) {
			return new UserBullet1(x, y);
		}

		@Override
		public int getBulletWidth() {
			return Size.USER_BULLET1_W;
		}
		
	},
	EnemyBullet1{
		public Bullet getBullet(int x, int y) {
			return new EnemyBullet1(x, y);
		}
		@Override
		public int getBulletWidth() {
			return Size.ENEMY_BULLET1_W;
		}
	};
	
	
	abstract public Bullet getBullet(int x, int y);
	abstract public int getBulletWidth();
}
