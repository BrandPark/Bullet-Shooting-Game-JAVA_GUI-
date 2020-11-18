package client.game1.impl.view.view_1_main;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import client.game1.Button;
import client.game1.Display;
import client.game1.KeyHandler;
import client.game1.Model;
import client.game1.View;

class MainView implements View{
	private final List<Button> buttons = new ArrayList<>();
	private final List<Display> displays = new ArrayList<>();
	private final KeyHandler buttonHandler;
	private final Model model;
	
	public MainView(Model model) {
		this.model = model;
		initButtons();
		initDisplays();
		buttonHandler = new ButtonHandler(buttons,model);
	}
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		for (Display d : displays) {
			if(!d.paint(g2d, imageObserver))
				return false;
		}
		for (Button b : buttons) {
			if(!b.paint(g2d, imageObserver))
				return false;
		}
		return true;
	}
	
	@Override
	public void stopView() {
		System.out.println("MainView_StopView()");
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		buttonHandler.keyPressed(e);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		buttonHandler.keyReleased(e);
	}
	private void initButtons() {
		buttons.add(new GameStartBtn());
		buttons.add(new OptionBtn());
	}
	private void initDisplays() {
		displays.add(new TitleDisplay());
	}
	
	
}
