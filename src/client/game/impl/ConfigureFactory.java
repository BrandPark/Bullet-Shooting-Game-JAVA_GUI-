package client.game.impl;

import client.game.Configure;

abstract public class ConfigureFactory {
	static final public Configure getConfigure() {
		return new ConfigureImpl();
	}
}
