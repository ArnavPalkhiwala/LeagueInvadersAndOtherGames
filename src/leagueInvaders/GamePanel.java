package leagueInvaders;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{  
	

	Timer timer;
	JFrame frame = new JFrame(); 
	
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int CURRENT_STATE = MENU_STATE;
	
	void updateMenuState() {
		
	}
	
	void updateGameState() {
		
	}
	
	void updateEndState() {
		
	}
	
	void drawMenuState(Graphics g) {
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		
	}
	
	void drawGameState(Graphics g) {
		
	}
	
	void drawEndState(Graphics g) {
		
	}
	
	
	@Override
	public void paintComponent(Graphics g){
	
		
		if(CURRENT_STATE == MENU_STATE) {
			drawMenuState(g);
		}
		
		if(CURRENT_STATE == GAME_STATE) {
			drawGameState(g);
		}
		
		if(CURRENT_STATE == END_STATE) {
			drawEndState(g);
		}
		
	      	
	}
	

	public GamePanel() {
		
		//frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));

		timer = new Timer(1000 / 60, this);
		
		
		
		

	}
	
	
	void startGame() {
		
		timer.start();
		
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	if(CURRENT_STATE == MENU_STATE) {
		updateMenuState();
	}
	
	if(CURRENT_STATE == GAME_STATE) {
		updateGameState();
	}
	
	if(CURRENT_STATE == END_STATE) {
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
		System.out.println("Bye");
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Wazzup");
	}
}
