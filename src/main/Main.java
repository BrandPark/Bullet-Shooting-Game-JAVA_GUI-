package viewer_impl;


import javax.swing.JFrame;

import interfaces.viewer.Viewer;

public class BulletGame {
	public static void main(String[] args) {
		JFrame frame = new JFrame("Bullet Shooting Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		Viewer viewer = new ViewerImpl(frame);
		viewer.show(null);
		
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
