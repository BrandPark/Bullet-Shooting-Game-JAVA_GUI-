package client.game1.impl;

import client.game1.Dispatcher;
import client.game1.Game;

public class GameContext {
	
	public Game getGame() {
		Game game = GameFactory.getGame();
		
		Dispatcher dispatcher = GameFactory.getDispatcher();
		game.setDispatcher(dispatcher);
		
		return game;
	}
	
}
