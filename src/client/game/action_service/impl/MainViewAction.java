package client.game.action_service.impl;

import client.game.action_service.Action;
import client.game.action_service.ViewModel;
import client.game.view.Views;

public class MainViewAction implements Action{
	private ViewModel as = ViewModelImpl.getInstance();
	
	@Override
	public void execute() {
		as.save(Views.MainView.getView());
	}
	
}
