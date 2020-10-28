package client.game.impl;


import javax.swing.JFrame;

import client.game.AbstractProjector;
import client.game.ActionDispatcher;
import client.game.Configure;
import client.game.Game;
import client.game.ViewDispatcher;

class GameImpl implements Game{
	private final AbstractProjector projector;
	private final ViewDispatcher viewDispatcher;
	private final ActionDispatcher actionDispatcher;
	private final JFrame frame;
	
	public GameImpl(Configure configure) {
		projector = configure.getProjector();
		viewDispatcher = configure.getViewDispatcher();
		actionDispatcher = configure.getActionDispatcher();
		
		frame = new JFrame("Bullet Shooting Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(projector);
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	@Override
	public void gameStart() {
		viewDispatcher.startThread();
		actionDispatcher.startThread();
		projector.projectorStart();
	}
	@Override
	public void gameExit() {
		// TODO Auto-generated method stub
	}
}
