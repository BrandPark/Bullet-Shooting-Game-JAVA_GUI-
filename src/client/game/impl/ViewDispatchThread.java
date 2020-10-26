package client.game.impl;

import client.game.Projector;
import client.game.ViewDispatcher;
import client.game.ViewQueue;
import client.game.action_service.DispatchedQueue;

public class ViewDispatchThread extends Thread implements ViewDispatcher {
	private ViewQueue vm = null;
	private Projector projector = null;
	
	public ViewDispatchThread() {
	}
	@Override
	public void run() {
		while(true) {
		}
	}

	@Override
	public void startThread() {
		this.start();
	}
	@Override
	public DispatchedQueue getQueue() {
		// TODO Auto-generated method stub
		return null;
	}

}
