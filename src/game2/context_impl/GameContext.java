package game2.context_impl;

import game2.ActionDispatcher;
import game2.Game;
import game2.ViewDispatcher;

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
