package client.game2.context_impl.view._select_unit;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.common.Size;
import client.game2.Button;


class UserBtn3 implements Button{

	private int x = (3*Size.SELECT_CARD_HG) + (2*Size.SELECT_CARD_W);
	private int y = 200;
	private int w= Size.SELECT_CARD_W;
	private int h = Size.SELECT_CARD_H;
	private ImageObserver imageObserver;
	private Image img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/third_user_card.png");
	private String action = "SELECT_USER_3";
	
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
//		Toolkit.getDefaultToolkit().prepareImage(img, -1, -1, imageObserver);
		this.imageObserver = imageObserver;
		if(g2d.drawImage(img, x, y, w, h,imageObserver))
			return true;
		return false;
	}
	
	@Override
	public boolean focus() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/third_user_card_selected.png");
		if(Toolkit.getDefaultToolkit().prepareImage(img, -1, -1, imageObserver))
			return true;
		return false;
	}

	@Override
	public boolean unfocus() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/third_user_card.png");
		if(Toolkit.getDefaultToolkit().prepareImage(img, -1, -1, imageObserver))
			return true;
		return false;
	}

	@Override
	public String getAction() {
		return action;
	}
}
