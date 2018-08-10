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

	int ballSpawnTime = 2000;

	long tennisTimer = 0;

	private int totalScore;

	public int gettotalScore() {

		return totalScore;
	}

	public void setTotalScore(int totalScore) {

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

//		ArrayList<TennisBalls> TennisBalls2 = (ArrayList<TennisBalls>) tennisBallsList.clone();

		Loop: for (TennisBalls tennisBalls : tennisBallsList) {

			if (tennisBalls.collisionBox.intersects(ptr.collisionBox)) {

				int x = tennisBalls.x + tennisBalls.width / 2;
				if (x >= ptr.x && x <= ptr.x + 20) {
			
					System.out.println("Collision");
					tennisBalls.ySpeed *= -1;
					//tennisBalls.ySpeed = tennisBalls.ySpeed;
					totalScore += 1;
					continue Loop;

				}

				else if (x >= ptr.x + 20 && x <= ptr.x + 40) {

					tennisBalls.ySpeed *= -1;
					//tennisBalls.ySpeed = tennisBalls.ySpeed;
					totalScore += 1;
					tennisBalls.y = tennisBalls.y-5;
					continue Loop;


				}

				else if (x >= ptr.x + 40 && x <= ptr.x + 60) {

					tennisBalls.ySpeed *= -1;
					//tennisBalls.ySpeed = tennisBalls.ySpeed;
					totalScore += 1;
					tennisBalls.y = tennisBalls.y-5;
					continue Loop;

				}

				else if (x >= ptr.x + 60 && x <= ptr.x + 80) {

					tennisBalls.ySpeed *= -1;
					//tennisBalls.ySpeed = tennisBalls.ySpeed;
					totalScore += 1;
					tennisBalls.y = tennisBalls.y-5;
					continue Loop;


				}

				else if (x >= ptr.x + 80 && x <= ptr.x + 100) {

					tennisBalls.ySpeed *= -1;
					//tennisBalls.ySpeed = tennisBalls.ySpeed;
					totalScore += 1;
					tennisBalls.y = tennisBalls.y-5;
					continue Loop;


				}

			}

		}

		// tennisBallsList = TennisBalls2;

	}

	boolean checkIfLose() {

		for (TennisBalls tennisBalls : tennisBallsList) {

			if (tennisBalls.y > RacketSmash.height) {
				tennisBallsList.remove(tennisBalls);
				tennisBallsList.clear();
				tennisBallsList = new ArrayList<TennisBalls>();
				TennisGamePanel.setCurrentState(TennisGamePanel.ENDSTATE);
				return true;

			}

			if (tennisBalls.collisionBox.intersects(ptr.collisionBox)) {

				System.out.println("It works");
				totalScore = totalScore + 1;

			}

		}

		return false;
	}

}

//
// int x = tennisBalls.x;
// int y = ptr.x;
// Random r = new Random();
// r.nextInt(RacketSmash.width);
// int rangeX = RacketSmash.width - ptr.x;
// int rangeY = ptr.y - 10;
// int z = (RacketSmash.width - tennisBalls.width) - tennisBalls.x;
// int a = z / ((RacketSmash.height - tennisBalls.y) / tennisBalls.ySpeed);
// tennisBalls.xSpeed = (((RacketSmash.width - tennisBalls.width) -
// tennisBalls.x)
// / ((RacketSmash.height - tennisBalls.y) / tennisBalls.ySpeed));
//
// if (tennisBalls.ySpeed > 0) {
//
// tennisBalls.ySpeed *= -1;
// tennisBalls.ySpeed = tennisBalls.ySpeed;
//
//
//
// }
