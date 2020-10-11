package dispatcher_service;

import client.View;

public interface ActiveScreen {
	public void save(View screen);
	public View getScreen();
}
