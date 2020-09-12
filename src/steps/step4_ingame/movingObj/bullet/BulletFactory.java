package steps.step4_ingame.movingObj.bullet;

public abstract class BulletFactory {
	
	public static Bullet getBullet(BulletName name) {
		switch(name) {
		case BULLET1: return new Bullet1(name);
		case BULLET2: return new Bullet2(name);
		case BULLET3: return new Bullet3(name);
		}
		return null;
	}
}
