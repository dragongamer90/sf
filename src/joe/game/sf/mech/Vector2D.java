package joe.game.sf.mech;

public class Vector2D {
	private float x,y;

	/**
	 * @param x
	 * @param y
	 */
	public Vector2D(float x, float y) {
		super();
		this.x = x;
		this.y = y;
	}

	public static Vector2D add(Vector2D v1, Vector2D v2) {
		return new Vector2D(v1.getX() + v2.getX(), v1.getY() + v2.getY());
	}
	
	public static Vector2D div(Vector2D v1, float val) {
		return new Vector2D(v1.getX() / val, v1.getY() / val);
	}
	
	public static float dot(Vector2D v1, Vector2D v2) {
		return v1.getX() * v2.getX() + v1.getY() * v2.getY();
	}
	
	public static Vector2D mult(Vector2D v, float scala) {
		return new Vector2D(v.getX() * scala, v.getY() * scala);
	}
	
	public static Vector2D sub(Vector2D a, Vector2D b) {
		return new Vector2D(a.x - b.x, a.y - b.y);
	}
	
	public void add(Vector2D v) {
		this.x += v.getX();
		this.y += v.getY();
	}
	
	public void mult(float v) {
		this.x *= v;
		this.y *= v;
	}
	
	public float mag() {
		return (float) (Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)));
	}
	
	public void normalize() {
		x = x/mag();
		y = y/mag();
	}
	
	/**
	 * if there is an intersection, returns the point, else returns null
	 * @param start
	 * @param end
	 * @param center
	 * @param radius
	 * @return
	 */
	public static boolean lineCircle(Vector2D start, Vector2D end, Vector2D center, float radius) {
		Vector2D d = Vector2D.sub(end, start);
		Vector2D intersection;
		
		if(d.isVerticle()) {
			intersection = new Vector2D(d.x, center.y);
		}else if(d.isHorizontal()) {
			intersection = new Vector2D(center.x, d.y);
		}else {
			Vector2D p = d.perp();
			Vector2D p1, p2, p3, p4;
			p1 = start;
			p2 = end;
			p3 = center;
			p4 = Vector2D.add(center, p);
			intersection = null;
			float xNum = ((p1.x*p2.y-p1.y*p2.x)*(p3.x-p4.x))-((p1.x-p2.x)*(p3.x*p4.y-p3.y*p4.x));
			float xDenom = ((p1.x-p2.x)*(p3.y-p4.y))-((p1.y-p2.y)*(p3.x-p4.x));
			float yNum = ((p1.x*p2.y-p1.y*p2.x)*(p3.y-p4.y)) - ((p1.y-p2.y)*(p3.x*p4.y-p3.y*p4.x));
			float yDenom = ((p1.x - p2.x)*(p3.y - p4.y))-((p1.y - p2.y)*(p3.x - p4.x));
			intersection = new Vector2D(xNum / xDenom, yNum / yDenom);
		}
		
		if(intersection.dist(center) < radius) {
			return true;
		}else {
			return false;
		}
	}
	
	public Vector2D perp() {
		return new Vector2D(-y, x);
	}
	
	/**
	 * @return the x
	 */
	public float getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(float x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public float getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(float y) {
		this.y = y;
	}
	
	public boolean isVerticle () {
		if(x == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isHorizontal () {
		if(y == 0) {
			return true;
		}else {
			return false;
		}
	}

	public float dist (Vector2D v) {
		return (float) Math.sqrt(Math.pow(x-v.x, 2) + Math.pow(y-v.y, 2));
	}
}
