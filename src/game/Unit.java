package game;

import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import utils.ImageCal;

public abstract class Unit extends JLabel{
	
	private int speed;
	private int life;
	private String imgUrl;
	private ImageIcon icon;

	public Unit(String url) {
		super();
		this.imgUrl = url;
		icon = new ImageIcon(url);
		setIcon(icon);
	}
	protected void setSpeed(int speed) {
		this.speed = speed;
	}
	protected int getSpeed() {
		return speed;
	}
	protected void setLife(int life) {
		this.life = life;
	}
	@Override
	public void setSize(int width, int height) {
		super.setSize(width,height);
		icon = ImageCal.reSizing(icon, width,height);
		
	}
	

	
	
	
}
