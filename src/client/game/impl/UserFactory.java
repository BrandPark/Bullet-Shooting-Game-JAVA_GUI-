package client.game.impl;

import client.game.User;
import client.game.impl.viewImpl_2.FirUser;

abstract public class UserFactory {
	public static User firUser() { return new FirUser(); }
}
