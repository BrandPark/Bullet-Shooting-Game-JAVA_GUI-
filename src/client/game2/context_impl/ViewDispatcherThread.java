package client.game2.context_impl;

import client.game2.Model;
import client.game2.Projector;
import client.game2.View;
import client.game2.ViewDispatcher;

class ViewDispatcherThread extends Thread implements ViewDispatcher{
	private Projector projector;
	private Model<View> viewModel;
	
	public ViewDispatcherThread() {
		viewModel = new ViewModel();
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized(viewModel) {
				try {
					viewModel.wait();
					View view = viewModel.poll();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	@Override
	public Model getModel() {
		return viewModel;
	}

	@Override
	public void setProjector(Projector projector) {
		this.projector = projector;
	}

	@Override
	public void startThread() {
		projector.startProjector();
		this.start();
	}

}
