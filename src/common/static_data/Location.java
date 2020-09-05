package common.static_data;

public abstract class Location{
//	User unit
	public static final int USER_X = Size.FRAME_W/2;
	public static final int USER_Y = Size.FRAME_H-100;
	

//	Time & Score Panel
	public static final int TIME_SCORE_X = Size.FRAME_W - Size.TIME_SCORE_W;
	public static final int TIME_SCORE_Y = Size.TIME_SCORE_H;

	public static final int LIFE_X = 10;
	public static final int LIFE_Y = Size.FRAME_H - Size.LIFE_H;
}