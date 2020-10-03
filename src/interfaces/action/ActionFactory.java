package interfaces.action;

import interfaces.action.impl.InitScreenAction;
import interfaces.action.impl.NextScreenAction;

public abstract class ActionFactory{
	public static Action nextScreenAction() {
		return new NextScreenAction();
	}
	public static Action initAction() {
		return new InitScreenAction();
	}
}
