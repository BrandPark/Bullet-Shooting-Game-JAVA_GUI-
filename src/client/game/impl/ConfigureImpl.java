package client.game.impl;

import client.game.AbstractProjector;
import client.game.ActionDispatcher;
import client.game.Configure;
import client.game.ViewDispatcher;

class ConfigureImpl implements Configure{
	private ViewDispatcher viewDispatcher;
	private ActionDispatcher actionDispatcher;
	private AbstractProjector projector;
	
	public ConfigureImpl() {
		viewDispatcher = ConfigureContext.getViewDispatcher();
		actionDispatcher = ConfigureContext.getActionDispatcher();
		projector = ConfigureContext.getProjector(viewDispatcher.getQueue(), actionDispatcher.getQueue());
	}

	@Override
	public ViewDispatcher getViewDispatcher() {
		return viewDispatcher;
	}

	@Override
	public ActionDispatcher getActionDispatcher() {
		return actionDispatcher;
	}

	@Override
	public AbstractProjector getProjector() {
		return projector;
	}
	
	
}
