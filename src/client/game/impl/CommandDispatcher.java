package client.game.impl;

import java.util.LinkedList;
import java.util.Queue;

import client.game.Command;
import client.game.Model;

class CommandDispatcher extends Thread {
	private ProjectorImpl projector;
	private Model model;
	
	public CommandDispatcher(ProjectorImpl projector) {
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
					Command command = model.getCommand();
					command.execute(projector, model);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static class ModelImpl implements Model {
		private Queue<Command> commandQueue = new LinkedList<>();

		@Override
		public void addCommand(Command command) {
			commandQueue.add(command);
			
			synchronized(this) {
				this.notify();
			}
		}

		@Override
		public Command getCommand() {
			return commandQueue.poll();
		}
	}
	
}
