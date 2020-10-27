package client.game.view;

import javax.swing.JFrame;

import client.game.ActionDispatcher;
import client.game.Projector;
import client.game.ViewDispatcher;

abstract public class ConfigureContext {
	public static final ViewDispatcher getViewDispatcher() {
		return new ViewDispatchThread();
	}
	public static final ActionDispatcher getActionDispatcher() {
		return new ActionDispatchThread();
	}
	public static final Projector getProjector(JFrame frame) {
		return new ProjectorImpl(frame);
	}
	
}
