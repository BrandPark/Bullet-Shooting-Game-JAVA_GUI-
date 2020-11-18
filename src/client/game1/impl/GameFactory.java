package client.game1.impl;

import client.game1.Dispatcher;
import client.game1.Game;
import client.game1.Model;
import client.game1.Projector;

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
