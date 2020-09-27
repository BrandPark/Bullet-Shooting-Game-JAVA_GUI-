package backup.service;

import backup.steps.step4_ingame.movingObj.unit.UserUnit;

//Singleton
final class UserRepo {
	private UserUnit userUnit = null;
	private static final UserRepo INSTANCE = new UserRepo();
	
	private UserRepo() {}
	
	final static UserRepo getRepo() {
		return INSTANCE;
	}
	
	
	final void save(UserUnit userUnit) {
		this.userUnit = userUnit;
	}
	final UserUnit getUserUnit() {
		return userUnit;
	}
	
}
