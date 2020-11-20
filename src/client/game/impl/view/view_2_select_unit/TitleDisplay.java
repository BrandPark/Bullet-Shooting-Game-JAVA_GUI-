package client.game.impl.view.view_2_select_unit;

import client.game.common.ImageUrl;
import client.game.common.Size;
import client.game.impl.view.AbstractDisplay;


class TitleDisplay extends AbstractDisplay{
	public TitleDisplay() {
		setX(Size.FRAME_W/4);
		setY(Size.FRAME_H/40);
		setWidth(Size.FRAME_W/2);
		setHeight(Size.FRAME_H/4);
		setImage(getImage(ImageUrl.SELECT_TITLE));
	}
}
