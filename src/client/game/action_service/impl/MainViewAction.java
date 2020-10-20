package client.game.action_service.impl;

import client.game.Views;
import client.game.action_service.Action;
import client.game.action_service.ViewModel;

class MainViewAction implements Action{
	private ViewModel as = ViewModelImpl.getInstance();
	
	@Override
	public void execute() {
		as.save(Views.MainView.getView());
	}
	
}
