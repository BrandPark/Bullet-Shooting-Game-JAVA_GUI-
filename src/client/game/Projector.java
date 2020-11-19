package client.game;

public interface Projector {
	public void showMain(Model model);

	public void showSelectUnit(Model model);

	public void showInGame(User unit, Model model);
}
