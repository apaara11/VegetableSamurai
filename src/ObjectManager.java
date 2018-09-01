import java.applet.AudioClip;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JApplet;

public class ObjectManager {
	Samurai samurai;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;
	int score = 0;
	int missed = 0;

	String sliceSound = "slice.wav";
	
	AudioClip sound = JApplet.newAudioClip(getClass().getResource("slice.wav"));
	
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
		for (int i = 0; i < veggies.size(); i++) {
			veggies.get(i).update();
			System.out.println("update veggies");
		
		
		if(veggies.get(i).isAlive && veggies.get(i).y>= VegetableSamurai.HEIGHT ) {
			veggies.get(i).isAlive = false;
			missed++;
		}
		
		if(missed==5) {
			
			
		}
		}
		}
			
		
	

	public void draw(Graphics g) {
		samurai.draw(g);
		System.out.println("blah");
		for (int i = 0; i < veggies.size(); i++) {
			veggies.get(i).draw(g);
		}
	}

	public void playSound(String fileName) {
		
		
	}
	

	public void addVeggies(Veggies object) {
		veggies.add(object);
		System.out.println(veggies.size());
	}

	public void checkCollision() {
		for (int j = 0; j< veggies.size(); j++) {
			
				
				if( veggies.get(j).collisionBox.intersects(samurai.collisionBox)) {
					veggies.get(j).isAlive = false;
					
					sound.play();
					
					score++;
				
				}
				
			}
			
	}
		
	public void manageVeggies() {
		if (System.currentTimeMillis() - enemyTimer >= enemySpawnTime) {
			addVeggies(new Veggies(new Random().nextInt(VegetableSamurai.WIDTH), 0, 50, 50));
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
	
	


