package client.game;

import java.awt.Image;

public interface User extends Unit{
	public Image getImg();
	public int getPower();
	public int getSpeed();
	public int getX();
	public int getY();
}
