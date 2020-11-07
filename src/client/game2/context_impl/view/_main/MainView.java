package client.game2.context_impl.view._main;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import client.game2.Button;
import client.game2.Display;
import client.game2.KeyHandler;
import client.game2.Model;
import client.game2.View;

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
	public void paint(Graphics2D g2d, ImageObserver imageObserver) {
		for (Display d : displays) {
			d.paint(g2d, imageObserver);
		}
		for (Button b : buttons) {
			b.paint(g2d, imageObserver);
		}
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
