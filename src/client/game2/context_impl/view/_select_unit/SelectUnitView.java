package client.game2.context_impl.view._select_unit;

import java.awt.Graphics2D;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;

import client.game2.Button;
import client.game2.Display;
import client.game2.KeyHandler;
import client.game2.Model;
import client.game2.View;


class SelectUnitView implements View{
	private final List<Button> buttons = new ArrayList<>();
	private final List<Display> displays = new ArrayList<>();
	private final KeyHandler buttonHandler;
	private final Model model;
	
	public SelectUnitView(Model model) {
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
		System.out.println("SelectUnitView_StopView()");
	}
	
	@Override
	public void leftKey() {
		buttonHandler.left();
	}

	@Override
	public void rightKey() {
		buttonHandler.right();
	}

	@Override
	public void upKey() {
		buttonHandler.up();
	}

	@Override
	public void downKey() {
		buttonHandler.down();
	}
	
	@Override
	public void spaceKey() {
		buttonHandler.doAction();
	}

	private void initButtons() {
		buttons.add(new UserBtn1());
		buttons.add(new UserBtn2());
		buttons.add(new UserBtn3());
	}
	private void initDisplays() {
		displays.add(new TitleDisplay());
	}

}
