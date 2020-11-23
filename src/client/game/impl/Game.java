package client.game.impl;

public class Game{
	public void startGame() {
		ProjectorImpl projector = new ProjectorImpl();
		@SuppressWarnings("unused")
		CommandDispatcher commandDispatcher = new CommandDispatcher(projector);
	}
}
