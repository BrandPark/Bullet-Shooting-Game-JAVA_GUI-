package client.game;

public interface Button extends Element{
	public void focus();
	public void unfocus();
	public void doAction(Model model);
}
