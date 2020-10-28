package client.game.impl;


import javax.swing.JFrame;

import client.game.AbstractProjector;
import client.game.ActionDispatcher;
import client.game.Game;
import client.game.Projector;
import client.game.ViewDispatcher;

public class GameImpl implements Game{
	private AbstractProjector projector = null;
	private ViewDispatcher viewDispatcher = null;
	private ActionDispatcher actionDispatcher = null;
	private ActionDispatchThread actionDispatchThread = null;
	private JFrame frame;
	
	public GameImpl() {
		frame = new JFrame("Bullet Shooting Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	@Override
	public Game addViewDispatcher(ViewDispatcher viewDispatcher) {
		this.viewDispatcher = viewDispatcher;
		return this;
	}

	@Override
	public Game addActionDispatcher(ActionDispatcher actionDispatcher) {
		this.actionDispatcher = actionDispatcher;
		return this;
	}

	@Override
	public Game addProjector(AbstractProjector projector) {
		this.projector = projector;
		frame.add(projector);
		return this;
	}
	@Override
	public void gameStart() {
		if(checkDispatchers()) {
			viewDispatcher.startThread();
			actionDispatcher.startThread();
		}
	}
	@Override
	public void gameExit() {
		// TODO Auto-generated method stub
	}
	private boolean checkDispatchers() {
		if(viewDispatcher == null || actionDispatcher == null)
			return false;
		return true;
	}
}
