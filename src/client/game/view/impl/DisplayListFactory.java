package client.game.view.impl;

import java.util.ArrayList;
import java.util.List;

import client.game.view.Display;

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
