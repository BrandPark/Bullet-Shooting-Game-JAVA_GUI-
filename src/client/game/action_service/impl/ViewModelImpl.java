package client.game.action_service.impl;

import client.game.View;
import client.game.action_service.ViewQueue;

class ViewModelImpl implements ViewQueue{
	private View view = null;
	private ViewModelImpl() {}
	
	public static final ViewQueue getInstance() {
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
		private static final ViewQueue INSTANCE = new ViewModelImpl();
	}
	


	
}
