package client.game2.context_impl;

import client.game2.ActionDispatcher;
import client.game2.Model;

class ActionDispatcherThread extends Thread implements ActionDispatcher{
	
	@Override
	public void run() {
		while(true) {
			
		}
	}
	
	@Override
	public Model getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void startThread() {
		this.start();
	}
}
