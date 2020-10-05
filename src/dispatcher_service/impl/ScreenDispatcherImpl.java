package dispatcher_service.impl;

import java.util.List;

import javax.swing.JFrame;

import client.Viewer;
import dispatcher_service.ActiveScreen;
import dispatcher_service.ScreenDispatcher;

public class ScreenDispatcherImpl implements ScreenDispatcher{
	private ActiveScreen as = null;
	private Viewer viewer = null;
	private JFrame frame = null;
	
	public ScreenDispatcherImpl(JFrame frame) {
		this.frame = frame;
		createModule();
		addViewerToFrame();
		new Thread(this).start();
	}

	@Override
	public void run() {
		while(true) {
			waitForAction();
			viewer.show(as.getScreen());
		}
	}
	private void waitForAction(){
		try {
			synchronized(as) {as.wait();}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	private void createModule() {
		as = ActiveScreenImpl.getInstance();
		viewer = new ViewerImpl();
	}
	private void addViewerToFrame() {
		viewer.addTo(frame);
	}
}
