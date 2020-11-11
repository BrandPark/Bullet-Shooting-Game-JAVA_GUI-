package client.game1;

public interface Bullet extends Element{
	public void remove();
	public boolean isDead();
	public boolean isInFrame();
	public HitBox getHitBox();
}
