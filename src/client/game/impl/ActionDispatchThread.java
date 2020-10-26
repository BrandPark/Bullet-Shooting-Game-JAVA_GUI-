package client.game.impl;

import client.game.ActionDispatcher;
import client.game.action_service.DispatchedQueue;
import client.game.action_service.Model;

class ActionDispatchThread extends Thread implements ActionDispatcher {
	private DispatchedQueue actionQueue = null;
	
	@Override
	public void run() {
		while(true) {
			waitToQueue();
			Model model = actionQueue.poll();
			model.execute();	//model이 여러개가 queue에 있다면 여러개의 model이 서로 충돌되지 않게 처리해야함
		}
	}
	@Override
	public void startThread() {
		this.start();
	}
	
	private void waitToQueue() {
		try {
			if(actionQueue.isEmpty())
				synchronized(actionQueue) {
					actionQueue.wait();
				}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public DispatchedQueue getQueue() {
		return actionQueue;
	}
	
}
