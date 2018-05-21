package RacketSmash;

import java.awt.Color;
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

	public static BufferedImage imagesImg;

	public static BufferedImage tenniscourt;

	public TennisGamePanel() {

		timer = new Timer(1000 / 60, this);

		tgo = new TennisGameObject(10, 10, 100, 100);

		ptr = new PlayerTennisRacket(250, 700, 50, 50);

	}

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

	}

	void drawGAMESTATE(Graphics g) {
		
		ptr.draw(g);


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
