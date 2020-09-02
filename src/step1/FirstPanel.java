package step1;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import common.StepPanel;
import service.StepManager;
import step4_ingame.movingObj.UserUnit;

public class FirstPanel extends StepPanel{
	private JButton startBtn = new JButton("시작");
	private StepManager manager = StepManager.getInstance();

	
	public FirstPanel() {
		setLayout(new FlowLayout());
		add(startBtn);
		
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				StepManager manager = StepManager.getInstance();
				manager.saveUser(new UserUnit("resource/img_unit/user_unit.png"));
				manager.nextStep();
				
			}
		});
	}

	@Override
	public void focusing() {
		requestFocus();
		setFocusable(true);
	}

}
