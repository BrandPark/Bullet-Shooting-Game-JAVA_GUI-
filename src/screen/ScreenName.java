package screen;

public enum ScreenName {
	MainScreen{
		@Override
		public Screen getScreen() {
			return null;
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
