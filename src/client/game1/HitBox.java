package client.game1;

public interface HitBox {
	public void setLocation(int x, int y, int w, int h);
	public int getStartX();
	public int getStartY();
	public int getEndX();
	public int getEndY();
	public boolean isCrash(HitBox hitBox);
}
