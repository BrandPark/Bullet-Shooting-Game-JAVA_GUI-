package client.game.view;

import client.game.action_service.Action;
import client.game.action_service.ViewQueue;
import client.game.action_service.impl.ViewModelImpl;

class MainViewAction implements Action{
	private ViewQueue as = ViewModelImpl.getInstance();
	
	@Override
	public void execute() {
		as.save(Views.MainView.getView());
	}
	
}
