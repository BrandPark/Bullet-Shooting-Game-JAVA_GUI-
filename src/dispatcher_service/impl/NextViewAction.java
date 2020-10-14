package dispatcher_service.impl;

import client.View;
import client.Views;
import client.viewImpl_2.SelectUnitView;
import dispatcher_service.Action;
import dispatcher_service.ViewModel;

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
