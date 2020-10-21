package client.dispatch_queue_service.impl;

import client.dispatch_queue_service.DispatchedQueue;
import client.dispatch_queue_service.Dispatcher;

class DispatchThread extends Thread implements Dispatcher{
	private DispatchedQueue dispatchedQueue = new DispatchedQueueImpl();
	
	@Override
	public void startThread() {
		this.start();
	}
}
