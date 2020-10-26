package client.game.action_service;

public interface Dispatcher<T>{
	public T getQueue();
	public void startThread();
}