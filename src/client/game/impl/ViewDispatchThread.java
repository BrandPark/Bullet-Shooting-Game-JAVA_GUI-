package client.game.impl;

import client.game.Projector;
import client.game.ViewDispatcher;
import client.game.ViewQueue;

class ViewDispatchThread extends Thread implements ViewDispatcher {
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
	public ViewQueue getQueue() {
		// TODO Auto-generated method stub
		return null;
	}

}
