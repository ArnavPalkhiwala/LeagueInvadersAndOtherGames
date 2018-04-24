package leagueInvaders;

import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {

	int speed;

	public Rocketship(int x, int y, int height, int width) {
		super(x, y, height, width);

		speed = 5;

	}

	void update() {

	}

	void updatePositionR() {
		
		speed = 5;
		x += speed;

	}

	void updatePositionL() {

		speed = -5;
		x += speed;

	}

	void updatePositionU() {
		
		speed = 5;
		y += speed;

	}

	void updatePositionD() {

		speed = -5;
		y += speed;

	}

	void draw(Graphics g) {

		g.setColor(Color.BLUE);

		g.fillRect(x, y, width, height);

	}

}
