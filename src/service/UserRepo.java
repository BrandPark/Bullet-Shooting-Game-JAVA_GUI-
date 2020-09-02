package service;

import step4_ingame.movingObj.UserUnit;

//Singleton
public final class UserRepo {
	private UserUnit userUnit = null;
	private static final UserRepo INSTANCE = new UserRepo();
	
	private UserRepo() {}
	
	final static UserRepo getRepo() {
		return INSTANCE;
	}
	
	
	final void save(UserUnit userUnit) {
		if(userUnit == null)
			this.userUnit = userUnit;
	}
	final UserUnit getUserUnit() {
		return userUnit;
	}
	
}
