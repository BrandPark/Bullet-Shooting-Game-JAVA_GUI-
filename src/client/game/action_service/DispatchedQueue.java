package client.game.action_service;

public interface DispatchedQueue {
	public void add(Model model);
	public Model poll();
	public boolean isEmpty();
}
