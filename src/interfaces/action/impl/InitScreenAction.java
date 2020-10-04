package interfaces.action.impl;

import interfaces.action.Action;
import interfaces.config.ActiveScreen;
import interfaces.config.impl.ActiveScreenImpl;
import interfaces.screen.Screens;

public class InitScreenAction implements Action{
	private ActiveScreen as = ActiveScreenImpl.getInstance();
	
	@Override
	public void execute() {
		as.save(Screens.MainScreen.getScreen());
	}
	
}
