package client.game.impl.view_2_select_unit;

import java.awt.event.KeyEvent;
import java.util.List;

import client.game.Button;
import client.game.KeyHandler;
import client.game.Model;


class ButtonHandler implements KeyHandler{
	private List<Button> buttons;
	private int index;
	private Model model;
	
	public ButtonHandler(List<Button> buttons,Model model) {
		this.buttons = buttons;
		this.model = model;
		this.index = 0;
		focusBtn(index);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch(keyCode) {
		case KeyEvent.VK_UP: up();break;
		case KeyEvent.VK_DOWN: down();break;
		case KeyEvent.VK_LEFT: left();break;
		case KeyEvent.VK_RIGHT: right();break;
		case KeyEvent.VK_SPACE: 
		case KeyEvent.VK_Z: activateBtn();break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	private void up() {
		unFocusBtn(index);
		if(index==0)
			index=buttons.size();
		index--;
		focusBtn(index);
	}
	private void down() {
		unFocusBtn(index);
		if(index==buttons.size()-1)
			index=-1;
		index++;
		focusBtn(index);
	}
	private void left() {
		unFocusBtn(index);
		if(index==0)
			index=buttons.size();
		index--;
		focusBtn(index);
	}
	private void right() {
		unFocusBtn(index);
		if(index==buttons.size()-1)
			index=-1;
		index++;
		focusBtn(index);
	}
	
	private void activateBtn() {
		buttons.get(index).doAction(model);
	}
	
	private void focusBtn(int index) {
		buttons.get(index).focus();
	}
	private void unFocusBtn(int index) {
		buttons.get(index).unfocus();
	}
}
