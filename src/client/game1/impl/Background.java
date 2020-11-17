package client.game1.impl;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import client.game1.Display;

public class Background implements Display, Runnable{

	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		g2d.setBackground(Color.DARK_GRAY);
		
		
		return false;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	
}
