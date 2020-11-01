package game2.context_impl;

import game2.ActionDispatcher;
import game2.Game;
import game2.Projector;
import game2.ViewDispatcher;

abstract public class GameFactory {
	public static final Game getGame() {
		return new GameImpl();
	}
	public static final Projector getProjector() {
		return new ProjectorImpl();
	}
	public static final ViewDispatcher getViewDispatcher() {
		return new ViewDispatcherThread();
	}
	public static final ActionDispatcher getActionDispatcher() {
		return new ActionDispatcherThread();
	}
	
}
