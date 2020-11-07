package client.game2.context_impl.view._main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.common.Size;
import client.game2.Button;

class GameStartBtn implements Button {
	private int x = Size.FRAME_W/8 * 3;
	private int y = Size.FRAME_H/6 + 200;
	private int w = Size.FRAME_W/4;
	private int h = Size.FRAME_H/10;
	private Image img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/start_btn_normal.png");
	private String action = "GAME_START";
	
	@Override
	public void paint(Graphics2D g2d, ImageObserver imageObserver) {
		g2d.drawImage(img,x,y,w,h,imageObserver);
	}   

	@Override
	public void focus() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/start_btn_select.png");
	}
	@Override
	public void unfocus() {
		img = Toolkit.getDefaultToolkit().getImage("resource/img/btn/start_btn_normal.png");
	}

	@Override
	public String getAction() {
		return action;
	}
	
}
