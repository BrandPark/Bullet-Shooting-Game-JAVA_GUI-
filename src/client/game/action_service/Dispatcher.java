package client.game.action_service;

public interface Dispatcher {
	public DispatchedQueue getQueue();
	public void startThread();
}