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
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;

	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;

	int currentState = MENU_STATE;

	Font titleFont;
	Font bodyFont;

	Rocketship rocketship;

	ObjectManager objectManager;

	public static BufferedImage alienImg;
	public static BufferedImage rocketImg;
	public static BufferedImage bulletImg;
	public static BufferedImage spaceImg;

	////////////////////////////////// constructor
	GamePanel() {
		timer = new Timer(1000 / 60, this);
		titleFont = new Font("Arial", Font.PLAIN, 48);
		bodyFont = new Font("Arial", Font.PLAIN, 32);
		rocketship = new Rocketship(250, 700, 50, 50);
		objectManager = new ObjectManager(rocketship);

		try {

			alienImg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketImg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletImg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
			spaceImg = ImageIO.read(this.getClass().getResourceAsStream("space.png"));
		} catch (IOException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();
		}

	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		objectManager.update();
		objectManager.manageEnemies();
		objectManager.checkCollision();
		objectManager.purgeObjects();

		if (rocketship.isAlive == false) {
			currentState = END_STATE;
		}

	}

	public void updateEndState() {

	}

	public void drawMenuState(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

		g.setColor(Color.DARK_GRAY);
		g.setFont(titleFont);
		g.drawString("VEGETABLE ", 70, 105);
		g.drawString("SAMURAI", 90, 160);

		g.setColor(Color.DARK_GRAY);
		g.setFont(bodyFont);
		g.drawString("Press ENTER to start", 65, 205);

		g.setColor(Color.DARK_GRAY);
		g.setFont(bodyFont);
		g.drawString("You are alone in the jungle...", 65, 405);
		g.drawString(" and are surrounded by a ", 65, 450);
		g.drawString(" child's worst nightmare.", 65, 500);
		g.drawString(" VEGETABLES!", 65, 550);
		
		g.drawString("Move the samurai so that its",20, 650);
		g.drawString(" sword touches the vegetables", 20, 700);
		g.drawString("and slices them", 20, 750);

	}

	public void drawGameState(Graphics g) {
		g.drawImage(GamePanel.spaceImg, WIDTH, HEIGHT, null);

		objectManager.draw(g);
	}

	public void drawEndState(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);

		g.setColor(Color.BLACK);
		g.setFont(titleFont);
		g.drawString("Game Over", 105, 105);

		g.setColor(Color.BLACK);
		g.setFont(bodyFont);
		g.drawString("Press ENTER to restart", 65, 305);

		g.drawString("You killed " + objectManager.getScore() + " enemies", 105, 355);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();

		} else if (currentState == END_STATE) {
			updateEndState();
		}
		repaint();
	}

	@Override
	public void paintComponent(Graphics g) {

		if (currentState == MENU_STATE) {
			drawMenuState(g);
			objectManager = new ObjectManager(rocketship);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}

	}

	public void startGame() {
		timer.start();
	}

	// _______________________________________________//
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("LeagueInvaders");
		

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("LeagueInvaders");
	/*	if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			} else if (currentState == END_STATE) {
				rocketship = new Rocketship(250, 700, 50, 50);
				//objectManager = new ObjectManager(rocketship);
			}
		} */

		
		

		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			rocketship.x -= rocketship.speed;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			rocketship.x += rocketship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			rocketship.y -= rocketship.speed;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			rocketship.y += rocketship.speed;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("LeagueInvaders+");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			} else if (currentState == END_STATE) {
				rocketship = new Rocketship(250, 700, 50, 50);
				
			}
		}
	}

}
