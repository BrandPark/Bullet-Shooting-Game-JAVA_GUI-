package client.game;

import client.game.action_service.ViewModel;
import client.game.action_service.impl.ViewModelImpl;

public class ViewDispatchThread extends Thread implements DispatchThread {
	private ViewModel vm = null;
	private Projector projector = null;
	
	public ViewDispatchThread(Projector projector) {
		this.vm = ViewModelImpl.getInstance();
		this.projector = projector;
	}
	@Override
	public void run() {
		while(true) {
			synchronized(vm) {
				try {
					vm.wait();
					projector.show(vm.getView());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void startThread() {
		this.start();
	}

}
