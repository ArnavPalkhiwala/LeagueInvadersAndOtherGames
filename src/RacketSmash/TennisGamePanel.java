package RacketSmash;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import leagueInvaders.LeagueInvaders;

public class TennisGamePanel extends JPanel implements ActionListener, KeyListener {

	Timer timer;
	JFrame frame;

	final int MENUSTATE = 0;
	final int GAMESTATE = 1;
	final int ENDSTATE = 2;

	int CURRRENTSTATE = MENUSTATE;

	TennisGameObject tgo;
	PlayerTennisRacket ptr;
	
	Font titleFont;
	Font subtitleFont;
	Font subtitle2Font;

	Font gameOver;
	Font enemies;
	Font subtitle;
	Font goodjob;


	public static BufferedImage imagesImg;

	public static BufferedImage tenniscourtImg;

	public TennisGamePanel() {

		timer = new Timer(1000 / 60, this);

		tgo = new TennisGameObject(10, 10, 100, 100);

		ptr = new PlayerTennisRacket(250, 700, 50, 50);
		
		titleFont = new Font("Cambria", Font.PLAIN, 48);

		subtitleFont = new Font("Cambria", Font.PLAIN, 24);

		subtitle2Font = new Font("Cambria", Font.PLAIN, 24);

		gameOver = new Font("Cambria", Font.PLAIN, 48);
		
		goodjob = new Font("Cambria", Font.PLAIN, 48);

		enemies = new Font("Cambria", Font.PLAIN, 36);

		subtitle = new Font("Cambria", Font.PLAIN, 36);try {

		tenniscourtImg = ImageIO.read(this.getClass().getResourceAsStream("tenniscourt.png"));
		


		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		

	}

	public void paintComponent(Graphics g) {

		if (CURRRENTSTATE == MENUSTATE) {
			drawMENUSTATE(g);
		}

		if (CURRRENTSTATE == GAMESTATE) {
			drawGAMESTATE(g);
		}

		if (CURRRENTSTATE == ENDSTATE) {
			drawENDSTATE(g);
		}
		
		ptr.draw(g);

		repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		tgo.update();
		repaint();
		
		 if(CURRRENTSTATE == MENUSTATE){
             updateMENUSTATE();
     }
		 else if(CURRRENTSTATE == GAMESTATE){
             updateGAMESTATE();
     }
		 else if(CURRRENTSTATE == ENDSTATE){
             updateENDSTATE();
     }

	}

	void startGame() {
		timer.start();
	}

	void updateMENUSTATE() {

	}

	void updateGAMESTATE() {

	}

	void updateENDSTATE() {

	}

	void drawMENUSTATE(Graphics g) {
		

		g.drawImage(tenniscourtImg, -500, 0, 2000, 3500, null);
		
		g.setColor(Color.BLACK);

		g.setFont(titleFont);

		g.drawString("Welcome to Racket Smash", 150, 150);

		g.setFont(subtitleFont);

		g.setColor(Color.BLACK);

		g.drawString("If you know how to play, press ENTER to begin", 215, 400);

		g.setFont(subtitle2Font);

		g.setColor(Color.BLACK);

		g.drawString("If you need the instructions, press SPACE", 245, 550);

	}

	void drawGAMESTATE(Graphics g) {
		

	}

	void drawENDSTATE(Graphics g) {
		
		g.drawImage(tenniscourtImg, -500, 0, 2000, 3500, null);

		g.setColor(Color.RED);

		g.setFont(gameOver);

		g.setColor(Color.BLACK);

		g.drawString("GAME OVER: You Died", 245, 150);
		
		g.setColor(Color.BLACK);
		
		g.drawString("Great Job!", 345, 340);
		
		g.setFont(enemies);

		g.setColor(Color.BLACK);

		g.drawString("You Killed __ Enemies", 310, 450);

		g.setFont(subtitle);

		g.setColor(Color.BLACK);

		g.drawString("Press ENTER to Restart", 325, 550);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
		if (CURRRENTSTATE == MENUSTATE) {
	
		
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			
			CURRRENTSTATE = GAMESTATE;
			
		}
		
		}
		
		else if (CURRRENTSTATE == GAMESTATE) {
			
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				
				CURRRENTSTATE = ENDSTATE;
				
			}
			
			}
		
		else if (CURRRENTSTATE == ENDSTATE) {
			
			
			if (e.getKeyCode() == KeyEvent.VK_ENTER) {
				
				CURRRENTSTATE = MENUSTATE;
				
			}
			
			}



		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			ptr.updatePositionL();

		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			ptr.updatePositionR();

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			ptr.updatePositionD();

		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {

			ptr.updatePositionU();

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
