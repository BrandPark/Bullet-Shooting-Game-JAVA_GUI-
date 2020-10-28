package client.game.impl;

import javax.swing.JFrame;

import client.game.AbstractProjector;
import client.game.ActionDispatcher;
import client.game.ViewDispatcher;

abstract public class ConfigureContext {
	public static final ViewDispatcher getViewDispatcher() {
		return new ViewDispatchThread();
	}
	public static final ActionDispatcher getActionDispatcher() {
		return new ActionDispatchThread();
	}
	public static final AbstractProjector getProjector() {
		return new ProjectorImpl();
	}
}
