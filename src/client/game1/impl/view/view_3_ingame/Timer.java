package client.game1.impl.view.view_3_ingame;

import javax.swing.JLabel;

public class Timer extends JLabel implements Runnable{
	private int mm;
	private int ss;
	private int ms;
	private String time;
	private boolean on;
	private Thread thread;
	
	public Timer() {
		this.mm = 0;
		this.ss = 0;
		this.ms = 0;
		this.on = true;
		this.time = toTimeForm(mm,ss,ms);
		this.thread = new Thread(this);
		setSize(100,100);
		setLocation(100,100);
		setText(time);
		startTimer();
	}
	public void startTimer() {
		thread.start();
	}
	@Override
	public void run() {
		while(on) {
			System.out.println("gg");
			try {
				Thread.sleep(10);
				ms++;
				roundingUp();
				updateTime();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("타이머 꺼짐...");
	}
	private String toTimeForm(int mm, int ss, int ms) {
		String minute = beforeZero(mm);
		String second = beforeZero(ss);
		String mSecond = beforeZero(ms);
		
		return minute+":"+second+":"+mSecond;
	}
	private String beforeZero(int num) {
		if(num<10)
			return "0"+num;
		return Integer.toString(num);
	}
	
	private void updateTime() {
		this.time = toTimeForm(mm, ss, ms);
		setText(time);
	}
	
	private void roundingUp() {
		if(ms >= 100) {
			ms = 100 - ms;
			ss++;
		}
		if(ss >= 60) {
			ss = 60 - ss;
			mm++;
		}
		if(mm >= 60)
			on = false;
	}
	public void off() {
		on = false;
	}
	
	
}
