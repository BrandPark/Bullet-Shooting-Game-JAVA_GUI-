package client.game.action_service.impl;

import client.game.action_service.Action;
import client.game.impl.MainViewAction;
import client.game.impl.NextViewAction;

public abstract class ActionFactory{
	public static Action nextViewAction() {
		return new NextViewAction();
	}
	public static Action initAction() {
		return new MainViewAction();
	}
}
