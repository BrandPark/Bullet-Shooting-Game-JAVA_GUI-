package game2.context_impl;

import game2.Projector;
import game2.ViewDispatcher;

class ViewDispatcherThread extends Thread implements ViewDispatcher{
	private Projector projector;
	
	public ViewDispatcherThread() {
		projector = GameFactory.getProjector();
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

}
