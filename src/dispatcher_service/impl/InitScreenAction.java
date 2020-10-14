package dispatcher_service.impl;

import client.Views;
import dispatcher_service.Action;
import dispatcher_service.ViewModel;

public class InitScreenAction implements Action{
	private ViewModel as = ViewModelImpl.getInstance();
	
	@Override
	public void execute() {
		as.save(Views.MainView.getView());
	}
	
}
