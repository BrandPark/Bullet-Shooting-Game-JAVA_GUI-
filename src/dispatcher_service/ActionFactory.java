package dispatcher_service;

import dispatcher_service.impl.InitScreenAction;
import dispatcher_service.impl.NextScreenAction;

public abstract class ActionFactory{
	public static Action nextScreenAction() {
		return new NextScreenAction();
	}
	public static Action initAction() {
		return new InitScreenAction();
	}
}
