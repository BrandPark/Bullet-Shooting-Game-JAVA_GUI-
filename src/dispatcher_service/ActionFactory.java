package dispatcher_service;

import dispatcher_service.impl.MainViewAction;
import dispatcher_service.impl.NextViewAction;

public abstract class ActionFactory{
	public static Action nextScreenAction() {
		return new NextViewAction();
	}
	public static Action initAction() {
		return new MainViewAction();
	}
}
