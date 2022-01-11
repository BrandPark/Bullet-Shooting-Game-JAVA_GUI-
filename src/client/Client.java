package client;

import client.game.impl.Game;

public class Client {

	public static void main(String[] args) {
		Game game = new Game();
		game.startGame();
	}
}
