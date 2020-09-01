package step4_ingame.frame;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import common.StepPanel;
import step0.StepManager;
import step4_ingame.movingObj.UserUnit;
import step4_ingame.staticSrc.ImageUrl;
import step4_ingame.staticSrc.Size;

public class GamePanel extends StepPanel implements Runnable, KeyListener{
	private UserUnit userUnit;
	private TimeScorePanel tsp;
	private LifePanel lp;
	private StepManager sm;

	public GamePanel() {
		setPreferredSize(new Dimension(Size.FRAME_W,Size.FRAME_H));
		setLayout(null);
		sm = StepManager.valueOf();
		init();
		
		addKeyListener(this);

		setFocusable(true);
		requestFocus();
		
	}
	public void init() {
		//userUnit = new UserUnit();
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
	public void start() {
		new Thread(this).start();
	}

	@Override
	public GamePanel getPanel() {
		start();
		return this;
	}
}
