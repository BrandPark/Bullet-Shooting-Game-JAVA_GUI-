package client.game;

public interface Configure {
	public ViewDispatcher getViewDispatcher();
	public ActionDispatcher getActionDispatcher();
	public AbstractProjector getProjector();
}
