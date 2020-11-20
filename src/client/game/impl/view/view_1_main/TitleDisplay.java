package client.game.impl.view.view_1_main;

import client.game.common.ImageUrl;
import client.game.common.Size;
import client.game.impl.view.AbstractDisplay;

class TitleDisplay extends AbstractDisplay{
	
	public TitleDisplay() {
		this.x = Size.FRAME_W/4;
		this.y = Size.FRAME_H/6;
		this.w = Size.FRAME_W/2;
		this.h = Size.FRAME_H/3;
		this.img = getImage(ImageUrl.MAIN_TITLE);
	}
}
