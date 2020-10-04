package interfaces.screen;

import screen_1_main.view.MainScreen;
import screen_2_selectunit.view.SelectUnitScreen;

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
