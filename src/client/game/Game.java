package client.game;

public interface Game {
	public Game addViewDispatcher(ViewDispatcher viewDispatcher);
	public Game addActionDispatcher(ActionDispatcher actionDispatcher);
	public Game addProjector(Projector projector);
}
