package client.game.common;

abstract public class Location {
	
//	Select Card
	public static final int SELECT_CARD_FIRST_X = Size.SELECT_CARD_HG;
	public static final int SELECT_CARD_SECOND_X = (Size.SELECT_CARD_HG * 2) + Size.SELECT_CARD_W;
	public static final int SELECT_CARD_THIRD_X = (Size.SELECT_CARD_HG * 3) + (Size.SELECT_CARD_W * 2);
	public static final int SELECT_CARD_Y = Size.FRAME_H/3;
	
//	Unit
	public static final int USER_X = (Size.FRAME_W - Size.USER_W)/2;
	public static final int USER_Y = Size.FRAME_H - Size.USER_H - 50;
}
