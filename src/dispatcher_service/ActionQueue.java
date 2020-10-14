package dispatcher_service;

public interface ActionQueue {
	public void add(Action action);
	public Action poll();
}
