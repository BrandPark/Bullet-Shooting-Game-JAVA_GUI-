package client.game;

import client.dispatch_queue_service.Dispatcher;
import client.game.action_service.ActionQueue;
import client.game.action_service.ViewQueue;

public interface Configure {
	public Dispatcher getViewDispatcher();
	public Dispatcher getActionDispatcher();
	public ViewQueue getViewModel();
	public ActionQueue getActionQueue();
}
