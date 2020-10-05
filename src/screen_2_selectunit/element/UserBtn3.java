package screen_2_selectunit.element;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import common.static_data.Size;
import interfaces.element.Button;

public class UserBtn3 implements Button{

	private int x = (3*Size.SELECT_CARD_HG) + (2*Size.SELECT_CARD_W);
	private int y = 200;
	private int w= Size.SELECT_CARD_W;
	private int h = Size.SELECT_CARD_H;
	private Image img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/third_user_card.png");
	
	@Override
	public void paint(Graphics2D g2d, ImageObserver imageObserver) {
		g2d.drawImage(img,x,y,w,h,imageObserver);
	}
	
	@Override
	public void focus() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/third_user_card_selected.png");
	}

	@Override
	public void unfocus() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/third_user_card.png");
	}

	@Override
	public void doAction() {
	}
}
