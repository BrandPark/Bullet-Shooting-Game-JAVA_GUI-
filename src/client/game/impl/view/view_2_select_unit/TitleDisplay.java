package client.game.impl.view.view_2_select_unit;

import java.awt.Toolkit;

import client.game.common.ImageUrl;
import client.game.common.Size;
import client.game.impl.view.AbstractDisplay;


class TitleDisplay extends AbstractDisplay{
	public TitleDisplay() {
		this.x = Size.FRAME_W/4;
		this.y = Size.FRAME_H/40;
		this.w = Size.FRAME_W/2;
		this.h = Size.FRAME_H/4;
		this.img = Toolkit.getDefaultToolkit().getImage(ImageUrl.SELECT_TITLE);
	}
}
