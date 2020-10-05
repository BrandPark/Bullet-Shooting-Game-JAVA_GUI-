package dispatcher_service;

import client.Screen;

public interface ActiveScreen {
	public void save(Screen screen);
	public Screen getScreen();
}
