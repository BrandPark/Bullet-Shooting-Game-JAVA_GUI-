package client.game.action_service;

import client.game.action_service.impl.MainViewAction;
import client.game.action_service.impl.NextViewAction;

public abstract class ActionFactory{
	public static Action nextViewAction() {
		return new NextViewAction();
	}
	public static Action initAction() {
		return new MainViewAction();
	}
}
