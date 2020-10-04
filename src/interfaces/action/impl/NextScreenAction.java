package interfaces.action.impl;

import interfaces.action.Action;
import interfaces.config.ActiveScreen;
import interfaces.config.impl.ActiveScreenImpl;
import interfaces.screen.Screen;
import interfaces.screen.Screens;
import screen_2_selectunit.view.SelectUnitScreen;

public class NextScreenAction implements Action{
	private ActiveScreen as = ActiveScreenImpl.getInstance();
	private Screens [] screenNames = Screens.values();
	
	@Override
	public void execute() {
		Screen curScreen = as.getScreen();
		Screen nextScreen = new SelectUnitScreen();
		for(int i=0;i<screenNames.length;i++) {
			if(isNextable(curScreen, i)) {
				nextScreen = screenNames[i+1].getScreen();
				as.save(nextScreen);
				return;
			}
		}
		as.save(nextScreen);
	}
	
	private boolean isNextable(Screen curScreen, int targetIndex) {
		if(screenNames[targetIndex].getScreen() == curScreen && targetIndex != finalIndex())
			return true;
		return false;
	}
	private int finalIndex() {
		return screenNames.length-1;
	}
}
