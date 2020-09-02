package service;

import java.awt.Container;

import javax.swing.JFrame;

import common.StepPanel;
import step4_ingame.frame.GamePanel;
import step4_ingame.movingObj.UserUnit;

final public class StepManager {
	private int curPanelIndex;
	private JFrame c;
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
		Container c = curPanel.getParent();
		c.remove(curPanel);
		c.add(panelRepo.getPanel(curPanelIndex));
		c.repaint();
		c.revalidate();
		
	}
	
	public void gameStart(JFrame frame) {
		frame.add(panelRepo.getPanel(0));
	}
	
}
