package service;

import common.static_data.StepName;
import steps.step0.StepPanel;
import steps.step4_ingame.movingObj.UserUnit;

final public class StepService {
	private final StepRepo stepRepo;
	private final UserRepo userRepo;
	private final EnemyRepo enemyRepo;
	private int curStepIndex;
		
	private static StepService INSTANCE = null;
	
    public static final StepService getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new StepService();
		}
		return INSTANCE;
	}
	private StepService() {
		stepRepo = StepRepo.getRepo();
		userRepo = UserRepo.getRepo();
		enemyRepo = EnemyRepo.getRepo();
		curStepIndex = 0;
	}
	
	public void saveUser(UserUnit userUnit) {
		userRepo.save(userUnit);
	}
	public StepName getNextStepName() {
		return stepRepo.getStepNameByIndex(curStepIndex++);
	}
	
	public void focusing(StepPanel stepPanel) {
		stepPanel.requestFocus();
		stepPanel.setFocusable(true);
	}
	public void startStep(StepPanel stepPanel) {
		stepPanel.start();
	}
	
	
	

	
}
