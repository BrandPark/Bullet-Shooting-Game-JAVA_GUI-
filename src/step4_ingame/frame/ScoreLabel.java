package step4_ingame.frame;

import javax.swing.JLabel;

public class ScoreLabel extends JLabel {
	private int score;
	
	public ScoreLabel() {
		score = 0;
		setText(String.valueOf(score));
		
	}
	public int getScore() {
		return score;
	}
}
