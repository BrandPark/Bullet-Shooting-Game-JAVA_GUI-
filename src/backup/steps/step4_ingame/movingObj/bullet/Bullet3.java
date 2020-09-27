package backup.steps.step4_ingame.movingObj.bullet;

public class Bullet3 extends Bullet{

	private int power;
	
	public Bullet3(BulletName name) {
		super(name);
		setPower(3);
	}
	
	private void setPower(int power) {
		this.power = power;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
