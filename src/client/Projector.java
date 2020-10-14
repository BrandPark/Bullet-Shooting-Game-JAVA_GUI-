package client;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

public interface Projector extends Runnable, KeyListener {
	
	public void show(View view);
}
