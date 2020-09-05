package step4_ingame.frame;

import javax.swing.JLabel;

public class TimeLabel extends JLabel implements Runnable {
	private int mm;
	private int ss;
	private int ms;
	
	public TimeLabel() {
		mm = 0;
		ss = 0;
		ms = 0;
		setText("00:00:00");
	}
	private String changeForm(int n) {
		if(n/10 < 1) {
			return "0"+String.valueOf(n);
		}
		else
			return String.valueOf(n);
	}

	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(10);
				ms++;
				if(ms>99) {
					ms=0;
					ss++;
					if(ss>59) {
						ss=0;
						mm++;
						if(mm>59) {
							return; 
						}
					}
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			String m = changeForm(mm);
			String s = changeForm(ss);
			String mis = changeForm(ms);
			setText(m+":"+s+":"+mis);
		}
	}
}
