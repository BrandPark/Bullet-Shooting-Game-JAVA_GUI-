package client.game2.context_impl.view._ingame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import client.game2.Button;
import client.game2.Display;
import client.game2.Model;
import client.game2.Unit;
import client.game2.View;

public class InGameView implements View{
	private final List<Button> buttons = new ArrayList<>();
	private final List<Display> displays = new ArrayList<>();
	private final Model model;
	private final Unit unit;
	
	public InGameView(Model model, Unit unit) {
		this.model = model;
		this.unit = unit;
	}
	@Override
	public void paint(Graphics2D g2d, ImageObserver imageObserver) {
		unit.paint(g2d, imageObserver);
	}

	@Override
	public void stopView() {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		unit.keyPressed(e);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		unit.keyReleased(e);
	}

}