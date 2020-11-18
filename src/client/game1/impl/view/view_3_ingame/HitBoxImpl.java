package client.game1.impl.view.view_3_ingame;

import client.game1.HitBox;

class HitBoxImpl implements HitBox{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	
	public HitBoxImpl(int x, int y, int w, int h) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x+w;
		this.y2 = y+h;
	}
	@Override
	public boolean isCrash(HitBox hitBox) {
		int pX1 = hitBox.getStartX();
		int pY1 = hitBox.getStartY();
		int pX2 = hitBox.getEndX();
		int pY2 = hitBox.getEndY();
		
		if(x1 < pX2 && x2 > pX1 && y1 < pY2 && y2 > pY1)
			return true;
		return false;
	}
	
	@Override
	public void setLocation(int x, int y, int w, int h) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x+w;
		this.y2 = y+h;
	}
	@Override
	public int getStartX() {
		return x1;
	}
	@Override
	public int getStartY() {
		return y1;
	}
	@Override
	public int getEndX() {
		return x2;
	}
	@Override
	public int getEndY() {
		return y2;
	}
	

}
