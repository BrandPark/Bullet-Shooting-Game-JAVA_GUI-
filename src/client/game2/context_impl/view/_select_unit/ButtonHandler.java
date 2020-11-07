package client.game2.context_impl.view._select_unit;

import java.util.List;

import client.game2.Button;
import client.game2.KeyHandler;
import client.game2.Model;


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
	@Override
	public void doAction() {
		String command = buttons.get(index).getAction();
		model.addCommand(command);
	}
	
	private void focusBtn(int index) {
		buttons.get(index).focus();
	}
	private void unFocusBtn(int index) {
		buttons.get(index).unfocus();
	}
}
