package client.game.impl.view.view_3_ingame;

import java.util.ArrayList;
import java.util.List;

import client.game.Bullet;
import client.game.Enemy;

class PhaseManager {
	private int phaseNum;
	private Phase phase1;
	private Phase phase2;
	private List<Phase> phaseList;
	private List<Bullet> bullets;
	public PhaseManager(){
		phaseNum = -1;
		phase1 = new Phase();
		phase2 = new Phase();
		phaseList = new ArrayList<>();
		bullets = new ArrayList<>();
		phaseInit();
	}
	
	public Phase nextPhase() {
		phaseNum++;
		
		if(phaseNum < phaseList.size()) {
			Phase p =  phaseList.get(phaseNum);
			p.startPhase();
			return p;
		}
			
		return null;
	}
	public List<Bullet> getBullets(){
		return bullets;
	}
	private void phaseInit() {
		phase1.add(new Enemy1(400,-30, bullets));
		phase1.add(new Enemy1(200,-30, bullets));
		
		phase2.add(new Enemy1(400,-50, bullets));
		phase2.add(new Enemy1(200,-50, bullets));
		
		phaseList.add(phase1);
		phaseList.add(phase2);
	}
	public void off() {
		for(Phase p : phaseList) {
			for(Enemy e : p) {
				e.off();
			}
		}
	}
}
