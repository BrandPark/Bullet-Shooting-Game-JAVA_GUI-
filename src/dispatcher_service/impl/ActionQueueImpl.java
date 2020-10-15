package dispatcher_service.impl;

import java.util.LinkedList;
import java.util.Queue;

import dispatcher_service.Action;
import dispatcher_service.ActionQueue;

public class ActionQueueImpl implements ActionQueue {
	private Queue<Action> queue = new LinkedList<>();
	private static ActionQueueImpl INSTANCE = null;
	
	private ActionQueueImpl() {}
	
	public static final ActionQueueImpl getInstance() {
		if(INSTANCE == null) 
			INSTANCE = new ActionQueueImpl();
		return INSTANCE;
	}
	
	@Override
	public void add(Action action) {
		queue.add(action);
		synchronized(queue) {
			this.notify();
		}
	}

	@Override
	public Action poll() {
		return queue.poll();
	}
	
	

}
