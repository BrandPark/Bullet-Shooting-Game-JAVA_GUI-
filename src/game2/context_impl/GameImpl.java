package game2.context_impl;

import game2.ActionDispatcher;
import game2.Game;
import game2.ViewDispatcher;

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
