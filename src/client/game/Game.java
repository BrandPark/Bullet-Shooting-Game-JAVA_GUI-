package client.game;


import javax.swing.JFrame;

import client.game.action_service.ActionDispatchThread;

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
}
