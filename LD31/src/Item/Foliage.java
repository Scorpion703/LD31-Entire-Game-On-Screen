package Item;

public class Foliage extends Object{
	
	private int type;
	
	public Foliage(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.type = 0;
	}
	
	public Foliage(int x, int y, int type) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
