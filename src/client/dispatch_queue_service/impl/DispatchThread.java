package client.dispatch_queue_service.impl;

import client.dispatch_queue_service.DispatchedQueue;
import client.dispatch_queue_service.Dispatcher;
import client.dispatch_queue_service.Model;

class DispatchThread extends Thread implements Dispatcher{
	private DispatchedQueue dispatchedQueue = new DispatchedQueueImpl();
	
	@Override
	public void run() {
		while(true) {
			if(dispatchedQueue.isEmpty())
				waitToQueue();
			Model model = dispatchedQueue.poll();
			model.execute();	//model이 여러개가 queue에 있다면 여러개의 model이 서로 충돌되지 않게 처리해야함
		}
	}
	@Override
	public void startThread() {
		this.start();
	}
	
	private void waitToQueue() {
		try {
			synchronized(dispatchedQueue) {
				dispatchedQueue.wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public DispatchedQueue getQueue() {
		return dispatchedQueue;
	}
}
