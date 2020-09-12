package steps.step4_ingame.movingObj.bullet;

public class Bullet1 extends Bullet{
	private int power;
	
	public Bullet1(BulletName name) {
		super(name);
		setPower(1);
	}
	private void setPower(int power) {
		this.power = power;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
