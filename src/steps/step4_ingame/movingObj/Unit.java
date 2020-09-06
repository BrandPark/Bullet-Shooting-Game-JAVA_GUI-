package steps.step4_ingame.movingObj;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import common.utils.ImageUtil;

public abstract class Unit extends JLabel{
	
	private int speed;
	private int life;
	private String imgUrl;
	private ImageIcon icon;

	public Unit(String url) {
		super();
		this.life = 3;
		this.imgUrl = url;
		this.icon = new ImageIcon(url);
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
	
	@Override
	public void setSize(int width, int height) {
		super.setSize(width,height);
		icon = ImageUtil.reSizing(icon, width,height);
		
	}
	

	
	
	
}
