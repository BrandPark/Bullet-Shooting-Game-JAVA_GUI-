package client.game2.context_impl;

import client.game2.Dispatcher;
import client.game2.Game;

public class GameContext {
	
	public Game getGame() {
		Game game = GameFactory.getGame();
		
		Dispatcher dispatcher = GameFactory.getDispatcher();
		game.setDispatcher(dispatcher);
		
		return game;
	}
	
}
