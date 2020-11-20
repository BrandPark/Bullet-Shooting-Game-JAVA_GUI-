package client.game.impl.view.view_3_ingame;

import client.game.common.ImageUrl;

public class User3 extends AbstractUser{

	@Override
	protected void setSpeed() {
		this.speed = 1;
	}

	@Override
	protected void setBulletType() {
		this.bulletType = BulletType.UserBullet1;
	}

	@Override
	protected void setImg() {
		this.img = getImage(ImageUrl.USER3);
	}
}