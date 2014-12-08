package Item;

/**
 * @author Scorpion
 *
 */
public class Object {
	public int x; 
	public int y;
	
	/**
	 * @param x
	 * @param y
	 */
	public Object(int x, int y){
		this.x = x; 
		this.y = y; 
	}
	
	/**
	 * @return double x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * @return double y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * @param x
	 * @param y
	 * @return double distance
	 */
	public double getDistance(int x, int y){
		return Math.sqrt(Math.pow(this.x-x, 2) + Math.pow(this.y-y, 2));
	}
}
