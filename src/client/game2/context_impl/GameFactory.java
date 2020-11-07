package client.game2.context_impl;

import client.game2.Dispatcher;
import client.game2.Game;
import client.game2.Model;
import client.game2.Projector;

abstract public class GameFactory {
	public static final Game getGame() {
		return new GameImpl();
	}
	public static final Projector getProjector(Model model) {
		return new ProjectorImpl(model);
	}
	public static final Dispatcher getDispatcher() {
		return new CommandDispatcher();
	}
	
}
