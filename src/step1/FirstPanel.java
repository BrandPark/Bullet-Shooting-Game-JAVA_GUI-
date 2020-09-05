package step1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import common.StepPanel;
import step0.StepController;
import step4_ingame.movingObj.UserUnit;

public class FirstPanel extends StepPanel{
	private JButton startBtn = new JButton("시작");
	private StepController stepController = StepController.getInstance();

	
	public FirstPanel() {
		setLayout(new FlowLayout());
		add(startBtn);
		
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				stepController.saveUser(new UserUnit("resource/img_unit/user_unit.png"));
				stepController.nextStep();
			}
		});
	}
	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}
	@Override
	protected void init() {
		// TODO Auto-generated method stub
		
	}
}
