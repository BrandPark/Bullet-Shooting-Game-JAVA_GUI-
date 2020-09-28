package backup.steps.step4_ingame.movingObj.bullet;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import common.static_data.IconFactory;
import common.utils.ImageUtil;

public abstract class Bullet extends JLabel implements Runnable {
	private BulletName name;
	private ImageIcon icon = null;
	
	public Bullet(BulletName name) {
		icon = IconFactory.getBulletIcon(name);
	}
	
	@Override
	public void setSize(int width, int height) {
		super.setSize(width,height);
		icon = ImageUtil.reSizing(icon, width,height);
	}
	
}
