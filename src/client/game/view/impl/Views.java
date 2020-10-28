package client.game.view.impl;

import client.game.ActionQueue;
import client.game.ViewQueue;
import client.game.view.View;

public enum Views {
	MainView{
		@Override
		public View getView(ViewQueue viewQueue, ActionQueue actionQueue) {
			return new MainView(viewQueue, actionQueue);
		}
	},
	SelectUnitView{
		@Override
		public View getView(ViewQueue viewQueue, ActionQueue actionQueue) {
			return new SelectUnitView(viewQueue, actionQueue);
		}
	},
	IngameView{
		@Override
		public View getView(ViewQueue viewQueue, ActionQueue actionQueue) {
			return null;
		}
	};
	abstract public View getView(ViewQueue viewQueue, ActionQueue actionQueue);
	
}
