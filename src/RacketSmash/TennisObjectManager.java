package RacketSmash;

import java.awt.Graphics;
import java.util.ArrayList;

import leagueInvaders.Alien;
import leagueInvaders.Rocketship;

public class TennisObjectManager {
	
	ArrayList<TennisBalls> tennisBallsList = new ArrayList<TennisBalls>();
	
	PlayerTennisRacket ptr;
	
	public  TennisObjectManager(PlayerTennisRacket ptr) {
		
		this.ptr = ptr;

	}
	
	void draw(Graphics g){
		for (TennisBalls tb : tennisBallsList) {

			tb.draw(g);
		}
		
		
	}
	
	void update() {
		for (TennisBalls tb : tennisBallsList) {

			tb.update();
		}
		
	}



}
