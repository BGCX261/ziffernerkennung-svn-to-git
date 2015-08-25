import java.util.ArrayList;

import processing.core.PVector;

class ResultList extends ArrayList<PVector> {

	public void add(int x, int y) {
		super.add(new PVector(x, y));
	}

	public void out() {
		for (PVector v : this) {
			System.out.print(v.x + "," + v.y + " : ");
		}
		System.out.println();
	}
}