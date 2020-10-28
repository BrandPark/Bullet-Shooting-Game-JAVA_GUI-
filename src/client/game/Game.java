package client.game;

public interface Game {
	public Game addViewDispatcher(ViewDispatcher viewDispatcher);
	public Game addActionDispatcher(ActionDispatcher actionDispatcher);
	public Game addProjector(AbstractProjector projector);
	public void gameStart();
	public void gameExit();
}
