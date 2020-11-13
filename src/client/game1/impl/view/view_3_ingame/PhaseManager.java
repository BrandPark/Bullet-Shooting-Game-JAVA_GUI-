package client.game1.impl.view.view_3_ingame;

import java.util.ArrayList;
import java.util.List;

import client.game1.Enemy;

class PhaseManager {
	private int phaseNum;
	private Phase phase1;
	private Phase phase2;
	private List<Phase> phaseList;
	
	public PhaseManager(){
		phaseNum = -1;
		phase1 = new Phase();
		phase2 = new Phase();
		phaseList = new ArrayList<>();
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
	
	private void phaseInit() {
		phase1.add(new Enemy1(400,100));
		phase1.add(new Enemy1(200,100));
		
		phase2.add(new Enemy1(400,100));
		phase2.add(new Enemy1(200,100));
		
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
