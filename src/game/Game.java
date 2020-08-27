package game;

import javax.swing.JFrame;

class Game extends JFrame {
	
	
	public Game(String title) {
		setTitle(title);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setSize(500,500);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Game("Bullet-Shooting-Game");
		
	}

}
