package interfaces.viewer;

import java.awt.event.KeyListener;

import interfaces.screen.ScreenName;

public interface Viewer extends Runnable, KeyListener {
	public void show(ScreenName name);
}
