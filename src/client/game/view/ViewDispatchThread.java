package client.game.view;

import client.game.Projector;
import client.game.ViewDispatcher;
import client.game.ViewQueue;

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
	public ViewQueue getQueue() {
		// TODO Auto-generated method stub
		return null;
	}

}
