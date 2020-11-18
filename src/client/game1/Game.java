package client.game1;

import client.game1.impl.CommandDispatcher;
import client.game1.impl.ProjectorImpl;

public class Game{
	public void startGame() {
		Projector projector = new ProjectorImpl();
		CommandDispatcher commandDispatcher = new CommandDispatcher(projector);
	}
}
