package joe.game.sf.mech;

public class Player {
	private Vector2D accelaration, velocity, location, direction;
	private float walkAcc, directionAngle, turnSpeed, pi2;
	private int playerRadius;
	private boolean dead;
	
	public Player(int health, int x, int y) {
		direction = new Vector2D(1, 0);
		location = new Vector2D(x, y);
		velocity = new Vector2D(0, 0);
		accelaration = new Vector2D(0, 0);
		pi2 = (float) (Math.PI*2);
		walkAcc = 0.4f;
		directionAngle = 1;
		turnSpeed = 0.2f;
		this.playerRadius = 50;
	}
	
	/**
	 * updates the players position and resets the accelaration
	 */
	public void update() {
		velocity.add(accelaration);
		location.add(velocity);
		accelaration.mult(0);
		direction.setX((float) Math.sin(directionAngle));
		direction.setY((float) Math.cos(directionAngle));
		direction.normalize();
	}
	
	/**
	 * shoots a bullet straight in the direction of the player
	 * @param players
	 */
	public void shoot (Player[] players, int self) {
		for(int i=0; i<players.length; i++) {
			Vector2D intersection = Vector2D.lineCircle(location, Vector2D.add(location, Vector2D.mult(direction, 10)), players[i].getLocation(), players[i].getPlayerRadius());
			if(intersection != null && i!=self){
				players[i].die();
				System.out.format("%f, %f\n", intersection.getX(), intersection.getY());
			}
		}
	}
	
	public void die() {
		setDead(true);
	}
	
	/**
	 * accelarates the player along the force vector
	 * @param force
	 */
	public void applyForce(Vector2D force) {
		Vector2D f = Vector2D.div(force, 1);
		accelaration.add(f);
	}

	/**
	 * @return the accelaration
	 */
	public Vector2D getAccelaration() {
		return accelaration;
	}

	/**
	 * @param accelaration the accelaration to set
	 */
	public void setAccelaration(Vector2D accelaration) {
		this.accelaration = accelaration;
	}

	/**
	 * @return the velocity
	 */
	public Vector2D getVelocity() {
		return velocity;
	}

	/**
	 * @param velocity the velocity to set
	 */
	public void setVelocity(Vector2D velocity) {
		this.velocity = velocity;
	}

	/**
	 * @return the location
	 */
	public Vector2D getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Vector2D location) {
		this.location = location;
	}

	public void moveUp() {
		this.applyForce(new Vector2D(0, -walkAcc));
	}

	public void moveRight() {
		this.applyForce(new Vector2D(walkAcc, 0));
	}

	public void movedown() {
		this.applyForce(new Vector2D(0, walkAcc));
	}

	public void moveLeft() {
		this.applyForce(new Vector2D(-walkAcc, 0));
	}
	
	public void turnLeft() {
		directionAngle -= turnSpeed;
		if(directionAngle < 0) {
			directionAngle = pi2;
		}
	}
	
	public void turnRight() {
		directionAngle += turnSpeed;
		if(directionAngle > pi2) {
			directionAngle = 0;
		}
	}

	/**
	 * @return the walkAcc
	 */
	public float getWalkAcc() {
		return walkAcc;
	}

	/**
	 * @param walkAcc the walkAcc to set
	 */
	public void setWalkAcc(float walkAcc) {
		this.walkAcc = walkAcc;
	}

	/**
	 * @return the playerRadius
	 */
	public int getPlayerRadius() {
		return playerRadius;
	}

	/**
	 * @param playerRadius the playerRadius to set
	 */
	public void setPlayerRadius(int playerRadius) {
		this.playerRadius = playerRadius;
	}

	/**
	 * @return the direction
	 */
	public Vector2D getDirection() {
		return direction;
	}

	/**
	 * @param direction the direction to set
	 */
	public void setDirection(Vector2D direction) {
		this.direction = direction;
	}

	/**
	 * @return the dead
	 */
	public boolean isDead() {
		return dead;
	}

	/**
	 * @param dead the dead to set
	 */
	public void setDead(boolean dead) {
		this.dead = dead;
	}
	
}
