package client;

import client.game1.impl.GameContext;

public class Client {

	public static void main(String[] args) {
		GameContext gc = new GameContext();
		gc.getGame().startGame();
	}

}
