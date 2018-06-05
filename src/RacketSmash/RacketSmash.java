package RacketSmash;

import java.awt.Dimension;

import javax.swing.JFrame;



public class RacketSmash extends TennisGamePanel{
	
	JFrame frame;
	
	TennisGamePanel tgp;
	
	final static int width = 1000;
	
	final static int height = 2000;
	
	public RacketSmash() {
		
		frame = new JFrame();
		
		tgp = new TennisGamePanel();
		
		
		
	}

	public static void main(String[] args) {
		
		RacketSmash rs = new RacketSmash();
		rs.setupWindow();
		
	}
	
	void setupWindow () {
		
		frame.setSize(1000,2000);
		
		frame.add(tgp);
		frame.addKeyListener(tgp);

		frame.getContentPane().setPreferredSize(new Dimension(1000,3500));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
		
		

		
		
	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub
		
	}

}
