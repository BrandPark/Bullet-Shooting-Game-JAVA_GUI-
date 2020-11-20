package client.game.impl.view.view_3_ingame;

import java.awt.Image;

import client.game.common.ImageUrl;

class User1 extends AbstractUser{

	@Override
	protected int initSpeed() {
		return 1;
	}

	@Override
	protected BulletType initBulletType() {
		return BulletType.UserBullet1;
	}

	@Override
	protected Image initImg() {
		return getImage(ImageUrl.USER1);
	}
}