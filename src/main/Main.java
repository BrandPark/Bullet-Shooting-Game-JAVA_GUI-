package main;


import javax.swing.JFrame;

import dispatcher_service.ScreenService;
import dispatcher_service.impl.ScreenDispatcherImpl;

public class Main {
	
	public Main() {
		JFrame frame = new JFrame("Bullet Shooting Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		new ScreenDispatcherImpl(frame);
		
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public void start() {
		ScreenService.doInit();
	}
	public static void main(String[] args) {
		new Main().start();
	}
}
