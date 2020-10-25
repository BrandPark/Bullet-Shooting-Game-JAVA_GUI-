package client.game;

import client.game.action_service.DispatchedQueue;

public interface ViewQueue extends DispatchedQueue{
	public void save(View view);
	public View getView();
}
