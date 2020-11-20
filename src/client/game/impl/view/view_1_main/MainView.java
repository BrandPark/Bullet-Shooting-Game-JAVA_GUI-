package client.game.impl.view.view_1_main;

import client.game.Model;
import client.game.impl.view.AbstractButtonView;

class MainView extends AbstractButtonView{
	
	public MainView(Model model) {
		super(model);
	}

	@Override
	public void stopView() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initButtons() {
		addButton(new GameStartBtn());
		addButton(new OptionBtn());
	}

	@Override
	protected void initDisplays() {
		addDisplay(new TitleDisplay());
	}
}
