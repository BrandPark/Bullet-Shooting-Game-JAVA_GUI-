package client.game.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import client.game.Bullet;
import client.game.Command;
import client.game.Enemy;
import client.game.KeyHandler;
import client.game.Model;
import client.game.Projector;
import client.game.User;
import client.game.View;

class InGameView implements View{
	private final Model model;
	private final User user;
	private final KeyHandler userHandler;
	private final PhaseManager phaseManager;
	private final List<Bullet> enemyBullets;
	private List<Bullet> userBullets;
	private Phase phase;
	private final DeadUnitRemover deadUnitRemover;
	
	public InGameView(Model model, User user) {
		this.model = model;
		this.user = user;
		this.phaseManager = new PhaseManager();
		this.userHandler = new UserHandler(user);
		this.phase = phaseManager.nextPhase();
		this.userBullets = user.getBullets();
		this.enemyBullets = phaseManager.getBullets();
		this.deadUnitRemover = new DeadUnitRemover(userBullets, enemyBullets, user);
	}
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		deadUnitRemover.remove(phase);
		if(!user.paint(g2d, imageObserver) 
				|| !enemysPaint(g2d, imageObserver) 
				|| !enemyBulletsPaint(g2d, imageObserver)
				|| !userBulletsPaint(g2d, imageObserver))
			return false;
		
		if(user.isDead())
			model.addCommand(new GameOverCommand());
		return true;
	}

	@Override
	public void stopView() {
		user.off();
		phaseManager.off();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		userHandler.keyPressed(e);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		userHandler.keyReleased(e);
	}
	
	private void nextPhase() {
		phase = phaseManager.nextPhase();
		if(phase == null) {
			model.addCommand(new GameClearCommand());
		}
	}
	private boolean isPhaseClear() {
		if(phase.size() == 0) {
			return true;
		}
		return false;
	}
	private boolean enemysPaint(Graphics2D g2d, ImageObserver imageObserver) {
		for(Enemy enemy : phase) {
			if(!enemy.paint(g2d, imageObserver))
				return false;
		}
		return true;
	}
	
	private boolean enemyBulletsPaint(Graphics2D g2d, ImageObserver imageObserver) {
		if(isPhaseClear()) {
			nextPhase();
			return true;
		}
			
		int size = enemyBullets.size();
		for(int i=0;i<size;i++) {
			Bullet bullet = enemyBullets.get(i);
			if(!bullet.paint(g2d, imageObserver)) 
				return false;
		}
		return true;
	}

	private boolean userBulletsPaint(Graphics2D g2d, ImageObserver imageObserver) {

		int size = userBullets.size();	// 미리 개수를 센다.

		for (int i = 0; i < size; i++) {
			try {
				Bullet bullet = userBullets.get(i);
				if (!bullet.paint(g2d, imageObserver))
					return false;
			} catch (IndexOutOfBoundsException ex) {
				// 마지막 총알을 그릴 때 GC에 의해서 이미 삭제되었다면 이 예외가 발생한다.
				// 무시해도 문제가 없다.
			}
		}

		return true;
	}
	
	private static class GameClearCommand implements Command {
		@Override
		public void execute(Projector projector, Model model) {
			projector.showMain(model);
		}
	}
	private static class GameOverCommand implements Command {
		@Override
		public void execute(Projector projector, Model model) {
			projector.showMain(model);
		}
	}
}
