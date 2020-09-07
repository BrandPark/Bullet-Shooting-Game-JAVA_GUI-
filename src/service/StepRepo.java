package service;

import java.util.ArrayList;
import java.util.List;

import common.static_data.StepName;

//@Singleton
final class StepRepo {
	
	private static final StepRepo INSTANCE = new StepRepo();
	private List<StepName> stepList = new ArrayList<StepName>();
	private int size = 0;
	
	private StepRepo() {
		listInit();
	}
	
	final static StepRepo getRepo() {
		return INSTANCE;
	}
	
	public final StepName getStepNameByIndex(int index) {
		if(index != size)
			return stepList.get(index);
		return null;
	}
	
	private final void listInit() {
		stepList.add(StepName.FIRST_STEP);
		stepList.add(StepName.GAME_PANEL);
		size = stepList.size();
	}
	
}
