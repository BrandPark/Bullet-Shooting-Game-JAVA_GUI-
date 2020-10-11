package dispatcher_service.impl;

import client.Screens;
import dispatcher_service.Action;
import dispatcher_service.ActiveScreen;

public class InitScreenAction implements Action{
	private ActiveScreen as = ActiveScreenImpl.getInstance();
	
	@Override
	public void execute() {
		as.save(Screens.MainScreen.getView());
	}
	
}
