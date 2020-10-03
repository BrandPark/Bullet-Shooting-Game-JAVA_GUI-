package interfaces.config;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

import interfaces.screen.Screen;

public interface Viewer extends Runnable, KeyListener {
	
	public void show(Screen screen);
	public void addTo(JFrame frame);
}
