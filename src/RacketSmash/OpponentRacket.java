package RacketSmash;

import java.awt.Color;
import java.awt.Graphics;

public class OpponentRacket extends TennisGameObject {

	public OpponentRacket(int x, int y, int width, int height) {
		super(x, y, width, height);

	}
	
	int ySpeed = 0;
	int xSpeed = 5;
	


	void update() {
		
		super.update();
		
		if (x >= RacketSmash.width - 3) {
			
			xSpeed = xSpeed*-1;
			
		}
		
		
		
			
			if (x < 0) {
				
				xSpeed = xSpeed*-1;
				
			}

			
		
		
				
		y += ySpeed;
		x += xSpeed;

	}

	void draw(Graphics g) {

		g.setColor(Color.RED);
		g.drawImage(TennisGamePanel.racketImg, x, y, width, height, null);

	}

	private void fillrect(int i, int j, int k, int l) {
		// TODO Auto-generated method stub

	}

}
