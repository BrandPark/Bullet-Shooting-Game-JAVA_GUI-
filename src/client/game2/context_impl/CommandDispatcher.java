package client.game2.context_impl;

import java.util.LinkedList;
import java.util.Queue;

import client.game2.Dispatcher;
import client.game2.Model;
import client.game2.Projector;
import client.game2.context_impl.view._ingame.InGameViewFactory;

class CommandDispatcher extends Thread implements Dispatcher{
	private Projector projector;
	private Model model;
	
	public CommandDispatcher() {
		model = new ModelImpl();
		projector = GameFactory.getProjector(model);
	}
	
	@Override
	public void run() {
		while(true) {
			synchronized(model) {
				try {
					model.wait();
					String command = model.getCommand();
					execute(command);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void startThread() {
		projector.startProjector();
		this.start();
	}
	
	private void execute(String command) {
		System.out.println(command);
		switch(command) {
		case "GAME_START" : projector.showSelectUnit(); break;
		case "OPTION" : System.out.println("옵션버튼 셀렉트"); break;
		case "SELECT_USER_1" :  projector.showInGame(InGameViewFactory.getUser1());break;
		}
	}
	private class ModelImpl implements Model {
		private Queue<String> commandQueue = new LinkedList<>();

		@Override
		public void addCommand(String command) {
			commandQueue.add(command);
			
			synchronized(this) {
				this.notify();
			}
		}

		@Override
		public String getCommand() {
			return commandQueue.poll();
		}
	}
	
}