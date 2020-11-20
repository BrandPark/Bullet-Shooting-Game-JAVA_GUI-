package client.game.impl.view.view_1_main;

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
import client.game.impl.view.AbstractButton;

class OptionBtn extends AbstractButton {
	public OptionBtn() {
		this.x = Size.FRAME_W / 8 * 3;
		this.y = Size.FRAME_H / 6 + 300;
		this.w = Size.FRAME_W / 4;
		this.h = Size.FRAME_H / 10;
		this.img = Toolkit.getDefaultToolkit().getImage(ImageUrl.OPTION_BUTTON);
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
