package dispatcher_service.impl;

import client.View;
import client.Screens;
import client.viewImpl_2.SelectUnitView;
import dispatcher_service.Action;
import dispatcher_service.ActiveScreen;

public class NextScreenAction implements Action{
	private ActiveScreen as = ActiveScreenImpl.getInstance();
	private Screens [] screenNames = Screens.values();
	
	@Override
	public void execute() {
		View curScreen = as.getScreen();
		View nextScreen = new SelectUnitView();
		for(int i=0;i<screenNames.length;i++) {
			if(isNextable(curScreen, i)) {
				nextScreen = screenNames[i+1].getView();
				as.save(nextScreen);
				return;
			}
		}
		as.save(nextScreen);
	}
	
	private boolean isNextable(View curScreen, int targetIndex) {
		if(screenNames[targetIndex].getView() == curScreen && targetIndex != finalIndex())
			return true;
		return false;
	}
	private int finalIndex() {
		return screenNames.length-1;
	}
}
