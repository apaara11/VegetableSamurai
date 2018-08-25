import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocketship;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score = 0;

	
	ArrayList<Aliens> aliens = new ArrayList<Aliens>();

	ObjectManager(Rocketship object) {
		rocketship = object;

	}
	
	public int getScore() {
		System.out.println(this.score);
		return this.score;
	}

	public void update() {
		rocketship.update();
		
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).update();
		}
	}

	public void draw(Graphics g) {
		rocketship.draw(g);
		
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
	}

	
	

	public void addAliens(Aliens object) {
		aliens.add(object);
	}

	public void checkCollision() {
		for (int j = 0; j< aliens.size(); j++) {
			
				//projectiles.get(i);
				//if( aliens.get(j).collisionBox.intersects(projectiles.get(i).collisionBox)) {
					aliens.get(j).isAlive = false;
					//projectiles.get(i).isAlive = false;
					score++;
					//System.out.println(score);
				}
			}
			//if (rocketship.collisionBox.intersects(a.collisionBox)) {
			//	rocketship.isAlive = false;
			
	
		
	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addAliens(new Aliens(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));

			enemyTimer = System.currentTimeMillis();
		}
	}

	public void purgeObjects() {
		
		for (int i = 0; i < aliens.size(); i++) {
			if (!aliens.get(i).isAlive) {
				aliens.remove(i);
			}
		}
	}
		
	}
	
	


