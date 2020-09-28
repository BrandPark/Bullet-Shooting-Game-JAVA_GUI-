package backup.steps.step0;

import javax.swing.JFrame;

import backup.service.StepService;
import backup.steps.step4_ingame.movingObj.unit.UserUnit;
import common.static_data.StepName;

public final class StepController {
	private JFrame frame;
	private StepService stepService = StepService.getInstance();
	private static StepController INSTANCE = null;
	
    public static final StepController getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new StepController();
		}
		return INSTANCE;
	}
	private StepController() {}
	
	public void saveUser(UserUnit userUnit) {
		stepService.saveUser(userUnit);
	}
	
	public void nextStep() {
		StepPanel nextStep = getStep(nextStepName());
		stepChange(nextStep);
	}
	
	public void gameStart(JFrame frame) {
		this.frame = frame;
		StepPanel firstStep = getStep(nextStepName());
		stepChange(firstStep);
	}
	public UserUnit getUserUnit() {
		return stepService.getUserUnit();
	}
	
	private void stepChange(StepPanel changePanel) {
		frame.getContentPane().removeAll();
		frame.add(changePanel);
		frame.repaint();
		frame.revalidate();
		changePanel.focussing();
	}
	
	private StepPanel getStep(StepName name) {
		return StepFactory.getStep(name);
	}
	private StepName nextStepName() {
		return stepService.getNextStepName();
	}
	

	
}
