package client.game;

import java.awt.event.KeyListener;

import client.game.view.View;

public interface Projector extends Runnable, KeyListener {
	
	public void show(View view);
}
