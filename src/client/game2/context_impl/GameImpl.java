package client.game2.context_impl;

import client.game2.Dispatcher;
import client.game2.Game;

class GameImpl implements Game{
	private Dispatcher dispatcher;
	
	@Override
	public void setDispatcher(Dispatcher dispatcher) {
		this.dispatcher = dispatcher;
	}

	@Override
	public void startGame() {
		dispatcher.startThread();
	}
	
}
