package backup.steps.step4_ingame.frame;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.static_data.Location;
import common.static_data.Size;

public class TimeScorePanel extends JPanel{
	private TimeLabel tl;
	private ScoreLabel sl;
	
	public TimeScorePanel() {
		setLayout(new GridLayout(2,2,1,1));
		setLocation(Location.TIME_SCORE_X, Location.TIME_SCORE_Y);
		setSize(Size.TIME_SCORE_W, Size.TIME_SCORE_H);
		
		
		tl = new TimeLabel();
		sl = new ScoreLabel();
		
		add(new JLabel("Time"));
		add(tl);
		add(new JLabel("Score"));
		add(sl);
		
		new Thread(tl).start();
		
	}
}
