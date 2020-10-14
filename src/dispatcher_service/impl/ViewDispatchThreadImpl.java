package dispatcher_service.impl;

import client.Projector;
import dispatcher_service.ViewDispatchThread;
import dispatcher_service.ViewModel;

public class ViewDispatchThreadImpl extends Thread implements ViewDispatchThread {
	private ViewModel vm = null;
	private Projector projector = null;
	
	public ViewDispatchThreadImpl(Projector projector) {
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
