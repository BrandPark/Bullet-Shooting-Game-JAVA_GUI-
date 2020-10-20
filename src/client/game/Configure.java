package client.game;

import client.game.action_service.ActionQueue;

public interface Configure {
	public DispatchThread getViewDispatcher();
	public DispatchThread getActionDispatcher();
	public ViewModel getViewModel();
	public ActionQueue getActionQueue();
}
