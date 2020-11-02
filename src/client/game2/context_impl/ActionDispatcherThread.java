package client.game2.context_impl;

import client.game2.ActionDispatcher;

class ActionDispatcherThread extends Thread implements ActionDispatcher{
	
	@Override
	public void run() {
		while(true) {
			
		}
	}
	
	@Override
	public void startThread() {
		this.start();
	}
}
