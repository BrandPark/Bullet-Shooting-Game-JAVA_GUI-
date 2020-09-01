package step0;

import javax.swing.JFrame;

public final class StepManager {
	private int curStepIndex;
	private JFrame frame;
	
	private static StepManager INSTANCE = null;
	
	public static StepManager valueOf(JFrame frame) {
		if(INSTANCE==null) {
			INSTANCE = new StepManager(frame);
		}
		return INSTANCE;
	}
	public static StepManager valueOf() {
		return INSTANCE;
	}
	private StepManager(JFrame frame) {
		this.frame = frame;
		curStepIndex = 0;
		
	}
	
}
