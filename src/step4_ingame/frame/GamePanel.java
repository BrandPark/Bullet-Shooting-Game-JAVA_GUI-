package step4_ingame.frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import common.StepPanel;
import step4_ingame.movingObj.UserUnit;

public class GamePanel extends StepPanel implements Runnable, KeyListener{
	private UserUnit userUnit;
	private TimeScorePanel tsp;
	private LifePanel lp;

	public GamePanel() {
		setLayout(null);
		init();
	}
	public void focusing() {
		addKeyListener(this);
		requestFocus();
		setFocusable(true);
		threadStart();
	}
	private void init() {
		userUnit = new UserUnit("resource/img_unit/user_unit.png");
		add(userUnit);
		
		tsp = new TimeScorePanel();
		add(tsp);
		
		lp = new LifePanel();
		add(lp);
	}
	
	@Override
	public void run() {
		while(true) {
			
			userUnit.move();
			repaint();
			revalidate();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		userUnit.keyReleased(e);
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		userUnit.keyPressed(e);
	}
	public void threadStart() {
		new Thread(this).start();
	}

}
