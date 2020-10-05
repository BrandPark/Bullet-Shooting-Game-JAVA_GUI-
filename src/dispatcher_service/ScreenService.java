package dispatcher_service;

abstract public class ScreenService {
	
	public static void doInit() {
		Action action = ActionFactory.initAction();
		action.execute();
	}
	public static void showNext() {
		Action action = ActionFactory.nextScreenAction();
		action.execute();
	}
	
}
