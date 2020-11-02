package client.game2.context_impl;

import java.util.LinkedList;
import java.util.Queue;

import client.game2.Projector;
import client.game2.View;
import client.game2.ViewDispatcher;

class ViewDispatcherThread extends Thread implements ViewDispatcher{
	private Projector projector;
	private Queue<View> viewQueue;
	public ViewDispatcherThread() {
		viewQueue = new LinkedList<>();
		projector = GameFactory.getProjector();
		projector.setViewQueue(viewQueue);
	}
	
	@Override
	public void run() {
		while(true) {
				
		}
	}
	
	@Override
	public void startThread() {
		projector.startProjector();
		this.start();
	}

}
