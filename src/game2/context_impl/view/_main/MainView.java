package game2.context_impl.view._main;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;

import game2.View;

class MainView implements View{

	@Override
	public void paint(Graphics2D g2d, ImageObserver imageObserver) {
		System.out.println("MainView_paint()");
	}

	@Override
	public void stopView() {
		System.out.println("MainView_StopView()");
	}
	
	
}
