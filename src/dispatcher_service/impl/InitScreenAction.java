package dispatcher_service.impl;

import client.Screens;
import dispatcher_service.Action;
import dispatcher_service.ViewModel;

public class InitScreenAction implements Action{
	private ViewModel as = ViewModelImpl.getInstance();
	
	@Override
	public void execute() {
		as.save(Screens.MainScreen.getView());
	}
	
}
