package repo;

import java.util.Vector;

import step4_ingame.movingObj.Unit;

public class EnemyRepo {
	private int level;
	private Vector<Unit> enemys = new Vector<Unit>();
	private static final EnemyRepo INSTANCE = new EnemyRepo();
	
	private EnemyRepo() {}
	
	public static final EnemyRepo getRepo() {
		return INSTANCE;
	}
	final public void save(int level) {
		this.level = level;
	}
	final public Vector<Unit> getEnemys(){
		return enemys;
	}
	final private Vector<Unit> getEnemysFromFile(int level) {
		//저장된 파일로부터 enemys를 가져옴
		return null;
	}
}
