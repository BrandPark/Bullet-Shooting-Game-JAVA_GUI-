package client.game.action_service;

public interface ActionQueue {
	public void add(Action action);
	public Action poll();
}
