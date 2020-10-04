package interfaces.screen;

import screen_1_main.screen.MainScreen;
import screen_2_selectlevel.screen.SelectLevelScreen;

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
			return new SelectLevelScreen();
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
