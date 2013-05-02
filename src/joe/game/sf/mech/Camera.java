package joe.game.sf.mech;


public class Camera {
	private int x, y, xBounds, yBounds, lx, ly, width, height, centerX, centerY;

	public Camera(int x, int y, int xBounds, int yBounds, int width, int height) {
		super();
		this.x = x;
		this.y = y;
		this.xBounds = xBounds;
		this.yBounds = yBounds;
		this.width = width;
		this.height= height;
		centerX = width / 2;
		centerY = height / 2;
	}
	
	public void update(int mouseX, int mouseY){
		lx = mouseX - centerX;
		ly = mouseY - centerY;
		lx = (int) (lx * 0.03);
		ly = (int) (ly * 0.03);
		x += lx;
		y += ly;
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
}
