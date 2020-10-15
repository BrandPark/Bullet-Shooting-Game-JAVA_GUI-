package client;

import java.awt.event.KeyListener;

public interface Projector extends Runnable, KeyListener {
	
	public void show(View view);
}
