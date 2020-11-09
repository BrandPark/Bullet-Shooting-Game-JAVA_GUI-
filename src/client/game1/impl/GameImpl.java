package client.game1.impl;

import client.game1.Dispatcher;
import client.game1.Game;

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
