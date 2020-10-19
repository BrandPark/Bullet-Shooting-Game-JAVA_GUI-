package client.game.view;

import client.game.view.viewImpl_1.MainView;
import client.game.view.viewImpl_2.SelectUnitView;

public enum Views {
	MainView{
		@Override
		public View getView() {
			return new MainView();
		}
	},
	SelectUnitView{
		@Override
		public View getView() {
			return new SelectUnitView();
		}
	},
	IngameView{
		@Override
		public View getView() {
			return null;
		}
	};
	abstract public View getView();
	
}
