package client.game1.impl.view.view_3_ingame;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import client.game1.Bullet;
import client.game1.Button;
import client.game1.Display;
import client.game1.Model;
import client.game1.Unit;
import client.game1.View;

public class InGameView implements View{
	private final List<Button> buttons = new ArrayList<>();
	private final List<Display> displays = new ArrayList<>();
	private final List<Bullet> bullets = new Vector<>(); 
	private final Model model;
	private final Unit unit;
	
	public InGameView(Model model, Unit unit) {
		this.model = model;
		this.unit = unit;
	}
	@Override
	public boolean paint(Graphics2D g2d, ImageObserver imageObserver) {
		System.out.println("paint()");
		if(!unit.paint(g2d, imageObserver))
			return false;
		for(Bullet bullet : bullets) {
//			if(!bullet.isInFrame()) {
//				bullet.remove();
//				bullets.remove(bullet);
//				continue;
//			}
			if(bullet.paint(g2d, imageObserver))
				return false;
		}
		return true;
	}

	@Override
	public void stopView() {
	
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_SPACE)
//			unit.shoot(bullets);
			bullets.add(new Bullet1(400,400));
		else unit.keyPressed(e);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		unit.keyReleased(e);
	}

}
