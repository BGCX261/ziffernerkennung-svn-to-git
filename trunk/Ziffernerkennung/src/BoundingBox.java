import processing.core.PApplet;

class BoundingBox {
	private final int WHITE = -1;
	private final int BLACK = -16777216;

	public float x1, y1, x2, y2;

	public BoundingBox(int xl, int yl, int xh, int yh) {
		this(PApplet.parseFloat(xl), PApplet.parseFloat(yl), PApplet
				.parseFloat(xh), PApplet.parseFloat(yh));
	}

	public BoundingBox(BoundingBox bb) {
		this(bb.x1, bb.y1, bb.x2, bb.y2);
	}

	/**
	 * @param xl linke ecke der bounding Box
	 * @param yl
	 * @param xh
	 * @param yh
	 */
	public BoundingBox(float xl, float yl, float xh, float yh) {
		x1 = xl;
		y1 = yl;
		x2 = xh;
		y2 = yh;
	}

	// find smallest bounding box in image in region x1,y1 | x2,y1
	public void minimize() {
		int xL, yL, xH, yH;

		xL = Math.round(x2);
		yL = Math.round(y2);
		xH = PApplet.parseInt(x1);
		yH = PApplet.parseInt(y1);

		for (int x = PApplet.parseInt(x1); x <= Math.round(x2); x++) {
			for (int y = PApplet.parseInt(y1); y <= Math.round(y2); y++) {
				int val = PAppletBridge.get(x, y);
				if (val == BLACK) {
					xL = Math.min(x, xL);
					yL = Math.min(y, yL);
					xH = Math.max(x, xH);
					yH = Math.max(y, yH);
				}
			}
		}

		x1 = xL;
		y1 = yL;
		x2 = xH;
		y2 = yH;
	}

	public int nextVerticalCut() {
		int x = PApplet.parseInt(x1) + 1;
		int val = scanVertical(x);
		while ((val != -1) && x < (x2)) {
			val = scanVertical(x);
			x++;
		}
		if (x < x2) {
			return x - 1;
		} else {
			return PApplet.parseInt(x2);
		}
	}

	public boolean hasVerticalCut() {
		return (nextVerticalCut() != PApplet.parseInt(x2));
	}

	public int nextHorizontalCut() {
		int y = PApplet.parseInt(y1) + 1;
		int val = scanHorizontal(y);
		while ((val != -1) && y < (y2)) {
			val = scanHorizontal(y);
			y++;
		}
		if (y < y2) {
			return y - 1;
		} else {
			return PApplet.parseInt(y2);
		}
	}

	public boolean hasHorizontalCut() {
		return (nextHorizontalCut() != PApplet.parseInt(y2));
	}

	private int scanHorizontal(int y) {
		for (int x = PApplet.parseInt(x1); x < PApplet.parseInt(x2); x++) {
			int val = PAppletBridge.get(x, y);
			if (val == BLACK) {
				return x;
			}
		}
		return -1;
	}

	private int scanVertical(int x) {
		for (int y = PApplet.parseInt(y1); y < PApplet.parseInt(y2); y++) {
			int val = PAppletBridge.get(x, y);
			if (val == BLACK) {
				return y;
			}
		}
		return -1;
	}

	public void draw() {
		PAppletBridge.pushStyle();
		PAppletBridge.stroke(0xffff0000);
		PAppletBridge.noFill();

		PAppletBridge.ellipse(x1, y1, 5, 5);
		PAppletBridge.ellipse(x2, y2, 5, 5);

		PAppletBridge.rect(x1, y1, (x2 - x1), (y2 - y1));
		PAppletBridge.popStyle();
	}
}
