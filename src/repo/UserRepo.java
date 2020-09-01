package repo;

import step4_ingame.movingObj.UserUnit;

//Singleton
public final class UserRepo {
	private UserUnit userUnit;
	private static final UserRepo INSTANCE = new UserRepo();
	
	private UserRepo() {}
	
	public final static UserRepo getRepo() {
		return INSTANCE;
	}
	
	
	public final void save(UserUnit userUnit) {
		this.userUnit = userUnit;
	}
	public final UserUnit getUserUnit() {
		return userUnit;
	}
	
}
