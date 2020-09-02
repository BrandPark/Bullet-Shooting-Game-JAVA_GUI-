package step0;

import javax.swing.JFrame;
import javax.swing.JPanel;

import service.StepManager;

class MainFrame extends JFrame{
	private StepManager manager;
	
	public MainFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		manager = StepManager.getInstance();
		
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