package service;

import java.util.ArrayList;
import java.util.List;

import common.StepPanel;
import step1.FirstPanel;
import step4_ingame.frame.GamePanel;

//@Singleton
final class PanelRepo {
	private List<StepPanel> panelArray = null;
	private static final PanelRepo INSTANCE = new PanelRepo();
	
	private PanelRepo() {
		panelArray = new ArrayList<>();
		panelInit();
	}
	
	final static PanelRepo getRepo() {
		return INSTANCE;
	}
	
	final void save(List<StepPanel> arr) {
		this.panelArray = arr;
	}
	
	
	final StepPanel getPanel(int step) {
		return panelArray.get(step);
	}
	
	final private void panelInit() {
		addPanel(new FirstPanel());
		addPanel(new GamePanel());
	}
	
	final private void addPanel(StepPanel panel) {
		if(!panelArray.contains(panel))
			panelArray.add(panel);
	}
}
