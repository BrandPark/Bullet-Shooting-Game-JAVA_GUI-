package screen_1_main.handler;

import java.awt.event.KeyEvent;
import java.util.List;

import interfaces.element.Button;
import interfaces.screen.KeyHandler;

public class FocusHandlerImpl implements KeyHandler{
	private List<Button> buttons;
	private int index;
	
	public FocusHandlerImpl(List<Button> buttons) {
		this.buttons = buttons;
		this.index = 0;
		focusBtn(index);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int c = e.getKeyCode();
		if(c == KeyEvent.VK_UP) {
			unFocusBtn(index);
			if(index==0)
				index=buttons.size();
			index--;
			focusBtn(index);
		}
		else if(c == KeyEvent.VK_DOWN) {
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

	@Override
	public void keyReleased(KeyEvent e) {
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
