package client.game.action_service.impl;

import client.game.Views;
import client.game.action_service.Action;
import client.game.action_service.ViewModel;
import client.game.view.View;
import client.game.view.viewImpl_2.SelectUnitView;

public class NextViewAction implements Action{
	private ViewModel viewModel = ViewModelImpl.getInstance();
	private Views [] views = Views.values();
	
	@Override
	public void execute() {
		View curView = viewModel.getView();
		View nextView = new SelectUnitView();	//수정할 것
		for(int i=0;i<views.length;i++) {
			if(isNextable(curView, i)) {
				nextView = views[i+1].getView();
				viewModel.save(nextView);
				return;
			}
		}
		viewModel.save(nextView);
	}
	
	private boolean isNextable(View curView, int targetIndex) {
		if(views[targetIndex].getView() == curView && targetIndex != finalIndex())
			return true;
		return false;
	}
	private int finalIndex() {
		return views.length-1;
	}
}
