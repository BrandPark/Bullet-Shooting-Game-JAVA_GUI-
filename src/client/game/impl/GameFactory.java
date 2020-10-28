package client.game.impl;

import client.game.Game;

abstract public class GameFactory {
	public static final Game getGame() {
		return new GameImpl(new ConfigureImpl());
	}
}
