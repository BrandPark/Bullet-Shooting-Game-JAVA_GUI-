package game;

import java.awt.Container;

import javax.swing.JFrame;

class MainFrame extends JFrame{
	private GamePanel gp = new GamePanel();
	
	public MainFrame(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.add(gp);
		
		pack();
		setResizable(false);
		
		setLocationRelativeTo(null);
		setVisible(true);
		Thread th = new Thread(gp);
		th.start();
	}
	
	public static void main(String[] args) {
		new MainFrame("Bullet-Shooting-Game");
		
		
	}

	

}
