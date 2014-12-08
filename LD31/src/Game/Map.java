package Game;

public class Map {
	Tile map[][];
	
	private int width;
	private int height;
	
	
	Map(){
		int width = 25;
		int height = 25;
		this.height = height;
		this.width = width;
		map = new Tile[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				Tile t = new Tile();
				if(x == 0 || y == 0 || x == width-1 || y == height-1){
					t.setTileType(0);
				}else if(x == 5 || x == width-2 || y == height-2){
					t.setTileType(0);
				}else {
					t.setTileType(0);
				}
				
				map[x][y] = t;
			}
		}
	}
	
	Map(int size){
		this.width = size;
		this.height = size;
		map = new Tile[size][size];
		for(int y = 0; y < size; y++){
			for(int x = 0; x < size; x++){
				Tile t = new Tile();
				map[x][y] = t;
			}
		}
	}
	
	
	Map(int size, boolean b){
		this.width = size;
		this.height = size;
		map = new Tile[size][size];
		for(int y = 0; y < size; y++){
			for(int x = 0; x < size; x++){
				Tile t = new Tile((int)Math.round(Math.random()*6));
				map[x][y] = t;
			}
		}
	}
	
	
	Map(int width, int height, boolean b){
		this.width = width;
		this.height = height;
		map = new Tile[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				Tile t = new Tile((int)Math.round(Math.random()*1));
				map[x][y] = t;
			}
		}
	}
	
	
	Map(int width, int height){
		this.width = width;
		this.height = height;
		map = new Tile[width][height];
		for(int y = 0; y < height; y++){
			for(int x = 0; x < width; x++){
				Tile t = new Tile();
				map[x][y] = t;
			}
		}
	}
	
	public void setTile(int x, int y, boolean begehbar, int tileType){
		map[x][y].setBegehbar(begehbar);
		map[x][y].setTileType(tileType);
	}
	
	public void setTile(int x, int y, boolean begehbar){
		map[x][y].setBegehbar(begehbar);
	}
	
	public void setTile(int x, int y, int tileType){
		map[x][y].setTileType(tileType);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
	public Tile getTile(int x, int y){
		return map[x][y];
	}
	
	
}
