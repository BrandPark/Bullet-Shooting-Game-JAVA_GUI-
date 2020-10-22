package client.game.action_service.impl;

import java.util.LinkedList;
import java.util.Queue;

import client.game.action_service.DispatchedQueue;
import client.game.action_service.Model;


class ActionQueue implements DispatchedQueue {
	//synchronized 체크 
		private final Queue<Model> queue = new LinkedList<>();
		
		@Override
		synchronized public void add(Model model) {
			queue.add(model);
			this.notify();
		}

		@Override
		synchronized public Model poll() {
			return queue.poll();
		}


		@Override
		public boolean isEmpty() {
			if(queue.isEmpty())
				return true;
			return false;
		}
}
