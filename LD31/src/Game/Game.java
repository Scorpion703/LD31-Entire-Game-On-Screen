package Game;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.Animation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

import Item.Coin;
import Item.Foliage;

public class Game extends BasicGame{
	
	static String title = "Flubbing Flub";
	
	private static int T_SIZE = 32;
	
	private static int WIDTH = T_SIZE*30;
	private static int HEIGHT = T_SIZE*25;
	
	private static int MAXFPS;
	
	Player player;
	private double moveSpeed = 0.15;
	
	//For animation
	private Animation sprite , front, left, right, back;
	
	//textures
	private Image texture, grass, sand, water, topTile, brick, floor;
	
	//items
	private Image foliage, blume1, blume2, blume3, tree;
	
	//sound
	Sound pickCoin, hit, hurt, explosion;
	
	Map m;
	
	ArrayList<Coin> obj = new ArrayList<>();
	ArrayList<Foliage> foliageList = new ArrayList<>();
	
	String button;
	
	private Sound sound;
	
	
	
	public Game(String title){
		super(title);
	}
	
	public static void main(String args[]){
		try{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new Game(title));
			appgc.setDisplayMode(WIDTH, HEIGHT, false);
			appgc.setTargetFrameRate(MAXFPS);
			appgc.setShowFPS(true);
			appgc.setVSync(false);
			appgc.start();
		}catch(SlickException e){
			Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, e);
		}
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		Image img;
		for(int y = 0; y < m.getHeight(); y++){
			for(int x = 0; x < m.getWidth(); x++){
				if(m.getTile(x, y).getTileType() == 0){
					texture = grass;	
				}
				if(m.getTile(x, y).getTileType() == 1){
					texture = sand;
				}
				
				if(m.getTile(x, y).getTileType() == 2){
					texture = brick;
				}
				if(m.getTile(x, y).getTileType() == 3){
					texture = topTile;
				}
				if(m.getTile(x, y).getTileType() == 4){
					texture = water;
				}
				if(m.getTile(x, y).getTileType() == 5){
					texture = floor;
				}
				texture.setFilter(Image.FILTER_NEAREST);
				texture.draw(x * T_SIZE, y * T_SIZE, 4);
			}
		}
		
		//DISPLAY LIST##########################
		//COIN
		img = new Image("res/item/coin.png");
		img.setFilter(Image.FILTER_NEAREST);
		for(int i = 0; i < obj.size(); i++){
			img.draw((float)obj.get(i).getX(), (float)obj.get(i).getY(),2);
			
			if(obj.get(i).getDistance((int)player.getX(), (int)player.getY()) <= 16){
				player.setMoney(player.getMoney()+obj.get(i).getWert());
				sound = pickCoin;
				sound.play();
				obj.remove(i);
			}
		}
		
		for(int i = 0; i < foliageList.size(); i++){
			if(foliageList.get(i).getType()!= 0){
				if(foliageList.get(i).getType() == 1){
					foliage = blume1;
				}
				if(foliageList.get(i).getType() == 2){
					foliage = blume2;
				}
				if(foliageList.get(i).getType() == 3){
					foliage = blume3;
				}
				foliage.setFilter(Image.FILTER_NEAREST);
				foliage.draw(foliageList.get(i).getX(), foliageList.get(i).getY(), 4);
			}
		}
		
		//##############PLAYER#########################
		sprite.draw((float)player.getX()-16, (float)player.getY()-16, 32, 32);
		g.setColor(Color.yellow);
		g.drawRect((float)player.getX(), (float)player.getY(), 2, 2);
		//#############################################
		
		//FOLIAGE
		for(int i = 0; i < foliageList.size(); i++){
			if(foliageList.get(i).getType() == 0){
			
				if(foliageList.get(i).getType() == 0){
					foliage = tree;
				}
				foliage.setFilter(Image.FILTER_NEAREST);
				foliage.draw(foliageList.get(i).getX(), foliageList.get(i).getY(), 4);
			}
		}
		
		
		for(int i = 0; i < foliageList.size(); i++){
			g.setColor(Color.blue);
			g.drawRect(foliageList.get(i).getX(), foliageList.get(i).getY(), 2, 2);
		}
		
		g.setColor(Color.white);
		String str = "\n\n mX: "+Mouse.getX()+ " mY: "+-(Mouse.getY()-HEIGHT) + "\n Button:"+button+
				"\n Obj: "+ obj.size()+ 
				"\n\n\n pPos("+Math.round(player.getX()) +" | "+ Math.round(player.getY()) + ")"+
				" \n Money: "+ player.getMoney()+ " $"+
				" \n Leben: "+ player.getHealth();
		g.drawString(str, 0, 0);
		
		g.setColor(Color.red);
		g.drawRect((Mouse.getX()/T_SIZE)*T_SIZE, (-(Mouse.getY()-HEIGHT)/T_SIZE)*T_SIZE, T_SIZE, T_SIZE);
	}
 
	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		Input.disableControllers();
		m = new Map(WIDTH/T_SIZE, HEIGHT/T_SIZE);
//		m = new Map();
		player = new Player(200, 50);
		fuelleFoliageList(50);
		
		Image[] moveLeft = {new Image("res/player/left_1.png"), new Image("res/player/left_2.png")};
		Image[] moveRight = {new Image("res/player/right_1.png"), new Image("res/player/right_2.png")};
		Image[] moveBack = {new Image("res/player/back_1.png"), new Image("res/player/back_2.png")};
		Image[] doNothing = {new Image("res/player/idle_1.png"), new Image("res/player/idle_2.png")};
		int [] duration = {200, 200};
		
		left = new Animation(moveLeft, duration, false);
		right = new Animation(moveRight, duration, false);
		front = new Animation(doNothing, duration, false);
		back = new Animation(moveBack, duration, false);
		
		this.sprite = front;
	
		grass 	= new Image("res/texture/grass.png");
		sand 	= new Image("res/texture/sand.png");
		water	= new Image("res/texture/water.png");
		brick 	= new Image("res/texture/brick_wall.png");
		topTile = new Image("res/texture/topTile.png");
		floor 	= new Image("res/texture/floorTile.png");
		
		texture = grass;
		
		blume1 	= new Image("res/item/blume1.png");
		blume2 	= new Image("res/item/blume2.png");
		blume3 	= new Image("res/item/blume3.png");
		tree	= new Image("res/item/pineTree.png");
		
		foliage = tree;
		
		
		pickCoin 	= new Sound("res/sound/pickCoin.wav");
		hit 		= new Sound("res/sound/hit.wav");
		hurt		= new Sound("res/sound/hurt.wav");
		explosion	= new Sound("res/sound/explosion.wav");
		this.sound = pickCoin;
	}

	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		// TODO Auto-generated method stub
		control(gc, delta);
	}

	public void control(GameContainer gc, int delta) {
		// TODO Auto-generated method stub
		Input input = gc.getInput();
		if(input.isKeyDown(Input.KEY_S)){
			button = "KEY_S";
			sprite = front;
			sprite.update(delta);
			if(player.getY() < HEIGHT-16){ 
				player.setY(player.getY()+moveSpeed*delta);
			}
			else{
			}
		}
		
		if(input.isKeyDown(Input.KEY_W)){
			button = "KEY_W";
			sprite = back;
			sprite.update(delta);
			if(player.getY() > 16){
				player.setY(player.getY()-moveSpeed*delta);
			}
		}
		
		if(input.isKeyDown(Input.KEY_A)){
			button = "KEY_A";
			sprite = left;
			sprite.update(delta);
			if(player.getX() > 16){
				player.setX(player.getX()-moveSpeed*delta);
			}
		}
		
		if(input.isKeyDown(Input.KEY_D)){
			button = "KEY_D";
			sprite = right;
			sprite.update(delta);
			if(player.getX() < WIDTH-16){
				player.setX(player.getX()+moveSpeed*delta);
			}
		}
		
		if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)){
			button = "MOUSE_LEFT";
		}
		
		if(input.isMouseButtonDown(Input.MOUSE_RIGHT_BUTTON)){
			button = "MOUSE_RIGHT";
		}
		
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
			Coin co = new Coin(Mouse.getX(), -(Mouse.getY()-HEIGHT), 10);
			obj.add(co);
		}
		
		if(input.isMousePressed(Input.MOUSE_RIGHT_BUTTON)){
			player.setDamage((int)Math.round(Math.random()*20));
			sound = hurt;
			sound.play();
		}
		
		if(input.isKeyPressed(Input.KEY_ESCAPE) || input.isKeyPressed(Input.KEY_F12)){
			gc.setForceExit(true);
			System.exit(0);
		}
		
		if(input.isKeyPressed(Input.KEY_F10)){
			obj.clear();
			
		}
		
	}
	
	/**
	 * Füllt die Liste mit Zufallsgenerierten Positionen mit je nach dem Blumen oder Bäumen.
	 */
	public void fuelleFoliageList(int anz){
		int posX = 0, posY = 0, wert = 0;
		double rdm = 0.0d;
		Foliage f;
		for(int i = 0; i < anz; i++){
			posX = (int)Math.round(Math.random()*WIDTH);
			posY = (int)Math.round(Math.random()*HEIGHT);
			rdm = Math.random();
			if(rdm < 0.2){
				wert = 1;
			}else if(rdm < 0.4){
				wert = 2;
			}else if( rdm < 0.6){
				wert = 3;
			}else{
				wert = 0;
			}
			
			f = new Foliage(posX, posY, wert);
			foliageList.add(f);
		}
	}
	
}
