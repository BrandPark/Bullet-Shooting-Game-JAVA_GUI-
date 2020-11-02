package game2.context_impl.view._main;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import game2.Button;
import game2.Display;
import game2.View;

class MainView implements View{
	private List<Button> buttons = new ArrayList<>();
	private List<Display> displays = new ArrayList<>();
	
	public MainView() {
		initButtons();
		initDisplays();
	}
	@Override
	public void paint(Graphics2D g2d, ImageObserver imageObserver) {
		System.out.println("MainView_paint()");
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
	public void leftKey() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rightKey() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void upKey() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void downKey() {
		// TODO Auto-generated method stub
		
	}
	private void initButtons() {
		buttons.add(new GameStartBtn());
		buttons.add(new OptionBtn());
	}
	private void initDisplays() {
		displays.add(new TitleDisplay());
	}
	
	
}
