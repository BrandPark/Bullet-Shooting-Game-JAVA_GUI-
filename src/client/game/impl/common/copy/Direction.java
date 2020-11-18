package client.game.impl.common.copy;

abstract public class Direction {
	public static final int RIGHT = 1;
	public static final int LEFT = 2;
	public static final int UP = 8;
	public static final int DOWN = 4;
	public static final int RIGHTUP = RIGHT | UP;
	public static final int RIGHTDOWN = RIGHT | DOWN;
	public static final int LEFTUP = LEFT | UP;
	public static final int LEFTDOWN = LEFT | DOWN;
}
