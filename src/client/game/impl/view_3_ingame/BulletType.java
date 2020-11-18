package client.game.impl.view_3_ingame;

import client.game.Bullet;
import client.game.impl.common.Size;

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
