package client.game;

import java.util.List;

public interface User extends Element{
	public void setDirection(int moveDirection);
	public void shoot();
	public void stopShoot();
	public List<Bullet> getBullets();
	public void off();
	public boolean isHit(HitBox hitBox);
	public void damage();
	public boolean isDead();
}
