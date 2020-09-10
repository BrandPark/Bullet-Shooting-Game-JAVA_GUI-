package common.static_data;

import javax.swing.ImageIcon;

import steps.step4_ingame.movingObj.BulletName;
import steps.step4_ingame.movingObj.UnitName;

public abstract class IconFactory {
	public ImageIcon getUnitIcon(UnitName name) {
		switch(name) {
		case USER_UNIT1 : return new ImageIcon(ImageUrl.USER_UNIT1);
		case USER_UNIT2 : return new ImageIcon(ImageUrl.USER_UNIT2);
		case USER_UNIT3 : return new ImageIcon(ImageUrl.USER_UNIT3);
		}
		return null;
	}
	public ImageIcon getBulletIcon(BulletName name) {
		switch(name) {
		case BULLET1 : return new ImageIcon(ImageUrl.BULLET1);
		case BULLET2 : return new ImageIcon(ImageUrl.BULLET2);
		case BULLET3 : return new ImageIcon(ImageUrl.BULLET3);
		}
	}
	
}
