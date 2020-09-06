package steps.step4_ingame.frame;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import common.static_data.Location;
import common.static_data.Size;

public class LifePanel extends JPanel{
	private int life;
	private JLabel [] lifeArr = new JLabel[3];
	public LifePanel(){
	
		//test
		this.life = 3;
		//
		setLocation(Location.LIFE_X, Location.LIFE_Y);
		setSize(Size.LIFE_W, Size.LIFE_H);
		setLayout(new GridLayout(1,3,1,1));
		for(int i=0;i<3;i++) {
			lifeArr[i] = new JLabel("O");
			add(lifeArr[i]);
		}
	}
	
	public void setLife(int life){
	}
}
