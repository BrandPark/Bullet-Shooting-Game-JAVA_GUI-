package client.game.impl.view.view_2_select_unit;

import client.game.Model;
import client.game.impl.view.AbstractButtonView;

class SelectUnitView extends AbstractButtonView{
	
	public SelectUnitView(Model model) {
		super(model);
	}
	@Override
	public void stopView() {
		
	}
	@Override
	protected void initButtons() {
		addButton(new UserBtn1());
		addButton(new UserBtn2());
		addButton(new UserBtn3());
	}
	@Override
	protected void initDisplays() {
		addDisplay(new TitleDisplay());
	}
}
