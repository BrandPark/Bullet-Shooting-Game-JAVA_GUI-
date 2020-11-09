package client.game1.context_impl.view._ingame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import client.game1.Button;
import client.game1.Display;
import client.game1.Model;
import client.game1.Unit;
import client.game1.View;

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
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		if(unit.paint(g2d, imageObserver))
			return true;
		return false;
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
