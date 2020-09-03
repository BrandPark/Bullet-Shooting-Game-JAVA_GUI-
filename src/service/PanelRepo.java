package service;

import java.util.List;

import common.StepPanel;

//@Singleton
final class PanelRepo {
	private List<StepPanel> panelArray = null;
	private static final PanelRepo INSTANCE = new PanelRepo();
	
	private PanelRepo() {}
	
	final static PanelRepo getRepo() {
		return INSTANCE;
	}
	
	final void save(List<StepPanel> arr) {
		this.panelArray = arr;
	}
	
	
	final StepPanel getPanel(int step) {
		return panelArray.get(step);
	}
	
	final void initPanel(List<StepPanel> list) {
		panelArray = list;
	}
	
}
