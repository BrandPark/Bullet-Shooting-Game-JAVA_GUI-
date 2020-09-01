package step1;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import common.StepPanel;
import step4_ingame.staticSrc.Size;

public class FirstPanel extends StepPanel{

	private JButton startBtn = new JButton("시작");
	
	public FirstPanel() {
		setPreferredSize(new Dimension(Size.FRAME_W,Size.FRAME_H));
		
		add(startBtn, FlowLayout.CENTER);
		
		startBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	}
	@Override
	public StepPanel getPanel() {
		return null;
	}

}
