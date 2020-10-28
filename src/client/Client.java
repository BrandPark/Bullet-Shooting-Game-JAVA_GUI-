package client;

import client.game.Game;
import client.game.impl.GameFactory;

public class Client {

	public static void main(String[] args) {
		Game game = GameFactory.getGame();
		game.gameStart();
	}

}
