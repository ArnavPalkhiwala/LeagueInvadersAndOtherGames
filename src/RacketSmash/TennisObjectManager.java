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

	int ballSpawnTime = 2500;

	long tennisTimer = 0;

	public TennisObjectManager(PlayerTennisRacket ptr, TennisBalls tennisBalls) {

		this.ptr = ptr;
		this.tennisBalls = tennisBalls;

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

		for (TennisBalls tennisBalls : tennisBallsList) {

			if (ptr.collisionBox.intersects(tennisBalls.collisionBox)) {

				Random r = new Random();
				int rangeX = RacketSmash.width - ptr.x;
				int rangeY = ptr.y - 10;
				tennisBalls.ySpeed = -3;
				tennisBalls.xSpeed = r.nextInt(rangeX);
				tennisBalls.y = tennisBalls.ySpeed;
				tennisBalls.x = tennisBalls.xSpeed;
				System.out.println("It works");
				
				

			}

		}

	}

	void purgeObjects() {
		
			
			for (int i = 0; i < tennisBallsList.size(); i++) {
				
				if (tennisBallsList.get(i).y <= 75) {
					tennisBallsList.remove(i);
				}
				
			}
			
			
		}

	}

