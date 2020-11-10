package client.game1.impl.view.view_3_ingame;

import java.awt.event.KeyEvent;
import java.util.List;

import client.common.Direction;
import client.game1.Bullet;
import client.game1.KeyHandler;
import client.game1.Unit;

class UserHandler implements KeyHandler{
	private Unit unit;
	private List<Bullet> bullets;
	private int moveDir = 0;
	
	public UserHandler(Unit unit, List<Bullet> bullets) {
		this.unit = unit;
		this.bullets = bullets;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) 
			moveDir = moveDir | Direction.UP;
		if(key == KeyEvent.VK_DOWN)
			moveDir = moveDir | Direction.DOWN;
		if(key == KeyEvent.VK_LEFT)
			moveDir = moveDir | Direction.LEFT;
		if(key == KeyEvent.VK_RIGHT)
			moveDir = moveDir | Direction.RIGHT;
		if(key == KeyEvent.VK_SPACE) 
			unit.shoot(bullets);
			
		unit.setDirection(moveDir);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_UP) 
			moveDir = moveDir ^ Direction.UP;
		if(key == KeyEvent.VK_DOWN)
			moveDir = moveDir ^ Direction.DOWN;
		if(key == KeyEvent.VK_LEFT)
			moveDir = moveDir ^ Direction.LEFT;
		if(key == KeyEvent.VK_RIGHT)
			moveDir = moveDir ^ Direction.RIGHT;
		unit.setDirection(moveDir);
	}
}
