package client.game.impl.view_2_select_unit;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

import client.game.Button;
import client.game.Command;
import client.game.Model;
import client.game.Projector;
import client.game.common.ImageUrl;
import client.game.common.Location;
import client.game.common.Size;
import client.game.impl.ViewFactory;


class UserBtn3 implements Button{

	private int x = Location.SELECT_CARD_THIRD_X;
	private int y = Location.SELECT_CARD_Y;
	private int w= Size.SELECT_CARD_W;
	private int h = Size.SELECT_CARD_H;
	private Image img = Toolkit.getDefaultToolkit().getImage(ImageUrl.THIRD_USER_CARD);
	
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		Toolkit.getDefaultToolkit().prepareImage(img, -1, -1, imageObserver);
		if(g2d.drawImage(img, x, y, w, h,imageObserver))
			return true;
		return false;
	}
	
	@Override
	public void focus() {
		img = Toolkit.getDefaultToolkit().getImage(ImageUrl.THIRD_USER_CARD_SELECTED);
	}

	@Override
	public void unfocus() {
		img = Toolkit.getDefaultToolkit().getImage(ImageUrl.THIRD_USER_CARD);
	}

	@Override
	public void doAction(Model model) {
		model.addCommand(new SelectUserCommand());
	}
	
	private static class SelectUserCommand implements Command {
		@Override
		public void execute(Projector projector, Model model) {
			projector.showInGame(ViewFactory.getUser1(), model);
		}
	}
}
