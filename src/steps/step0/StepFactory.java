package steps.step0;

import common.static_data.StepName;
import service.StepService;
import steps.step1.FirstPanel;
import steps.step4_ingame.frame.GamePanel;

public abstract class StepFactory {
	private StepService stepService = StepService.getInstance();
	private static StepPanel stepPanel = null;
	public static final StepPanel getStep(StepName name) {
		
		switch(name) {
		case FIRST_STEP:
			stepPanel = new FirstPanel();
			break;
			
		case GAME_PANEL:
			stepPanel = new GamePanel();
		}
		stepPanel.focussing();
		return stepPanel;
	}
	
}
