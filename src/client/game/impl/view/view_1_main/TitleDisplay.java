package client.game.impl.view.view_1_main;

import client.game.common.ImageUrl;
import client.game.common.Size;
import client.game.impl.view.AbstractDisplay;

class TitleDisplay extends AbstractDisplay{
	
	public TitleDisplay() {
		setX(Size.FRAME_W/4);
		setY(Size.FRAME_H/6);
		setWidth(Size.FRAME_W/2);
		setHeight(Size.FRAME_H/3);
		setImage(getImage(ImageUrl.MAIN_TITLE));
	}
}
