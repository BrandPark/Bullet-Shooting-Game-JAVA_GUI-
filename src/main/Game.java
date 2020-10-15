package main;


import javax.swing.JFrame;

import client.Projector;
import dispatcher_service.DispatchThread;
import dispatcher_service.impl.ActionDispatchThread;
import dispatcher_service.impl.ProjectorImpl;
import dispatcher_service.impl.ViewDispatchThread;

public class Game {
	private Projector projector = null;
	private DispatchThread dispatchThread = null;
	private ActionDispatchThread actionDispatchThread = null;
	
	public Game() {
		JFrame frame = new JFrame("Bullet Shooting Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		projector = new ProjectorImpl(frame);
		dispatchThread = new ViewDispatchThread(projector);
		dispatchThread.startThread();
		actionDispatchThread = new ActionDispatchThread();
		actionDispatchThread.startThread();
		
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new Game();
	}
}
