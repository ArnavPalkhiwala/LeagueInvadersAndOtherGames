package RacketSmash;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

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


	public static BufferedImage imagesImg;

	public static BufferedImage tenniscourt;

	public TennisGamePanel() {

		timer = new Timer(1000 / 60, this);

		tgo = new TennisGameObject(10, 10, 100, 100);

		ptr = new PlayerTennisRacket(250, 700, 50, 50);
		
		titleFont = new Font("Arial", Font.PLAIN, 48);

		subtitleFont = new Font("Arial", Font.PLAIN, 24);

		subtitle2Font = new Font("Arial", Font.PLAIN, 24);

		gameOver = new Font("Arial", Font.PLAIN, 48);

		enemies = new Font("Arial", Font.PLAIN, 24);

		subtitle = new Font("Arial", Font.PLAIN, 24);

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
		

		g.drawImage(tenniscourt, 0, 0, RacketSmash.width, RacketSmash.height, null);
		
		g.setColor(Color.RED);

		g.setFont(titleFont);

		g.drawString("Racket Smash", 25, 150);

		g.setFont(subtitleFont);

		g.setColor(Color.RED);

		g.drawString("Press ENTER to Start", 110, 300);

		g.setFont(subtitle2Font);

		g.setColor(Color.RED);

		g.drawString("Press SPACE for Instructions", 80, 450);

	}

	void drawGAMESTATE(Graphics g) {
		

	}

	void drawENDSTATE(Graphics g) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

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
