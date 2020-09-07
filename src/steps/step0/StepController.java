package steps.step0;

import java.util.List;

import javax.swing.JFrame;

import common.static_data.StepName;
import service.StepService;
import steps.step4_ingame.movingObj.UserUnit;

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
		StepName nextStepName = stepService.getNextStepName();
		StepPanel nextStep = StepFactory.getStep(nextStepName);
		stepChange(nextStep);
		focusing(nextStep);
		startStep(nextStep);
	}
	public void gameStart(JFrame frame) {
		this.frame = frame;
		StepName stepName = stepService.getNextStepName();
		StepPanel firstStep = getStepPanel(stepName);
		frame.add(firstStep);
	}
	
	private void focusing(StepPanel stepPanel) {
		stepService.focusing(stepPanel);
	}
	
	private void startStep(StepPanel stepPanel) {
		stepService.startStep(stepPanel);
	}
	private void stepChange(StepPanel changePanel) {
		frame.getContentPane().removeAll();
		frame.add(changePanel);
		frame.repaint();
		frame.revalidate();
	}
	
	private StepPanel getStepPanel(StepName name) {
		return StepFactory.getStep(name);
	}
	
	

	
}
