package step0;

import javax.swing.JFrame;
import javax.swing.JPanel;

import repo.StepPanelRepo;

class MainFrame extends JFrame{
	private JPanel panel;
	private StepPanelRepo pr;
	
	public MainFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		pr = StepPanelRepo.getRepo();
		
		pack();
		setResizable(false);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MainFrame("Bullet-Shooting-Game");
	}

	

}
