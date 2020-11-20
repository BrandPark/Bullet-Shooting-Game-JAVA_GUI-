package client.game.impl.view.view_3_ingame;

import java.awt.Image;

import client.game.HitBox;
import client.game.common.ImageUrl;
import client.game.common.Size;
import client.game.impl.view.AbstractBullet;

class UserBullet1 extends AbstractBullet{

	public UserBullet1(int x, int y) {
		super(x, y);
	}

	@Override
	protected int initWidth() {
		return Size.USER_BULLET1_W;
	}

	@Override
	protected int initHeight() {
		return Size.USER_BULLET1_H;
	}

	@Override
	public boolean isInFrame() {
		if(getY()+getHeight()>0)
			return true;
		return false;
	}

	@Override
	protected HitBox initHitBox() {
		return new HitBoxImpl(getX(),getY(),getWidth(),getHeight());
	}

	@Override
	protected void bulletMove() {
		setY(getY()-2);
		hitBoxMove(getX(),getY(),getWidth(),getHeight());
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
