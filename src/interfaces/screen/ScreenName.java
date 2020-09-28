package interfaces.screen;

import screen_1_main.screen.MainScreen;

public enum ScreenName {
	MainScreen{
		@Override
		public Screen getScreen() {
			return new MainScreen();
		}
		@Override
		public Screen next() {
			return null;
		}
	},
	SelectLevelScreen{
		@Override
		public Screen getScreen() {
			return null;
		}

		@Override
		public Screen next() {
			return null;
		}
	},
	IngameScreen{
		@Override
		public Screen getScreen() {
			return null;
		}

		@Override
		public Screen next() {
			return null;
		}
		
	};
	abstract public Screen getScreen();
	abstract public Screen next();
}
