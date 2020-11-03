package client.game2.context_impl;

import java.util.LinkedList;
import java.util.Queue;

import client.game2.Model;
import client.game2.View;

class ViewModel implements Model<View> {
	private Queue<View> viewQueue = new LinkedList<>();
	
	@Override
	synchronized public void add(View model) {
		viewQueue.add(model);
		this.notify();
	}

	@Override
	public View poll() {
		return viewQueue.poll();
	}

}
