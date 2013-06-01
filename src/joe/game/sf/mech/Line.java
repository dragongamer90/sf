package joe.game.sf.mech;

public class Line {
	float m, x, c;

	public Line(float m, float x, float c) {
		super();
		this.m = m;
		this.x = x;
		this.c = c;
	}

	public float getM() {
		return m;
	}

	public void setM(float m) {
		this.m = m;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getC() {
		return c;
	}

	public void setC(float c) {
		this.c = c;
	}
}
