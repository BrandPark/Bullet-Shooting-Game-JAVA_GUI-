package common;

import java.awt.Dimension;

import javax.swing.JPanel;

import step4_ingame.staticSrc.Size;

abstract public class StepPanel extends JPanel{
	public StepPanel(){
		setPreferredSize(new Dimension(Size.FRAME_W,Size.FRAME_H));
	}
}
