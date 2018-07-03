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
		
		super.update();

	}

	void updatePositionR() {

		super.update(); 

		speed = 35;
		x += speed;

	}

	void updatePositionL() {

		super.update();

		speed = 35;
		x -= speed;

	}

	void updatePositionU() {

		super.update();
		
		speed = 35;
		y -= speed;

	}

	void updatePositionD() {

		super.update();

		speed = 35;
		y += speed;

	}

	void draw(Graphics g) {
		
		g.setColor(Color.BLUE);

		g.fillRect(x , y , 50, 50);
		
		
	}

	private void fillrect(int i, int j, int k, int l) {
		// TODO Auto-generated method stub
		
	}



}
