package Item;

public class Coin {
	private double x; 
	private double y;
	private int wert;
	
	public Coin(double x, double y, int wert){
		this.x = x; 
		this.y = y; 
		this.wert = (int)Math.round(Math.random()*wert);
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
	public int getWert() {
		return wert;
	}
	public void setWert(int wert) {
		this.wert = wert;
	}
	
	public int getCoinWert(int x, int y){
		if(getDistance(x, y) < 15.0){
			return this.wert;
		}
		return 0;
	}
	
	public double getDistance(int x, int y){
		return Math.sqrt(Math.pow(this.x-x, 2) + Math.pow(this.y-y, 2));
	}
}
