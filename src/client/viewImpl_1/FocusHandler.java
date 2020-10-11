package client.viewImpl_1;

import java.awt.event.KeyEvent;
import java.util.List;

import client.Button;
import client.KeyHandler;

public class FocusHandler implements KeyHandler{
	private List<Button> buttons;
	private int index;
	
	public FocusHandler(List<Button> buttons) {
		this.buttons = buttons;
		this.index = 0;
		focusBtn(index);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_UP || c == KeyEvent.VK_LEFT) {
			unFocusBtn(index);
			if(index==0)
				index=buttons.size();
			index--;
			focusBtn(index);
		}
		else if(c == KeyEvent.VK_DOWN || c == KeyEvent.VK_RIGHT) {
			unFocusBtn(index);
			if(index==buttons.size()-1)
				index=-1;
			index++;
			focusBtn(index);
		}
		else if(c == KeyEvent.VK_SPACE) {
			selectBtn(index);
		}
			
	}

	private void focusBtn(int index) {
		buttons.get(index).focus();
	}
	private void unFocusBtn(int index) {
		buttons.get(index).unfocus();
	}
	private void selectBtn(int index) {
		buttons.get(index).doAction();
	}

}
