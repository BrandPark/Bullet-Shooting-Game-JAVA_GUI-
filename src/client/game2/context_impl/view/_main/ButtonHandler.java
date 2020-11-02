package client.game2.context_impl.view._main;

import java.util.List;

import client.game2.Button;
import client.game2.KeyHandler;


class ButtonHandler implements KeyHandler{
	private List<Button> buttons;
	private int index;
	
	public ButtonHandler(List<Button> buttons) {
		this.buttons = buttons;
		this.index = 0;
		focusBtn(index);
	}
	@Override
	public void up() {
		unFocusBtn(index);
		if(index==0)
			index=buttons.size();
		index--;
		focusBtn(index);
	}
	@Override
	public void down() {
		unFocusBtn(index);
		if(index==buttons.size()-1)
			index=-1;
		index++;
		focusBtn(index);
	}
	@Override
	public void left() {
		unFocusBtn(index);
		if(index==0)
			index=buttons.size();
		index--;
		focusBtn(index);
	}
	@Override
	public void right() {
		unFocusBtn(index);
		if(index==buttons.size()-1)
			index=-1;
		index++;
		focusBtn(index);
	}
	private void focusBtn(int index) {
		if(buttons.isEmpty())
			System.out.println("비어있음");
		else
			buttons.get(index).focus();
	}
	private void unFocusBtn(int index) {
		if(buttons.isEmpty())
			System.out.println("비어있음");
		else 
			buttons.get(index).unfocus();
	}
}
