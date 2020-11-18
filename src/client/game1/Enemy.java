package client.game1;

import java.util.List;

public interface Enemy extends Element{
	public boolean isHit(HitBox hitBox);
	public boolean isDead();
	public void damage(int power); 
	public List<Bullet> getBullets();
	public void startMove();
	public void off();
}
