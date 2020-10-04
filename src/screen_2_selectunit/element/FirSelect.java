package screen_2_selectunit.element;

import java.awt.Graphics2D;
import java.awt.Image;

import interfaces.element.Element;
import interfaces.element.User;
import interfaces.element.UserFactory;

public class FirSelect implements Element{
	private User user = null;
	private Image img = null;
	private int power = 0;
	private int speed = 0;
	
	private void init() {
		user = UserFactory.firUser();
		img = user.getImg();
		power = user.getPower();
		speed = user.getSpeed();
	}
	
	@Override
	public void paint(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
	}

	
}
