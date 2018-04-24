package leagueInvaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

	Timer timer;
	JFrame frame = new JFrame();

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int CURRENT_STATE = MENU_STATE;

	Font titleFont;
	Font subtitleFont;
	Font subtitle2Font;

	Font gameOver;
	Font enemies;
	Font subtitle;

	Rocketship rs = new Rocketship(250, 700, 50, 50);

	ObjectManager om = new ObjectManager(rs);

	void updateMenuState() {

	}

	void updateGameState() {

		om.update();

	}

	void updateEndState() {

	}

	void drawMenuState(Graphics g) {

		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);

		g.setColor(Color.YELLOW);

		g.setFont(titleFont);

		g.drawString("LEAGUE INVADERS", 25, 150);

		g.setFont(subtitleFont);

		g.setColor(Color.YELLOW);

		g.drawString("Press ENTER to Start", 110, 300);

		g.setFont(subtitle2Font);

		g.setColor(Color.YELLOW);

		g.drawString("Press SPACE for Instructions", 80, 450);

	}

	void drawGameState(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);

		om.draw(g);

	}

	void drawEndState(Graphics g) {

		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.width, LeagueInvaders.height);

		g.setFont(gameOver);

		g.setColor(Color.BLACK);

		g.drawString("GAME OVER", 90, 150);

		g.setFont(enemies);

		g.setColor(Color.BLACK);

		g.drawString("You Killed __ Enemies", 110, 300);

		g.setFont(subtitle);

		g.setColor(Color.BLACK);

		g.drawString("Press ENTER to Restart", 110, 450);
	}

	@Override
	public void paintComponent(Graphics g) {

		if (CURRENT_STATE == MENU_STATE) {
			drawMenuState(g);
		}

		if (CURRENT_STATE == GAME_STATE) {
			drawGameState(g);
		}

		if (CURRENT_STATE == END_STATE) {
			drawEndState(g);
		}
		
		repaint();

	}

	public GamePanel() {

		// frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));

		timer = new Timer(1000 / 60, this);

		titleFont = new Font("Arial", Font.PLAIN, 48);

		subtitleFont = new Font("Arial", Font.PLAIN, 24);

		subtitle2Font = new Font("Arial", Font.PLAIN, 24);

		gameOver = new Font("Arial", Font.PLAIN, 48);

		enemies = new Font("Arial", Font.PLAIN, 24);

		subtitle = new Font("Arial", Font.PLAIN, 24);

	}

	void startGame() {

		timer.start();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (CURRENT_STATE == MENU_STATE) {
			updateMenuState();
		}

		if (CURRENT_STATE == GAME_STATE) {
			updateGameState();
		}

		if (CURRENT_STATE == END_STATE) {
			updateEndState();
		}

		// TODO Auto-generated method stub
		repaint();
		System.out.println("Message");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (CURRENT_STATE == MENU_STATE) {

			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				CURRENT_STATE = GAME_STATE;
			}

		}

		else if (CURRENT_STATE == GAME_STATE) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				CURRENT_STATE = END_STATE;
			}

		}

		else if (CURRENT_STATE == END_STATE) {
			if (e.getKeyChar() == KeyEvent.VK_ENTER) {
				CURRENT_STATE = MENU_STATE;
			}

		}

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			rs.updatePositionL();

		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rs.updatePositionR();

		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN) {

			rs.updatePositionU();

		}

		if (e.getKeyCode() == KeyEvent.VK_UP) {

			rs.updatePositionD();

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Wazzup");
	}
}

// http://level2.jointheleague.org/LeagueInvadersPt.8ShipObject
// http://level2.jointheleague.org/league_invaders_demo
// http://level2.jointheleague.org/league_invaders_contents
// Part 10 Step 5
