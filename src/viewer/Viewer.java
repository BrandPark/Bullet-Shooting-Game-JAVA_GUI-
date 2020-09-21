package viewer;

import java.awt.event.KeyListener;

import Screen.ScreenName;

public interface Viewer extends Runnable, KeyListener {
	public void show(ScreenName name);
}
