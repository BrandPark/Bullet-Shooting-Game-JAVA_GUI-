package client.game.action_service;

import client.game.View;

public interface ViewQueue extends DispatchedQueue{
	public void save(View view);
	public View getView();
}
