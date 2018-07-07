package RacketSmash;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import leagueInvaders.Alien;
import leagueInvaders.LeagueInvaders;
import leagueInvaders.Rocketship;

public class TennisObjectManager {

	ArrayList<TennisBalls> tennisBallsList = new ArrayList<TennisBalls>();

	PlayerTennisRacket ptr;

	TennisBalls tennisBalls;

	OpponentRacket or;

	int ballSpawnTime = 2500;

	long tennisTimer = 0;

	private int totalScore;

	public int gettotalScore() {

		return totalScore;
	}

	public void setTotalScore() {

		this.totalScore = totalScore;
	}

	public TennisObjectManager(PlayerTennisRacket ptr, TennisBalls tennisBalls, OpponentRacket or) {

		this.ptr = ptr;
		this.tennisBalls = tennisBalls;
		this.or = or;

	}

	void addTheTennisBalls(TennisBalls tb) {

		tennisBallsList.add(tb);
	}

	void draw(Graphics g) {
		for (TennisBalls tb : tennisBallsList) {

			tb.draw(g);

		}

	}

	void update() {
		for (TennisBalls tb : tennisBallsList) {

			tb.update();
		}

	}

	public void manageTennisBalls() {

		if (System.currentTimeMillis() - tennisTimer >= ballSpawnTime) {
			addTheTennisBalls(new TennisBalls(new Random().nextInt(RacketSmash.width), 0, 50, 50));

			tennisTimer = System.currentTimeMillis();
		}

	}

	void checkCollision() {

		ArrayList<TennisBalls> TennisBalls2 = (ArrayList<TennisBalls>) tennisBallsList.clone();

		for (TennisBalls tennisBalls : tennisBallsList) {

			if (tennisBalls.collisionBox.intersects(ptr.collisionBox)) {

				Random r = new Random();
				int rangeX = RacketSmash.width - ptr.x;
				int rangeY = ptr.y - 10;
				tennisBalls.ySpeed = -2;
				tennisBalls.xSpeed = r.nextInt(rangeX);
				tennisBalls.y = tennisBalls.ySpeed;
				tennisBalls.x = tennisBalls.xSpeed;

			}

			// if (tennisBalls.y <= 75) {
			// tennisBallsList.remove(tennisBalls);
			// }

			if (tennisBalls.collisionBox.intersects(or.collisionBox)) {

				System.out.println("It works");
				totalScore = totalScore + 1;
				TennisBalls2.remove(tennisBalls);

			}

		}

		tennisBallsList = TennisBalls2;

	}

}
