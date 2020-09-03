package step0;

import java.util.ArrayList;
import java.util.List;

import common.StepPanel;
import step1.FirstPanel;
import step4_ingame.frame.GamePanel;

class StepPanelList {
	private List<StepPanel> stepArray = new ArrayList<>();
	
	StepPanelList(){
		stepArray.add(new FirstPanel());
		stepArray.add(new GamePanel());
	}
	
	List<StepPanel> getList(){
		return stepArray;
	}

}
