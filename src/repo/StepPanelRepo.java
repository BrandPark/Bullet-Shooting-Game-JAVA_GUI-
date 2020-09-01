package repo;

import java.util.ArrayList;
import java.util.List;

import common.StepPanel;

//@Singleton
public class StepPanelRepo {
	private List<StepPanel> panelArray = new ArrayList<>();
	private static final StepPanelRepo INSTANCE = new StepPanelRepo();
	
	private StepPanelRepo() {}
	
	public static StepPanelRepo getRepo() {
		return INSTANCE;
	}
	
	final public void save(List<StepPanel> arr) {
		this.panelArray = arr;
	}
	
	final public void addPanel(StepPanel panel) {
		if(!panelArray.contains(panel))
			panelArray.add(panel);
	}
	
	final public StepPanel nextStep(StepPanel curPanel) {
		int index = panelArray.indexOf(curPanel);
		return getPanel(index);
	}
	
	
	final private StepPanel getPanel(int step) {
		return panelArray.get(step);
	}
}
