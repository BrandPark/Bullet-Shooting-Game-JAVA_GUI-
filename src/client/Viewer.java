package client;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

public interface Viewer extends Runnable, KeyListener {
	
	public void show(Screen screen);
	public void addTo(JFrame frame);
}
