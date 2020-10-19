package client.game.view.viewImpl_2;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.game.view.User;

public class FirUser implements User {
	private Image img = null;
	private int power = 0;
	private int speed = 0;
	private int x = 0;
	private int y = 0;

	public FirUser() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/user/first_user.png");
		power = 5;
		speed = 3;
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paint(Graphics2D g2d, ImageObserver imageObserver) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getImg() {
		return img;
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getPower() {
		return power;
	}

	@Override
	public int getSpeed() {
		return speed;
	}

}
