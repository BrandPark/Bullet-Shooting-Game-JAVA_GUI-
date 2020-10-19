package client.game.view;

import client.game.view.viewImpl_2.FirUser;

abstract public class UserFactory {
	public static User firUser() { return new FirUser(); }
}
