package service;

import java.awt.Container;
import java.awt.event.FocusAdapter;

import javax.swing.JFrame;

import common.StepPanel;
import step4_ingame.movingObj.UserUnit;

final public class StepManager {
	private int curPanelIndex;
	private final PanelRepo panelRepo;
	private final UserRepo userRepo;
	private final EnemyRepo enemyRepo;
		
	private static StepManager INSTANCE = null;
	
	synchronized public static final StepManager getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new StepManager();
			System.out.println("StepManager.getInstance()");
			
		}
		return INSTANCE;
	}

	private StepManager() {
		this.curPanelIndex = 0;
		panelRepo = PanelRepo.getRepo();
		userRepo = UserRepo.getRepo();
		enemyRepo = EnemyRepo.getRepo();
	}
	
	public void saveUser(UserUnit userUnit) {
		userRepo.save(userUnit);
	}
	
	public void nextStep() {
		StepPanel curPanel = panelRepo.getPanel(curPanelIndex++);
		StepPanel nextPanel = panelRepo.getPanel(curPanelIndex);
		
		Container c = curPanel.getParent();
		c.remove(curPanel);
		c.add(nextPanel);
		c.repaint();
		c.revalidate();
		
		nextPanel.focusing();
	}
	
	
	public void gameStart(JFrame frame) {
		frame.add(panelRepo.getPanel(0));
	}
	

	
}
