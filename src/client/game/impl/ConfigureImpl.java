package client.game.impl;

import javax.swing.JFrame;

import client.game.ActionDispatcher;
import client.game.Configure;
import client.game.Game;
import client.game.Projector;
import client.game.ViewDispatcher;

public class ConfigureImpl implements Configure{
	private Game game;
	private ViewDispatcher viewDispatcher;
	private ActionDispatcher actionDispatcher;
	private Projector projector;
	
	public ConfigureImpl(JFrame frame) {
		viewDispatcher = ConfigureContext.getViewDispatcher();
		actionDispatcher = ConfigureContext.getActionDispatcher();
		projector = ConfigureContext.getProjector(frame);
		projector.setQueue(actionDispatcher.getQueue(), viewDispatcher.getQueue());
		game = new GameImpl().addViewDispatcher(viewDispatcher).addActionDispatcher(actionDispatcher).addProjector(projector);
		
	}
	@Override
	public Game getGame() {
		return game;
	}
	
	
}
