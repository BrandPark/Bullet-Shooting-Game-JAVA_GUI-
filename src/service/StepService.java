package service;

import java.awt.Container;
import java.awt.event.FocusAdapter;
import java.util.List;

import javax.swing.JFrame;

import steps.step0.StepPanel;
import steps.step4_ingame.movingObj.UserUnit;

final public class StepService {
	private final PanelRepo panelRepo;
	private final UserRepo userRepo;
	private final EnemyRepo enemyRepo;
		
	private static StepService INSTANCE = null;
	
    public static final StepService getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new StepService();
		}
		return INSTANCE;
	}
	private StepService() {
		panelRepo = PanelRepo.getRepo();
		userRepo = UserRepo.getRepo();
		enemyRepo = EnemyRepo.getRepo();
	}
	
	public void saveUser(UserUnit userUnit) {
		userRepo.save(userUnit);
	}
	
	public void initPanel(List<StepPanel> list) {
		panelRepo.initPanel(list);
	}
	
	public StepPanel getStep(int stepIndex) {
		return panelRepo.getPanel(stepIndex);
	}
	
	public void focusing(StepPanel stepPanel) {
		stepPanel.requestFocus();
		stepPanel.setFocusable(true);
	}
	public void startStep(StepPanel stepPanel) {
		stepPanel.start();
	}
	
	
	

	
}
