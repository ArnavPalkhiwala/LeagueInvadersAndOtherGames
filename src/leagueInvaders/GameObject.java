package leagueInvaders;

import java.awt.Graphics;

public class GameObject {
	
	boolean isAlive = true;

	int x;
	int y;
	int height;
	int width;

	public GameObject(int x, int y, int height, int width) {

		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
	}

	void update() {
		
	}

	void draw(Graphics g) {


	}
}
