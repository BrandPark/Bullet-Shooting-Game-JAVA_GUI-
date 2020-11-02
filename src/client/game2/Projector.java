package client.game2;

import java.util.Queue;

public interface Projector {
	public void showMain();
	public void showSelectUnit();
	public void showInGame();
	public void startProjector();
	public void setViewQueue(Queue<View> viewQueue);
}
