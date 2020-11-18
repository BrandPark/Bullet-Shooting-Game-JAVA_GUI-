package client.game;

import client.game.impl.CommandDispatcher;
import client.game.impl.Projector;

public class Game{
	public void startGame() {
		Projector projector = new Projector();
		CommandDispatcher commandDispatcher = new CommandDispatcher(projector);
	}
}
