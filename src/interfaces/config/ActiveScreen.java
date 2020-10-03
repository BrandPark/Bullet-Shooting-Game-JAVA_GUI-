package interfaces.config;

import interfaces.screen.Screen;

public interface ActiveScreen {
	public void save(Screen screen);
	public Screen getScreen();
}
