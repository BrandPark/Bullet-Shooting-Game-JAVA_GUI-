package common.utils;

import java.awt.Image;

import javax.swing.ImageIcon;

public abstract class ImageUtil {
	
	public static ImageIcon reSizing(ImageIcon icon, int width, int height ) {
		Image img = icon.getImage();
		img = img.getScaledInstance(width,height,Image.SCALE_SMOOTH);
		icon.setImage(img);
		return icon;
	}
			
}
