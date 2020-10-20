package client.game.view.viewImpl_2;

import java.util.ArrayList;
import java.util.List;

import client.game.view.Display;
import client.game.view.viewImpl_2.SelectTitle;

abstract public class DisplayListFactory {
	public static final List<Display> forMain() {
		List<Display> displays = new ArrayList<>();
		displays.add(new Title());
		return displays;
	}
	
	public static final List<Display> forSelectUnit() {
		List<Display> displays = new ArrayList<>();
		displays.add(new SelectTitle());
		return displays;
	}
}
