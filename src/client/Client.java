package client;

import game2.context_impl.GameContext;

public class Client {

	public static void main(String[] args) {
//		Game game = GameFactory.getGame();
//		game.gameStart();
		GameContext gc = new GameContext();
		gc.getGame().startGame();
	}

}
