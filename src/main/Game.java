package main;


import javax.swing.JFrame;

import client.Projector;
import dispatcher_service.ViewDispatchThread;
import dispatcher_service.impl.ProjectorImpl;
import dispatcher_service.impl.ViewDispatchThreadImpl;

public class Game {
	private Projector projector = null;
	private ViewDispatchThread dispatchThread = null;
	
	
	public Game() {
		JFrame frame = new JFrame("Bullet Shooting Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		projector = new ProjectorImpl(frame);
		dispatchThread = new ViewDispatchThreadImpl(projector);
		
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Game();
	}
}
