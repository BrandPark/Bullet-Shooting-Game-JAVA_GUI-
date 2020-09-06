package steps.step0;

import java.util.ArrayList;
import java.util.List;

import steps.step1.FirstPanel;
import steps.step4_ingame.frame.GamePanel;

class StepPanelList {
	private List<StepPanel> stepArray = new ArrayList<>();
	
	StepPanelList(){
		stepArray.add(new FirstPanel());
		stepArray.add(new GamePanel());
	}
	
	void initPanel(StepController stepController){
		stepController.initPanel(stepArray);
	}
}
