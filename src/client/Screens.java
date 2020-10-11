package client;

import client.viewImpl_1.MainView;
import client.viewImpl_2.SelectUnitView;

public enum Screens {
	MainScreen{
		@Override
		public View getView() {
			return new MainView();
		}
	},
	SelectLevelScreen{
		@Override
		public View getView() {
			return new SelectUnitView();
		}
	},
	IngameScreen{
		@Override
		public View getView() {
			return null;
		}
	};
	abstract public View getView();
	
}
