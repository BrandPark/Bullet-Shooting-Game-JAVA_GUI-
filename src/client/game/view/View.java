package client.game.view;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;

import client.game.ActionQueue;
import client.game.ViewQueue;

public interface View{
	public void paint(Graphics2D g2d,ImageObserver imageObserver);
	public void keyPressed(KeyEvent e);
	public void addQueue(ActionQueue actionQueue, ViewQueue viewQueue);
}
