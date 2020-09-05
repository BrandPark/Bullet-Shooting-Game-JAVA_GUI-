package step0;

import java.util.List;

import javax.swing.JFrame;

import common.StepPanel;
import step0.service.StepService;
import step4_ingame.movingObj.UserUnit;

public final class StepController {
	private int curStepIndex;
	private JFrame frame;
	private StepService stepService;
	private static StepController INSTANCE = null;
	
    public static final StepController getInstance() {
		if(INSTANCE==null) {
			INSTANCE = new StepController();
		}
		return INSTANCE;
	}
	private StepController() {
		stepService = StepService.getInstance();
		curStepIndex = 0;
	}
	
	public void saveUser(UserUnit userUnit) {
		stepService.saveUser(userUnit);
	}
	
	public void nextStep() {
		StepPanel curStep = stepService.getStep(curStepIndex++);
		StepPanel nextStep = stepService.getStep(curStepIndex);
		stepPanelChange(curStep,nextStep);
		focusing(nextStep);
		startStep(nextStep);
	}
	public void gameStart(JFrame frame) {
		this.frame = frame;
		frame.add(stepService.getStep(0));
	}

	public void initPanel(List<StepPanel> list) {
		stepService.initPanel(list);
	}
	
	private void focusing(StepPanel stepPanel) {
		stepService.focusing(stepPanel);
	}
	
	private void startStep(StepPanel stepPanel) {
		stepService.startStep(stepPanel);
	}
	private void stepPanelChange(StepPanel oldPanel, StepPanel changePanel) {
		frame.remove(oldPanel);
		frame.add(changePanel);
		frame.repaint();
		frame.revalidate();
	}
	
	

	
}
