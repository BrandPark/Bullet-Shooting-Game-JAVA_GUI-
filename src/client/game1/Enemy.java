package client.game1;

public interface Enemy extends Element{
	public boolean isHit(HitBox hitBox);
	public boolean isDead();
	public void diminishLife(int power); 
}
