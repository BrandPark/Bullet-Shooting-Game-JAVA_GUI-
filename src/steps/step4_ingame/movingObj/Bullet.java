package steps.step4_ingame.movingObj;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import common.utils.ImageUtil;

public abstract class Bullet extends JLabel implements Runnable {
	private int power;
	private String imgUrl;
	private ImageIcon icon;
	
	public Bullet(String url) {
		super();
		this.power = 1;
		this.imgUrl = url;
		this.icon = new ImageIcon(url);
		setIcon(icon);
	}
	
	@Override
	public void setSize(int width, int height) {
		super.setSize(width,height);
		icon = ImageUtil.reSizing(icon, width,height);
	}
	public void setPower(int power) {
		this.power = power;
	}
	public void setImg(String imgUrl) {
		this.icon = new ImageIcon(imgUrl);
		setIcon(icon);
	}
	
}
