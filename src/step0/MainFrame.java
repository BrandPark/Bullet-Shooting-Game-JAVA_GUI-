package step0;

import javax.swing.JFrame;
import javax.swing.JPanel;

class MainFrame extends JFrame{
	private JPanel panel;
	private StepManager sm;
	
	public MainFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		sm = StepManager.valueOf(this);
		setContentPane(sm.getPanel());
		
		pack();
		setResizable(false);
		
		setLocationRelativeTo(null);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new MainFrame("Bullet-Shooting-Game");
	}

	

}
