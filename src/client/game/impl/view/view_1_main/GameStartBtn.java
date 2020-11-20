package client.game.impl.view.view_1_main;

import client.game.Command;
import client.game.Model;
import client.game.Projector;
import client.game.common.ImageUrl;
import client.game.common.Size;
import client.game.impl.view.AbstractButton;

class GameStartBtn extends AbstractButton {
	
	public GameStartBtn() {
		setX(Size.FRAME_W/8 * 3);
		setY(Size.FRAME_H/6 + 200);
		setWidth(Size.FRAME_W/4);
		setHeight(Size.FRAME_H/10);
		setImage(getImage(ImageUrl.START_BUTTON));
	}

	@Override
	public void focus() {
		setImage(getImage(ImageUrl.START_BUTTON_SELECTED));
	}
	@Override
	public void unfocus() {
		setImage(getImage(ImageUrl.START_BUTTON));
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
