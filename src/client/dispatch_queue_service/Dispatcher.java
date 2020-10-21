package client.dispatch_queue_service;

public interface Dispatcher {
	public DispatchedQueue getQueue();
	public void startThread();
}