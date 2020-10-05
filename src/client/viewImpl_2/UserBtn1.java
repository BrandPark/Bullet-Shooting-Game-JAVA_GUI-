package client.viewImpl_2;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.Button;
import client.common.Size;

public class UserBtn1 implements Button{
	
	private int x = Size.SELECT_CARD_HG;
	private int y = Size.SELECT_CARD_VG;
	private int w= Size.SELECT_CARD_W;
	private int h = Size.SELECT_CARD_H;
	private Image img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/first_user_card.png");
	
	@Override
	public void paint(Graphics2D g2d, ImageObserver imageObserver) {
		g2d.drawImage(img,x,y,w,h,imageObserver);
	}

	@Override
	public void focus() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/first_user_card_selected.png");
	}

	@Override
	public void unfocus() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/first_user_card.png");
	}

	@Override
	public void doAction() {
		// TODO Auto-generated method stub
		
	}
}
