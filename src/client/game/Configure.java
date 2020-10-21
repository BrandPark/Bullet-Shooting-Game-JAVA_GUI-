package client.game;

import client.dispatch_queue_service.Dispatcher;
import client.game.action_service.ActionQueue;

public interface Configure {
	public Dispatcher getViewDispatcher();
	public Dispatcher getActionDispatcher();
	public ViewModel getViewModel();
	public ActionQueue getActionQueue();
}
