package client.game.impl.view.view_3_ingame;

import java.awt.Image;
import java.util.List;

import client.game.Bullet;
import client.game.BulletType;
import client.game.common.ImageUrl;
import client.game.impl.view.AbstractEnemy;

public class Enemy1 extends AbstractEnemy{

	public Enemy1(int x, int y, List<Bullet> bullets) {
		super(x, y, bullets);
	}

	@Override
	protected BulletType initBulletType() {
		return new EnemyBulletType();
	}

	@Override
	protected Image initImage() {
		return getImage(ImageUrl.ENEMY1);
	}

	@Override
	protected int initLife() {
		return 3;
	}
	
}