package client;

import dispatcher_service.Action;
import dispatcher_service.ActionQueue;
import dispatcher_service.impl.ActionQueueImpl;

abstract public class AbstractViewElement implements ViewElement{
	protected ActionQueue actionQueue = ActionQueueImpl.getInstance();
	
	protected void addAction(Action action) {
		actionQueue.add(action);
	}
}
