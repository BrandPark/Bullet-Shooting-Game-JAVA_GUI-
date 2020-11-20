package client.game.impl.view.view_3_ingame;

import java.awt.Image;

import client.game.HitBox;
import client.game.common.ImageUrl;
import client.game.common.Size;
import client.game.impl.view.AbstractBullet;

public class EnemyBullet1 extends AbstractBullet{

	public EnemyBullet1(int x, int y) {
		super(x, y);
	}

	@Override
	protected int initWidth() {
		return Size.ENEMY_BULLET1_W;
	}

	@Override
	protected int initHeight() {
		return Size.ENEMY_BULLET1_H;
	}

	@Override
	public boolean isInFrame() {
		if(getY() < Size.FRAME_H)
			return true;
		return false;
	}

	@Override
	protected HitBox initHitBox() {
		return new HitBoxImpl(getX(),getY(),getWidth(),getHeight());
	}

	@Override
	protected void bulletMove() {
		setY(getY()+1);
		hitBoxMove(getX(),getY(),getWidth(),getHeight());
	}

	@Override
	protected Image initImg() {
		return getImage(ImageUrl.ENEMY_BULLET1);
	}

	@Override
	protected int initPower() {
		return 1;
	}

	@Override
	protected int initSpeed() {
		return 5;
	}
	
}