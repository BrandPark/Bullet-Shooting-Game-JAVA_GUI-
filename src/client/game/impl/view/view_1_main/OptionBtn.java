package client.game.impl.view.view_1_main;

import client.game.Command;
import client.game.Model;
import client.game.Projector;
import client.game.common.ImageUrl;
import client.game.common.Size;
import client.game.impl.view.AbstractButton;

class OptionBtn extends AbstractButton {
	public OptionBtn() {
		setX(Size.FRAME_W / 8 * 3);
		setY(Size.FRAME_H / 6 + 300);
		setWidth(Size.FRAME_W / 4);
		setHeight(Size.FRAME_H / 10);
		setImage(getImage(ImageUrl.OPTION_BUTTON));
	}

	@Override
	public void focus() {
		setImage(getImage(ImageUrl.OPTION_BUTTON_SELECTED));
	}

	@Override
	public void unfocus() {
		setImage(getImage(ImageUrl.OPTION_BUTTON));
	}

	@Override
	public void doAction(Model model) {
		model.addCommand(new OptionCommand());
	}
	
	private static class OptionCommand implements Command {
		@Override
		public void execute(Projector projector, Model model) {
			System.out.println("옵션버튼 선택");
		}
	}
}
