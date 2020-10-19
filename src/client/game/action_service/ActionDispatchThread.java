package client.game.action_service;

import client.game.DispatchThread;
import client.game.action_service.impl.ActionQueueImpl;

public class ActionDispatchThread extends Thread implements DispatchThread {
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
