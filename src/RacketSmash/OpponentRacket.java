package RacketSmash;

import java.awt.Color;
import java.awt.Graphics;

public class OpponentRacket extends TennisGameObject {

	public OpponentRacket(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	void update() {

	}

	void draw(Graphics g) {

		g.setColor(Color.RED);
		g.fillRect(465, 10, 150, 150);

	}

	private void fillrect(int i, int j, int k, int l) {
		// TODO Auto-generated method stub

	}

}