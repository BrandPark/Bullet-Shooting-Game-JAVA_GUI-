package interfaces.element;

import screen_2_selectunit.element.FirUser;

abstract public class UserFactory {
	public static User firUser() { return new FirUser(); }
}
