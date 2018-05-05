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
		
        super.update();

		
		speed = 15;
		x += speed;

	}

	void updatePositionL() {
		
        super.update();


		speed = -15;
		x += speed;

	}

	void updatePositionU() {

        super.update();

		speed = 15;
		y += speed;

	}

	void updatePositionD() {
		
        super.update();


		speed = -15;
		y += speed;

	}

	void draw(Graphics g) {

		g.setColor(Color.BLUE);

		g.fillRect(x, y, width, height);

	}

}
