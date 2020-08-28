package utils;

import java.awt.Image;

import javax.swing.ImageIcon;

import common.UnitName;

public abstract class ImageCal {
	
	
	public static ImageIcon reSizing(ImageIcon icon, int width, int height ) {
		Image img = icon.getImage();
		img = img.getScaledInstance(width,height,Image.SCALE_SMOOTH);
		icon.setImage(img);
		return icon;
	}
			
}
