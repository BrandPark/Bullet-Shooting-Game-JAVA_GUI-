package client.game.impl.view.view_2_select_unit;

import java.awt.Toolkit;

import client.game.Command;
import client.game.Model;
import client.game.Projector;
import client.game.common.ImageUrl;
import client.game.common.Location;
import client.game.common.Size;
import client.game.impl.view.AbstractButton;
import client.game.impl.view.ViewFactory;


class UserBtn3 extends AbstractButton {

	public UserBtn3() {
		this.x = Location.SELECT_CARD_THIRD_X;
		this.y = Location.SELECT_CARD_Y;
		this.w= Size.SELECT_CARD_W;
		this.h = Size.SELECT_CARD_H;
		this.img = Toolkit.getDefaultToolkit().getImage(ImageUrl.THIRD_USER_CARD);
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
			projector.showInGame(ViewFactory.getUser3(), model);
		}
	}
}
