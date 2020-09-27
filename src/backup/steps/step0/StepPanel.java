package backup.steps.step0;

import javax.swing.JPanel;

abstract public class StepPanel extends JPanel{
	
	abstract protected void init();
	public void focussing() {
		requestFocus();
		setFocusable(true);
	}
}
