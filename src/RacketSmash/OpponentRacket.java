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
		g.drawImage(TennisGamePanel.danger, x, y, width, height, null);

	}

	private void fillrect(int i, int j, int k, int l) {
		// TODO Auto-generated method stub

	}

}
