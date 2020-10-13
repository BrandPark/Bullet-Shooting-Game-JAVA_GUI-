package dispatcher_service.impl;

import client.Projector;
import dispatcher_service.ViewDispatcherThread;
import dispatcher_service.ViewModel;

public class ViewDispatcherThreadImpl extends Thread implements ViewDispatcherThread {
	private ViewModel vm = null;
	private Projector projector = null;
	
	public ViewDispatcherThreadImpl(Projector projector) {
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
	public void start() {
		// TODO Auto-generated method stub
		
	}

}
