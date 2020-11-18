package client.game.impl;

import java.util.LinkedList;
import java.util.Queue;

import client.game.Model;
import client.game.impl.view_3_ingame.InGameViewFactory;

public class CommandDispatcher extends Thread {
	private Projector projector;
	private Model model;
	
	public CommandDispatcher(Projector projector) {
		this.model = new ModelImpl();
		this.projector = projector;
		projector.showMain(model);
		this.start();
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

	private void execute(String command) {
		System.out.println(command);
		switch(command) {
		case "GAME_START" : projector.showSelectUnit(model); break;
		case "OPTION" : System.out.println("옵션버튼 셀렉트"); break;
		case "SELECT_USER_1" :  projector.showInGame(InGameViewFactory.getUser1(), model);break;
		case "CLEAR" : projector.showMain(model);break;
		case "GAME_OVER" : projector.showMain(model);break;
		}
	}
	
	private static class ModelImpl implements Model {
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
