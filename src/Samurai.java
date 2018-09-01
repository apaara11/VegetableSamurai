import java.awt.Color;
import java.awt.Graphics;

public class Samurai extends GameObject {

	int speed;

	Samurai(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		speed = 30;
	}

	public void update() {
		super.update();
	}

	public void draw(Graphics g) {
		 g.drawImage(GamePanel.samuraiImg, x, y, 150, 200, null);
	}
}
