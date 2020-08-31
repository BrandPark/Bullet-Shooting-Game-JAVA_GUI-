package step0;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;

import common.StepPanel;
import step4_ingame.frame.GamePanel;
import step4_ingame.movingObj.Unit;

public final class StepManager {
	private int curStep;
	private JFrame frame;
	private Vector<Unit> enemyUnits = new Vector<>();
	private ArrayList<StepPanel> panelArray = new ArrayList<>();
	private int userUnitCode;
	private static StepManager sm = null;
	
	public static StepManager valueOf(JFrame frame) {
		if(sm==null) {
			sm = new StepManager(frame);
		}
		return sm;
	}
	public static StepManager valueOf() {
		return sm;
	}
	private StepManager(JFrame frame) {
		this.frame = frame;
		curStep = 0;
		initPanels();
		//임시. 원래는 이전 패널로부터 저장된 유닛코드를 셋팅하는 것.
		userUnitCode = 1;
		
	}
	
	public void initPanels() {
		panelArray.add(new GamePanel());
		//..
	}
	public void addEnemyUnit(Unit unit) {
		enemyUnits.add(unit);
	}
	
	public void changePanel(StepPanel panel) {
		frame.setContentPane(panel);
		curStep = panelArray.indexOf(panel);
	}
	public void stepOver() {
		
		if(curStep != panelArray.size()-1)
			changePanel(panelArray.get(curStep+1));
		else 
			throw new IndexOutOfBoundsException(curStep+1);
	}
	public int getCurSteps() {
		return curStep;
	}
	public int getUserUnitCode() {
		return userUnitCode;
	}
	
	public StepPanel getPanel() {
		StepPanel curPanel = panelArray.get(curStep);
		return curPanel.getPanel();
	}
}
