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
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
	OpponentRacket OR;
	TennisObjectManager tom = new TennisObjectManager(ptr);

	Font titleFont;
	Font subtitleFont;
	Font subtitle2Font;

	Font gameOver;
	Font enemies;
	Font subtitle;
	Font goodjob;

	public static BufferedImage imagesImg;

	public static BufferedImage tenniscourtImg;

	public static BufferedImage TC;

	public TennisGamePanel() {

		timer = new Timer(1000 / 60, this);

		tgo = new TennisGameObject(10, 10, 100, 100);

		ptr = new PlayerTennisRacket(RacketSmash.width / 2 - 20, RacketSmash.height - 1150, 50, 50);

		OR = new OpponentRacket(RacketSmash.width / 2, 15, 15, 50);

		titleFont = new Font("Cambria", Font.PLAIN, 48);

		subtitleFont = new Font("Cambria", Font.PLAIN, 24);

		subtitle2Font = new Font("Cambria", Font.PLAIN, 24);

		gameOver = new Font("Cambria", Font.PLAIN, 48);

		goodjob = new Font("Cambria", Font.PLAIN, 48);

		enemies = new Font("Cambria", Font.PLAIN, 36);

		subtitle = new Font("Cambria", Font.PLAIN, 36);
		
		try {

			tenniscourtImg = ImageIO.read(this.getClass().getResourceAsStream("tenniscourt.png"));

			TC = ImageIO.read(this.getClass().getResourceAsStream("Tennis_court.jpg"));

		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}
		
		startGame();

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

		repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		tgo.update();
		repaint();

		if (CURRRENTSTATE == MENUSTATE) {
			updateMENUSTATE();
		} else if (CURRRENTSTATE == GAMESTATE) {
			updateGAMESTATE();
		} else if (CURRRENTSTATE == ENDSTATE) {
			updateENDSTATE();
		}

	}

	void startGame() {
		timer.start();
	}

	void updateMENUSTATE() {

	}

	void updateGAMESTATE() {
		
		tom.manageTennisBalls();
		tom.update();

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

		g.drawImage(TC, 0, 0, RacketSmash.width, RacketSmash.height, null);
		ptr.draw(g);
		OR.draw(g);
		tom.draw(g);
	}

	void drawENDSTATE(Graphics g) {

		g.drawImage(tenniscourtImg, -500, 0, 2000, 3500, null);

		g.setColor(Color.RED);

		g.setFont(gameOver);

		g.setColor(Color.BLACK);

		g.drawString("GAME OVER: You Died", 245, 150);

		g.setColor(Color.BLACK);

		g.drawString("Great Job!", 360, 340);

		g.setFont(enemies);

		g.setColor(Color.BLACK);

		g.drawString("You Killed __ Enemies", 292, 450);

		g.setFont(subtitle);

		g.setColor(Color.BLACK);

		g.drawString("Press ENTER to Restart", 280, 550);

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
				Random ran = new Random();
				int x = ran.nextInt(1001);
//				tom.tennisBallsList.add(new TennisBalls(x,0,50,50));

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

		if (CURRRENTSTATE == MENUSTATE) {

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {

				JOptionPane.showMessageDialog(null,
						"Racket Smash is a game where the player must hit the tennis balls that appear in the top of the screen "
						+ "(and move down) with the player’s tennis racket. Once you bounce the tennis ball onto the other racket at"
						+ " the top of the screen, you get a point. Try to get as many points as you can!");

			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
