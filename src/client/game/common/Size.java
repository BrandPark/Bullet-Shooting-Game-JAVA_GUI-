package client.game.common;

public abstract class Size {
//	GamePanel	4:3
	public static final int FRAME_W = 800;
	public static final int FRAME_H = 600;
//	UserUnit
	public static final int USER_W = FRAME_W/16;	//50
	public static final int USER_H = FRAME_H/8;		//75
	
//	EnemyUnit
	public static final int ENEMY1_W = FRAME_W/16;	//50
	public static final int ENEMY1_H = FRAME_H/8;		//75
	
//	Bullet
	public static final int USER_BULLET1_W = USER_W/10;	//5
	public static final int USER_BULLET1_H = USER_H/2;	//35
	public static final int ENEMY_BULLET1_W = ENEMY1_W/3;	//15
	public static final int ENEMY_BULLET1_H = ENEMY1_W/3;		//15
	
//	Time & Score Label
	public static final int TIME_SCORE_W = 100;
	public static final int TIME_SCORE_H = 40;
	
//	Life Label
	public static final int LIFE_W = 50;
	public static final int LIFE_H = 50;
	
//	Select Card
	public static final int SELECT_CARD_W = FRAME_W/4;
	public static final int SELECT_CARD_H = FRAME_H/2;
	public static final int SELECT_CARD_HG = FRAME_W/16;
	

}
