package client.game1.impl.view.view_1_main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.common.ImageUrl;
import client.common.Size;
import client.game1.Button;

class OptionBtn implements Button {
	private int x = Size.FRAME_W / 8 * 3;
	private int y = Size.FRAME_H / 6 + 300;
	private int w = Size.FRAME_W / 4;
	private int h = Size.FRAME_H / 10;
	private Image img = Toolkit.getDefaultToolkit().getImage(ImageUrl.OPTION_BUTTON);
	private String action = "OPTION";

	@Override
	public boolean paint(Graphics2D g2d,ImageObserver imageObserver) {
		Toolkit.getDefaultToolkit().prepareImage(img, -1, -1, imageObserver);
		if(g2d.drawImage(img, x, y, w, h,imageObserver))
			return true;
		return false;
	}

	@Override
	public void focus() {
		img = Toolkit.getDefaultToolkit().getImage(ImageUrl.OPTION_BUTTON_SELECTED);
	}

	@Override
	public void unfocus() {
		img = Toolkit.getDefaultToolkit().getImage(ImageUrl.OPTION_BUTTON);
	}

	@Override
	public String getAction() {
		return action;
	}
	
}
