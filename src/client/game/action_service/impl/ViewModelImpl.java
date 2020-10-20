package client.game.action_service.impl;

import client.game.action_service.ViewModel;
import client.game.view.View;

class ViewModelImpl implements ViewModel{
	private View view = null;
	private ViewModelImpl() {}
	
	public static final ViewModel getInstance() {
		return new LazyHolder().INSTANCE;
	}
	@Override
	public void save(View view) {
		this.view = view;
		notifyToDispatcher();
	}

	@Override
	public View getView() {
		return view;
	}
	
	synchronized private void notifyToDispatcher() {
		this.notify();
	}
	
	
	private static class LazyHolder{
		private static final ViewModel INSTANCE = new ViewModelImpl();
	}
	


	
}
