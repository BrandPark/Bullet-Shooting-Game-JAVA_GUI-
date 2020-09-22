package viewer;

import java.awt.event.KeyListener;

import screen.ScreenName;

public interface Viewer extends Runnable, KeyListener {
	public void show(ScreenName name);
}
