package joe.game.sf.mech;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import joe.game.sf.ImageBank;

public class Game {
	
	private int width, height, mouseX, mouseY;
	Player[] players = {new Player(1,1,1), new Player(1,1,1)};
	private boolean left, right, up, down, turnRight, turnLeft;
	private float frictionCoeff = -0.1f;
	private BufferedImage cameraBuffer;
	private Graphics cameraGraphics;
	private int mapWidth, mapHeight;
	private Camera camera;
	
	/**
	 * @param width
	 * @param height
	 */
	public Game(int width, int height) {
		super();
		mapWidth = 1000;
		mapHeight = 1000;
		this.width = width;
		this.height = height;
		cameraBuffer = new BufferedImage(mapWidth, mapHeight, BufferedImage.TYPE_INT_ARGB);
		cameraGraphics = cameraBuffer.getGraphics();
		camera = new Camera((int)players[0].getLocation().getX() - 500, (int)players[0].getLocation().getY() - 500, 1000, 1000, width, height);
	}

	public void update () {
		processInput();
		applyFriction(players[0]);
		for(Player p : players) {
			p.update();
		}
		camera.update((int)players[0].getLocation().getX() - camera.getWidth()/2, (int)players[0].getLocation().getY() - camera.getHeight()/2);
	}
	
	public void processInput() {
		if(up) {
			players[0].moveUp();
		}
		if(down) {
			players[0].movedown();
		}
		if(right) {
			players[0].moveRight();
		}
		if(left) {
			players[0].moveLeft();
		}
		if(turnLeft) {
			players[0].turnLeft();
		}
		if(turnRight) {
			players[0].turnRight();
		}
	}
	
	public void boom() {
		players[0].applyForce(new Vector2D(-50, 1));
	}
	
	public void applyFriction(Player p) {
		Vector2D friction = new Vector2D(p.getVelocity().getX(), p.getVelocity().getY());
		friction.mult(frictionCoeff);
		p.applyForce(friction);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		cameraGraphics.setColor(Color.BLACK);
		cameraGraphics.fillRect(0, 0, width, height);
		
		for(Player p : players) {
			if(!p.isDead()) {
				cameraGraphics.drawImage(ImageBank.getImage("blue"), //the image is twice the XxY as the actual circle
						(int)p.getLocation().getX()-(p.getPlayerRadius()*2)/2,
					    (int)p.getLocation().getY()-(p.getPlayerRadius()*2)/2,
					    p.getPlayerRadius()*2,
					    p.getPlayerRadius()*2,
					    null);
				
				cameraGraphics.setColor(Color.WHITE);
				cameraGraphics.drawLine((int)p.getLocation().getX(),
						   (int)p.getLocation().getY(), 
						   (int)p.getLocation().getX() + (int)(p.getDirection().getX()*20), 
						   (int)p.getLocation().getY() + (int)(p.getDirection().getY()*20));
				g.drawImage(cameraBuffer, 0, 0, width, height, camera.getX(), camera.getY(),
							camera.getX() + camera.getWidth(), camera.getY() + camera.getHeight(), null);
			}
		}
	}
	
	public void shoot() {
		players[0].shoot(players, 0);
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/**
	 * @return the mouseX
	 */
	public int getMouseX() {
		return mouseX;
	}

	/**
	 * @param mouseX the mouseX to set
	 */
	public void setMouseX(int mouseX) {
		this.mouseX = mouseX;
	}

	/**
	 * @return the mouseY
	 */
	public int getMouseY() {
		return mouseY;
	}

	/**
	 * @param mouseY the mouseY to set
	 */
	public void setMouseY(int mouseY) {
		this.mouseY = mouseY;
	}

	/**
	 * @return the players[0]
	 */
	public Player[] getplayers() {
		return players;
	}

	/**
	 * @param players[0] the players[0] to set
	 */
	public void setplayers(Player[] players) {
		this.players = players;
	}
	
	/**
	 * @return the left
	 */
	public boolean isLeft() {
		return left;
	}

	/**
	 * @param left the left to set
	 */
	public void setLeft(boolean left) {
		this.left = left;
	}

	/**
	 * @return the right
	 */
	public boolean isRight() {
		return right;
	}

	/**
	 * @param right the right to set
	 */
	public void setRight(boolean right) {
		this.right = right;
	}

	/**
	 * @return the up
	 */
	public boolean isUp() {
		return up;
	}

	/**
	 * @param up the up to set
	 */
	public void setUp(boolean up) {
		this.up = up;
	}

	/**
	 * @return the down
	 */
	public boolean isDown() {
		return down;
	}

	/**
	 * @param down the down to set
	 */
	public void setDown(boolean down) {
		this.down = down;
	}

	/**
	 * @return the players
	 */
	public Player[] getPlayers() {
		return players;
	}

	/**
	 * @param players the players to set
	 */
	public void setPlayers(Player[] players) {
		this.players = players;
	}

	/**
	 * @return the turnRight
	 */
	public boolean isTurnRight() {
		return turnRight;
	}

	/**
	 * @param turnRight the turnRight to set
	 */
	public void setTurnRight(boolean turnRight) {
		this.turnRight = turnRight;
	}

	/**
	 * @return the turnLeft
	 */
	public boolean isTurnLeft() {
		return turnLeft;
	}

	/**
	 * @param turnLeft the turnLeft to set
	 */
	public void setTurnLeft(boolean turnLeft) {
		this.turnLeft = turnLeft;
	}

	/**
	 * @return the frictionCoeff
	 */
	public float getFrictionCoeff() {
		return frictionCoeff;
	}

	/**
	 * @param frictionCoeff the frictionCoeff to set
	 */
	public void setFrictionCoeff(float frictionCoeff) {
		this.frictionCoeff = frictionCoeff;
	}
}
