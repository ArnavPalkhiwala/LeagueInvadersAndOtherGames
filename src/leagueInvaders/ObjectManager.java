package leagueInvaders;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {

	ArrayList<Projectile> projectilesList = new ArrayList<Projectile>();

	ArrayList<Alien> aliensList = new ArrayList<Alien>();

	Rocketship rs;

	int enemyTimer = 0;

	int enemySpawnTime = 750;

	public ObjectManager(Rocketship rs) {

		this.rs = rs;
	}

	void update() {

		for (Projectile pL : projectilesList) {

			pL.update();

		}

		for (Alien a : aliensList) {

			a.update();
		}

	}

	void addProjectile(Projectile p) {

		projectilesList.add(p);

	}

	void Alien(Alien a) {

		aliensList.add(a);

	}

	void draw(Graphics g) {

		for (Projectile pjL : projectilesList) {

			pjL.draw(g);

		}

		for (Alien al : aliensList) {

			al.draw(g);
		}

	}

	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			Alien(new Alien(new Random().nextInt(LeagueInvaders.width), 0, 50, 50));

			enemyTimer = (int) System.currentTimeMillis();
		}
	}

	void purgeObjects() {
		
		for (Alien alien : aliensList) {
			
			if (alien.isAlive) {
				
			}
			
		}

	}

}
