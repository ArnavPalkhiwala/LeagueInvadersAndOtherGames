package RacketSmash;

import java.awt.Color;
import java.awt.Graphics;

public class TennisBalls extends TennisGameObject{
	
	int ySpeed = 3;
	int xSpeed = 0;
	boolean isAlive = true;

	public TennisBalls(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	
	void update() {
		
		super.update();
		
		
		
		y += ySpeed;
		x += xSpeed;
	}
	
	void draw(Graphics g) {
		
		g.setColor(Color.YELLOW);
		g.fillRect(x, y, width, height);
		
	}

}
