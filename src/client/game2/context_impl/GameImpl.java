package client.game2.context_impl;

import client.game2.ActionDispatcher;
import client.game2.Game;
import client.game2.ViewDispatcher;

class GameImpl implements Game{
	private ViewDispatcher viewDispatcher;
	private ActionDispatcher actionDispatcher;
	
	@Override
	public void setViewDispatcher(ViewDispatcher viewDispatcher) {
		this.viewDispatcher = viewDispatcher;
	}

	@Override
	public void setActionDispatcher(ActionDispatcher actionDispatcher) {
		this.actionDispatcher = actionDispatcher;
	}

	@Override
	public void startGame() {
		viewDispatcher.startThread();
		actionDispatcher.startThread();
	}
	
}
