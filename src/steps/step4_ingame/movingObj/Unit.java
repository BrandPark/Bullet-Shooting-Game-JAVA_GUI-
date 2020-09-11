package steps.step4_ingame.movingObj;

import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import common.static_data.IconFactory;
import common.utils.ImageUtil;

public abstract class Unit extends JLabel{
	
	private UnitName name;
	private int speed;
	private int life;
	private String imgUrl;
	private ImageIcon icon;
	private Vector<Bullet> bullets = new Vector<>();

	public Unit(UnitName name) {
		super();
		this.name = name;
		this.life = 3;
		this.icon = IconFactory.getUnitIcon(name);
		setIcon(icon);
	}
	
	void setSpeed(int speed) {
		this.speed = speed;
	}
	int getSpeed() {
		return speed;
	}
	void setLife(int life) {
		this.life = life;
	}
	abstract public void shoot();
	protected 
	@Override
	public void setSize(int width, int height) {
		super.setSize(width,height);
		icon = ImageUtil.reSizing(icon, width,height);
		
	}
	

	
	
	
}
