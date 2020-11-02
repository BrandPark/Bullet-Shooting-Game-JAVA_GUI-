package client.game2.context_impl;

import client.game2.ActionDispatcher;
import client.game2.Game;
import client.game2.ViewDispatcher;

public class GameContext {
	
	public Game getGame() {
		Game game = GameFactory.getGame();
		ViewDispatcher viewDispatcher = GameFactory.getViewDispatcher();
		ActionDispatcher actionDispatcher = GameFactory.getActionDispatcher();
		
		game.setViewDispatcher(viewDispatcher);
		game.setActionDispatcher(actionDispatcher);
		
		return game;
	}
	
}
