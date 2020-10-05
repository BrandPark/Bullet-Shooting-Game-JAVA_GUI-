package client;

import client.viewImpl_1.MainScreen;
import client.viewImpl_2.SelectUnitScreen;

public enum Screens {
	MainScreen{
		@Override
		public Screen getScreen() {
			return new MainScreen();
		}
	},
	SelectLevelScreen{
		@Override
		public Screen getScreen() {
			return new SelectUnitScreen();
		}
	},
	IngameScreen{
		@Override
		public Screen getScreen() {
			return null;
		}
	};
	abstract public Screen getScreen();
	
}
