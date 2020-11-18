package client.game.impl.view_3_ingame;

import java.awt.event.KeyEvent;
import java.util.List;

import client.game.Bullet;
import client.game.KeyHandler;
import client.game.User;
import client.game.impl.common.Direction;

class UserHandler implements KeyHandler{
	private User unit;
	private List<Bullet> bullets;
	private int moveDir = 0;
	
	public UserHandler(User user) {
		this.unit = user;
		this.bullets = user.getBullets();
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
		if(key == KeyEvent.VK_Z) 
			unit.shoot();
			
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
		if(key == KeyEvent.VK_Z) 
			unit.stopShoot();
		unit.setDirection(moveDir);
	}
}
