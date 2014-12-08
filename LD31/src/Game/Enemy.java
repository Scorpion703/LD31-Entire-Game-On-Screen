package Game;

import org.newdawn.slick.Input;

public class Enemy extends Thread implements Runnable{
	private double x; 
	private double y; 
	
	private int health;
	
	private boolean moving;
	
	Enemy(){
		this.x = 0;
		this.y = 0;
		this.health = 100;
		this.run();
	}
	
	@Override
	public void run() {
		while(!this.isInterrupted()){
			if(this.health < 0){
				this.interrupt();
			}
			double rdm = Math.round(Math.random()*3);
			double time = Math.round(Math.random()*3)*1000;
			

			if(moving && rdm == 0){
				this.x += 1.5*delta;
			}
			if(moving && rdm == 1){
			
			}
			if(moving && rdm == 2){
			
			}
			if(moving && rdm == 3){
			
			}			
		}
	}
	
	public double getDistance(int x, int y){
		return Math.sqrt(Math.pow(this.x-x, 2) + Math.pow(this.y-y, 2));
	}
}