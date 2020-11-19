package client.game.impl.view_1_main;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.game.Button;
import client.game.Command;
import client.game.Model;
import client.game.Projector;
import client.game.common.ImageUrl;
import client.game.common.Size;

class GameStartBtn implements Button {
	private int x = Size.FRAME_W/8 * 3;
	private int y = Size.FRAME_H/6 + 200;
	private int w = Size.FRAME_W/4;
	private int h = Size.FRAME_H/10;
	private Image img = Toolkit.getDefaultToolkit().getImage(ImageUrl.START_BUTTON);
	
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		Toolkit.getDefaultToolkit().prepareImage(img, -1, -1, imageObserver);
		if(g2d.drawImage(img,x,y,w,h,imageObserver))
			return true;
		return false;
	}   

	@Override
	public void focus() {
		img = Toolkit.getDefaultToolkit().getImage(ImageUrl.START_BUTTON_SELECTED);
	}
	@Override
	public void unfocus() {
		img = Toolkit.getDefaultToolkit().getImage(ImageUrl.START_BUTTON);
	}

	@Override
	public void doAction(Model model) {
		model.addCommand(new GameStartCommand());
	}
	
	private static class GameStartCommand implements Command {
		@Override
		public void execute(Projector projector, Model model) {
			projector.showSelectUnit(model);
		}
	}
}
