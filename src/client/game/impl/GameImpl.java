package client.game.impl;


import javax.swing.JFrame;

import client.dispatch_queue_service.Dispatcher;
import client.game.Game;
import client.game.Projector;
import client.game.ViewDispatchThread;

public class GameImpl implements Game{
	private Projector projector = null;
	private Dispatcher dispatchThread = null;
	private ActionDispatchThread actionDispatchThread = null;
	
	public GameImpl() {
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
