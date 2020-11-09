package client.game1.context_impl.view.view_2_select_unit;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.common.Size;
import client.game1.Button;


class UserBtn3 implements Button{

	private int x = (3*Size.SELECT_CARD_HG) + (2*Size.SELECT_CARD_W);
	private int y = 200;
	private int w= Size.SELECT_CARD_W;
	private int h = Size.SELECT_CARD_H;
	private Image img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/third_user_card.png");
	private String action = "SELECT_USER_3";
	
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		Toolkit.getDefaultToolkit().prepareImage(img, -1, -1, imageObserver);
		if(g2d.drawImage(img, x, y, w, h,imageObserver))
			return true;
		return false;
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
	public String getAction() {
		return action;
	}
}
