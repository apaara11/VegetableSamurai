import java.awt.Color;
import java.awt.Graphics;

public class Veggies extends GameObject {

	boolean moveRight;
	boolean moveDown;

	int counter;

	Veggies(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
	}
	// ------------------------------------------------//

	public void update() {
		super.update();
		y++;
		System.out.println(y);
	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.broccoliImg, x, y, width, height, null);
		
	}
}
