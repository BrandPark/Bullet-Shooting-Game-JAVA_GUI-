package client.game1;

import client.game1.impl.CommandDispatcher;
import client.game1.impl.Projector;

public class Game{
	public void startGame() {
		Projector projector = new Projector();
		CommandDispatcher commandDispatcher = new CommandDispatcher(projector);
	}
}
