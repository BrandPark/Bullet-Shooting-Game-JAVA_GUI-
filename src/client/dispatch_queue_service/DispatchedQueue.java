package client.dispatch_queue_service;

public interface DispatchedQueue {
	public void add(Model model);
	public Model poll();
}
