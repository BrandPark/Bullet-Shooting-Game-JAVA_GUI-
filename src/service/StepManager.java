package service;

import java.awt.Container;
import java.awt.event.FocusAdapter;

import javax.swing.JFrame;

import common.StepPanel;
import step4_ingame.movingObj.UserUnit;

final public class StepManager {
	private int curPanelIndex;
	private PanelRepo panelRepo = PanelRepo.getRepo();
	private UserRepo userRepo = UserRepo.getRepo();
	private EnemyRepo enemyRepo = EnemyRepo.getRepo();
		
	private static StepManager INSTANCE = null;
	
	public static final StepManager getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new StepManager();
		}
		return INSTANCE;
	}

	private StepManager() {
		this.curPanelIndex = 0;
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
