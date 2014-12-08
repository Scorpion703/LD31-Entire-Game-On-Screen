package Game;

public class Tile {
	private boolean begehbar;
	
	private int tileType;
	
	Tile(boolean begehbar, int tileType){
		this.begehbar = begehbar;
		this.tileType = tileType;
	}
	
	Tile(int tileType){
		this.begehbar = true;
		this.tileType = tileType;
	}
	
	Tile(){
		this.begehbar = true;
		this.tileType = 0;
	}

	public boolean isBegehbar() {
		return begehbar;
	}

	public void setBegehbar(boolean begehbar) {
		this.begehbar = begehbar;
	}

	public int getTileType() {
		return tileType;
	}

	public void setTileType(int tileType) {
		this.tileType = tileType;
	}
}
