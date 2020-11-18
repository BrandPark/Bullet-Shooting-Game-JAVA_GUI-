package client.game1.impl.view.view_2_select_unit;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.common.ImageUrl;
import client.common.Location;
import client.common.Size;
import client.game1.Button;


class UserBtn2 implements Button{

	private int x = Location.SELECT_CARD_SECOND_X;
	private int y = Location.SELECT_CARD_Y;
	private int w= Size.SELECT_CARD_W;
	private int h = Size.SELECT_CARD_H;
	private Image img = Toolkit.getDefaultToolkit().getImage(ImageUrl.SECOND_USER_CARD);
	private String action = "SELECT_USER_2";
	
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		Toolkit.getDefaultToolkit().prepareImage(img, -1, -1, imageObserver);
		if(g2d.drawImage(img, x, y, w, h,imageObserver))
			return true;
		return false;
	}
	
	@Override
	public void focus() {
		img = Toolkit.getDefaultToolkit().getImage(ImageUrl.SECOND_USER_CARD_SELECTED);
	}

	@Override
	public void unfocus() {
		img = Toolkit.getDefaultToolkit().getImage(ImageUrl.SECOND_USER_CARD);
	}
	@Override
	public String getAction() {
		return action;
	}
}
