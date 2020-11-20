package client.game.impl.view.view_3_ingame;

import java.awt.Image;

import client.game.HitBox;
import client.game.common.ImageUrl;
import client.game.impl.view.AbstractBullet;

class UserBullet1 extends AbstractBullet{

	public UserBullet1(int x, int y) {
		super(x, y);
	}

	@Override
	public boolean isInFrame() {
		if(y+h>0)
			return true;
		return false;
	}

	@Override
	protected HitBox initHitBox() {
		return new HitBoxImpl(x,y,w,h);
	}

	@Override
	protected void bulletMove() {
		y-=2;
		hitBoxMove(x,y,w,h);
	}

	@Override
	protected Image initImg() {
		return getImage(ImageUrl.USER_BULLET1);
	}

	@Override
	protected int initPower() {
		return 1;
	}

	@Override
	protected int initSpeed() {
		return 9;
	}
	
}
