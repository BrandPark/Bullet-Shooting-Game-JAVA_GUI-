package backup.steps.step4_ingame.movingObj.bullet;

public class Bullet2 extends Bullet{
	
	private int power;
	
	public Bullet2(BulletName name) {
		super(name);
		setPower(2);
	}
	private void setPower(int power) {
		this.power = power;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
