package dispatcher_service.impl;

import client.View;
import dispatcher_service.ActiveScreen;

public class ActiveScreenImpl implements ActiveScreen{
	private View screen = null;
	private ActiveScreenImpl() {}
	
	public static final ActiveScreen getInstance() {
		return new LazyHolder().INSTANCE;
	}
	@Override
	public void save(View screen) {
		this.screen = screen;
		notifyToDispatcher();
	}

	@Override
	public View getScreen() {
		return screen;
	}
	
	synchronized private void notifyToDispatcher() {
		this.notify();
	}
	
	
	private static class LazyHolder{
		private static final ActiveScreen INSTANCE = new ActiveScreenImpl();
	}
	


	
}
