package screen_2_selectunit.element;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import interfaces.element.User;

public class FirUser implements User{
	private Image img = null;
	private int power = 0;
	private int speed = 0;
	
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
	public void paint(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Image getImg() {
		return img;
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