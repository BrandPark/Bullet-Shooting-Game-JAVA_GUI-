package steps.step4_ingame.movingObj;

public abstract class BulletFactory {
	public static Bullet getBullet(BulletName name) {
		switch(name) {
		case BULLET1: return new Bullet1();
		}
		return null;
	}
}
