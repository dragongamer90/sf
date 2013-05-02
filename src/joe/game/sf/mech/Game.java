package joe.game.sf.mech;

import java.awt.Color;
import java.awt.Graphics;

import joe.game.sf.ImageBank;

public class Game {
	
	private int width, height, mouseX, mouseY;
	Player p1, p2;
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
		p1 = new Player(1,1,1);
	}

	public void update () {
		processInput();
		applyFriction(p1);
		p1.update();
	}
	
	public void processInput() {
		if(up) {
			p1.moveUp();
		}
		if(down) {
			p1.movedown();
		}
		if(right) {
			p1.moveRight();
		}
		if(left) {
			p1.moveLeft();
		}
	}
	
	public void boom() {
		p1.applyForce(new Vector2D(-50, 1));
	}
	
	public void applyFriction(Player p) {
		Vector2D friction = new Vector2D(p.getVelocity().getX(), p.getVelocity().getY());
		friction.mult(frictionCoeff);
		p.applyForce(friction);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, width, height);
		g.drawImage(ImageBank.getImage("blue"), 
					(int)p1.getLocation().getX()-(p1.getPlayerRadius())/2,
				   (int)p1.getLocation().getY()-(p1.getPlayerRadius())/2,
				   p1.getPlayerRadius(),
				   p1.getPlayerRadius(),
				   null);
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
	 * @return the p1
	 */
	public Player getP1() {
		return p1;
	}

	/**
	 * @param p1 the p1 to set
	 */
	public void setP1(Player p1) {
		this.p1 = p1;
	}

	/**
	 * @return the p2
	 */
	public Player getP2() {
		return p2;
	}

	/**
	 * @param p2 the p2 to set
	 */
	public void setP2(Player p2) {
		this.p2 = p2;
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
