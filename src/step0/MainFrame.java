package step0;

import javax.swing.JFrame;

import service.StepManager;

class MainFrame extends JFrame{
	private StepManager manager;
	private StepPanelList stepPanelList;
	public MainFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		manager = StepManager.getInstance();
		stepPanelList = new StepPanelList();
		manager.initPanel(stepPanelList.getList());
		gameStart();
		
		pack();
		setResizable(false);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	private void gameStart() {
		manager.gameStart(this);	
	}
	
	
	public static void main(String[] args) {
		new MainFrame("Bullet-Shooting-Game");
	}

	

}
