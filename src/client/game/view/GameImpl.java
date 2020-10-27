package client.game.view;


import javax.swing.JFrame;

import client.game.ActionDispatcher;
import client.game.Game;
import client.game.Projector;
import client.game.ViewDispatcher;

public class GameImpl implements Game{
	private Projector projector = null;
	private ViewDispatcher viewDispatcher = null;
	private ActionDispatcher actionDispatcher = null;
	private ActionDispatchThread actionDispatchThread = null;
	
	public GameImpl() {
		JFrame frame = new JFrame("Bullet Shooting Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.pack();
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	@Override
	public Game addViewDispatcher(ViewDispatcher viewDispatcher) {
		this.viewDispatcher = viewDispatcher;
		return this;
	}

	@Override
	public Game addActionDispatcher(ActionDispatcher actionDispatcher) {
		this.actionDispatcher = actionDispatcher;
		return this;
	}

	@Override
	public Game addProjector(Projector projector) {
		this.projector = projector;
		return this;
	}
}
