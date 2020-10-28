package client.game.impl;

import client.game.AbstractProjector;
import client.game.ActionDispatcher;
import client.game.ActionQueue;
import client.game.ViewDispatcher;
import client.game.ViewQueue;

abstract public class ConfigureContext {
	public static final ViewDispatcher getViewDispatcher() {
		return new ViewDispatchThread();
	}
	public static final ActionDispatcher getActionDispatcher() {
		return new ActionDispatchThread();
	}
	public static final AbstractProjector getProjector(ViewQueue viewQueue, ActionQueue actionQueue) {
		return new ProjectorImpl(viewQueue, actionQueue);
	}
}
