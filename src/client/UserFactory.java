package client;

import client.viewImpl_2.FirUser;

abstract public class UserFactory {
	public static User firUser() { return new FirUser(); }
}
