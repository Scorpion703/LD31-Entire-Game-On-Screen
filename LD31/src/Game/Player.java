package Game;

public class Player {
	private double x;
	private double y; 
	
	private double health;
	
	private double attack;
	
	private int level;
	
	private int money;


	Player(){
		this.x = 0;
		this.y = 0;
		this.health = 100;
		this.attack = 1;
		this.level = 1;
		this.money = 0;
	}
	
	Player(double x, double y){
		this.x = x;
		this.y = y;
		this.health = 100;
		this.attack = 1;
		this.level = 1;
		this.money = 0;
	}
	
	Player(double x, double y, int health){
		this.x = x;
		this.y = y;
		this.health = health;
		this.attack = 1;
		this.level = 1;
		this.money = 0;
	}
	
	Player(double x, double y, int health, int attack){
		this.x = x;
		this.y = y;
		this.health = health;
		this.attack = attack;
		this.level = 1;
		this.money = 0;
	}
	
	
	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getHealth() {
		return health;
	}

	public void setHealth(double health) {
		this.health = health;
		
		if(this.health <= 0)
			this.health = 0;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	public boolean isDead(){
		if(this.health <= 0){
			this.health = 0;

			return true;
		}else{
			return false;
		}
	}
	
	public void setDamage(int dmg){
		this.health -= dmg;
		
		if(this.health <= 0)
			this.health = 0;
	}
}
