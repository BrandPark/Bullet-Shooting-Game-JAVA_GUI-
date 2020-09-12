package steps.step1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import steps.step0.StepController;
import steps.step0.StepPanel;
import steps.step4_ingame.movingObj.unit.UnitName;
import steps.step4_ingame.movingObj.unit.UserUnit;

public class FirstPanel extends StepPanel{
	private JButton startBtn = new JButton("시작");
	private StepController stepController = StepController.getInstance();
	
	public FirstPanel() {
		setLayout(new FlowLayout());
		init();
	}
	@Override
	protected void init() {
		add(startBtn);
		
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stepController.saveUser(new UserUnit(UnitName.USER_UNIT1));
				stepController.nextStep();
			}
		});
	}
}
