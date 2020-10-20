package client.game.view;

import client.game.ViewElement;
import client.game.action_service.Action;
import client.game.action_service.ActionQueue;
import client.game.action_service.impl.ActionQueueImpl;

abstract public class AbstractViewElement implements ViewElement{
	protected ActionQueue actionQueue = ActionQueueImpl.getInstance();
	
	protected void addAction(Action action) {
		actionQueue.add(action);
	}
}
