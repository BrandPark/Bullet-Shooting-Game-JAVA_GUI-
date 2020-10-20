package client.game.action_service.impl;

import client.game.ViewModel;
import client.game.Views;
import client.game.action_service.Action;

class MainViewAction implements Action{
	private ViewModel as = ViewModelImpl.getInstance();
	
	@Override
	public void execute() {
		as.save(Views.MainView.getView());
	}
	
}
