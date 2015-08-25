import processing.core.PApplet;

public class ScanLineDetector implements FeatureDetector {
	private final int WHITE = -1;

	private BoundingBox BB = null;
	private boolean drawLine = false;

	public ScanLineDetector() {
		BB = null;
	}

	public ScanLineDetector(BoundingBox bb) {
		BB = bb;
	}

	public ResultList getFeatures() {
		ResultList result = new ResultList();
		int vx1, vx2, vy1, vy2;

		vx1 = PApplet.parseInt(BB.x1);
		vy1 = PApplet.parseInt(BB.y1);
		vx2 = PApplet.parseInt(BB.x2);
		vy2 = PApplet.parseInt(BB.y2);

		if (BB != null) {
			int d1 = scanCrossings(vx1, vy1, vx2, vy2);
			int d2 = scanCrossings(vx1, vy2, vx2, vy1);
			int v1 = scanCrossings((vx1 + vx2) / 2, vy1, (vx1 + vx2) / 2, vy2);
			int h1 = scanCrossings(vx1, (vy1 + vy2) / 2, vx2, (vy1 + vy2) / 2);

			result.add(0, d1);
			result.add(1, d2);
			result.add(2, v1);
			result.add(3, h1);
		}

		return result;
	}

	// zaehlt Anzahl der Farb\u00e4nderungen entlang einer Scanlinie
	public int scanCrossings(int x1, int y1, int x2, int y2) {
		int result = 0;

		float diffx = Math.max(x1, x2) - Math.min(x1, x2);
		if (diffx != 0) { // nicht senkrechte Linien scannen

			float step = (y2 - y1) / diffx;
			float y = y1;

			// get startvalue
			int val1 = PAppletBridge.get(x1, PApplet.parseInt(y));
			if (val1 != WHITE) {
				result++;
			}

			for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
				int val = PAppletBridge.get(x, Math.round(y));
				if (val != val1) {
					val1 = val;
					result++;
				}

				y += step;
			}

			if (drawLine) {
				PAppletBridge.line(x1, y1, x2, y2);
			}

			return result / 2;
		} else {
			// senkrechter Scan
			int x = x1;
			int val1 = PAppletBridge.get(x1, Math.min(y1, y2));
			if (val1 != WHITE) {
				result++;
			}

			for (int y = Math.min(y1, y2); y < Math.max(y1, y2); y++) {
				int val = PAppletBridge.get(x, y);
				if (val != val1) {
					val1 = val;
					result++;
				}
			}

			if (drawLine) {
				PAppletBridge.line(x1, y1, x2, y2);
			}
			return (result) / 2;
		}
	}
}
