package leagueInvaders;

import java.awt.Graphics;

public class GameObject {

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
		x = x + 23;
		y = y + 23;
	}

	void draw(Graphics g) {

		g.fillRect(x, y, 100, 100);

	}
}
