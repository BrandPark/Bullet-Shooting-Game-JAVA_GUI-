package backup.steps.step1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import backup.steps.step0.StepController;
import backup.steps.step0.StepPanel;
import backup.steps.step4_ingame.movingObj.unit.UnitName;
import backup.steps.step4_ingame.movingObj.unit.UserUnit;

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
