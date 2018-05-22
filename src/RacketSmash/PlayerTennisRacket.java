package RacketSmash;

import java.awt.Color;
import java.awt.Graphics;

import leagueInvaders.GamePanel;

public class PlayerTennisRacket  extends TennisGameObject {
	
	int speed;
	
	public PlayerTennisRacket (int x, int y, int height, int width) {
		super(x, y, width, height);

		speed = 15;

	}
	
	void update() {

	}

	void updatePositionR() {

		super.update(); 

		speed = 45;
		x += speed;

	}

	void updatePositionL() {

		super.update();

		speed = -45;
		x += speed;

	}

	void updatePositionU() {

		super.update();

		speed = 45;
		y += speed;

	}

	void updatePositionD() {

		super.update();

		speed = -45;
		y += speed;

	}

	void draw(Graphics g) {


		g.drawImage(TennisGamePanel.imagesImg, x, y, 75, 75, null);    	
	}



}
