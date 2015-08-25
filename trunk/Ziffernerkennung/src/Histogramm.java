public class Histogramm {
	private int[] values;
	private int max = 255;

	public Histogramm(int m) {
		reset(m);
		clear();
	}

	public void reset(int m) {
		values = new int[m];
		max = m;
	}

	public void clear() {
		for (int i = 0; i < max; i++) {
			values[i] = 0;
		}
	}

	public void add(int idx) {
		if ((idx >= 0) && (idx < max)) {
			values[idx] = values[idx] + 1;
		}
	}

	public float entropy() {
		float result = 0;
		for (int i = 0; i < max; i++) {
			if (values[i] > 0) {
				result += values[i] * Math.log(values[i]);
			}
		}
		return -result;
	}

	public void draw() {
		for (int i = 0; i < max; i++) {
			PAppletBridge.line(i, PAppletBridge.height, i,
					(PAppletBridge.height - values[i]));
		}
	}
}
