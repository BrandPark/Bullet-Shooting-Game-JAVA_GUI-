package backup.steps.step4_ingame.frame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import backup.steps.step0.StepController;
import backup.steps.step0.StepPanel;
import backup.steps.step4_ingame.movingObj.unit.UserUnit;

public class GamePanel extends StepPanel implements Runnable, KeyListener{
	private UserUnit userUnit;
	private TimeScorePanel tsp;
	private LifePanel lp;
	private StepController stepController = StepController.getInstance();

	public GamePanel() {
		setLayout(null);
		init();
		addKeyListener(this);
		threadStart();
	}
	
	@Override
	protected void init() {
		userUnit = stepController.getUserUnit();
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
	
	private void threadStart() {
		new Thread(this).start();
	}

}
