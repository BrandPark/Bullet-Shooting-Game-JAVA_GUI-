package client;

import client.game.Game;
import client.game.impl.ConfigureFactory;

public class Client {

	public static void main(String[] args) {
		Game game = ConfigureFactory.getConfigure().getGame();
		game.gameStart();
	}

}
