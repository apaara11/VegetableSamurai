import java.awt.Dimension;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;

	final static int WIDTH = 500;
	final static int HEIGHT = 800;
	GamePanel gamePanel;

	LeagueInvaders() {
		frame = new JFrame();
		gamePanel = new GamePanel();
	}

	public void setup() {
		frame.add(gamePanel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		frame.pack();

		gamePanel.startGame();
		frame.addKeyListener(gamePanel);
	}

	public static void main(String[] args) {
		LeagueInvaders li = new LeagueInvaders();

		li.setup();

	}
}
