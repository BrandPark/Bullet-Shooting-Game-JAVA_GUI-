package step0;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import service.StepManager;
import step4_ingame.staticSrc.Size;

class MainFrame extends JFrame{
	
	public MainFrame(String title) {
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
		
		StepManager manager = StepManager.getInstance();
		StepPanelList stepPanelList = new StepPanelList();
		manager.initPanel(stepPanelList.getList());
		
		manager.gameStart(new MainFrame("Bullet-Shooting-Game"));
	}

	

}
