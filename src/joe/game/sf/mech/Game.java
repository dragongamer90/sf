package joe.game.sf.mech;

import java.awt.Color;
import java.awt.Graphics;

import joe.game.sf.ImageBank;

public class Game {
	
	private int width, height, mouseX, mouseY;
	Player[] players = {new Player(1,1,1), new Player(1,1,1)};
	private boolean left, right, up, down;
	private float frictionCoeff = -0.1f;
	
	/**
	 * @param width
	 * @param height
	 */
	public Game(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public void update () {
		processInput();
		applyFriction(players[0]);
		for(Player p : players) {
			p.update();
		}
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		
		for(Player p : players) {
			g.drawImage(ImageBank.getImage("blue"), 
					(int)p.getLocation().getX()-(p.getPlayerRadius())/2,
				    (int)p.getLocation().getY()-(p.getPlayerRadius())/2,
				    p.getPlayerRadius(),
				    p.getPlayerRadius(),
				    null);
		}
		
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
}
