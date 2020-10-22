package client.game.action_service.impl;

import client.game.action_service.Action;
import client.game.view.MainViewAction;
import client.game.view.NextViewAction;

public abstract class ActionFactory{
	public static Action nextViewAction() {
		return new NextViewAction();
	}
	public static Action initAction() {
		return new MainViewAction();
	}
}
