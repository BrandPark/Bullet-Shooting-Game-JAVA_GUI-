package client.game.action_service.impl;

import client.dispatch_queue_service.Dispatcher;
import client.game.action_service.Action;
import client.game.action_service.ActionQueue;

class ActionDispatchThread extends Thread implements Dispatcher {
	private ActionQueue actionQueue = ActionQueueImpl.getInstance();
	
	public ActionDispatchThread() {
		
	}
	@Override
	public void run() {
		while(true) {
			synchronized(actionQueue) {
				try {
					actionQueue.wait();
					Action action = actionQueue.poll();
					action.execute();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	@Override
	public void startThread() {
		this.start();
	}
	
}
