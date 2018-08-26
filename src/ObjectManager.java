import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Samurai samurai;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score = 0;

	
	ArrayList<Veggies> veggies = new ArrayList<Veggies>();

	ObjectManager(Samurai object) {
		samurai = object;

	}
	
	public int getScore() {
		System.out.println(this.score);
		return this.score;
	}

	public void update() {
		samurai.update();
		//System.out.println(veggies.size());
		for (int i = 0; i < veggies.size(); i++) {
			veggies.get(i).update();
			System.out.println("update veggies");
		}
	}

	public void draw(Graphics g) {
		samurai.draw(g);
		System.out.println("blah");
		for (int i = 0; i < veggies.size(); i++) {
			veggies.get(i).draw(g);
		}
	}

	
	

	public void addVeggies(Veggies object) {
		veggies.add(object);
		System.out.println(veggies.size());
	}

	public void checkCollision() {
		for (int j = 0; j< veggies.size(); j++) {
			
				//projectiles.get(i);
				if( veggies.get(j).collisionBox.intersects(samurai.collisionBox)) {
					veggies.get(j).isAlive = false;
					//projectiles.get(i).isAlive = false;
					score++;
					//System.out.println(score);
				}
				
			}
			//if (rocketship.collisionBox.intersects(a.collisionBox)) {
			//	rocketship.isAlive = false;
			
	}
		
	public void manageEnemies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addVeggies(new Veggies(new Random().nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
System.out.println("add enemy");
			enemyTimer = System.currentTimeMillis();
		}
	}

	public void purgeObjects() {
		
		for (int i = 0; i < veggies.size(); i++) {
			if (!veggies.get(i).isAlive) {
				veggies.remove(i);
			}
		}
	}
		
	}
	
	


