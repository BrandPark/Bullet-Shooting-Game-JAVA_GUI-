package step0;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import common.static_data.Size;

class MainFrame extends JFrame{
	
	MainFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		Container c = getContentPane();
		c.setPreferredSize(new Dimension(Size.FRAME_W, Size.FRAME_H));
		
		pack();
		setResizable(false);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		
		StepController stepController = StepController.getInstance();
		StepPanelList stepPanelList = new StepPanelList();
		stepPanelList.initPanel(stepController);
		
		stepController.gameStart(new MainFrame("Bullet-Shooting-Game"));
	}

	

}
