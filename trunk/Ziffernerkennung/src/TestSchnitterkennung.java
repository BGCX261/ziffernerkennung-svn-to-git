import processing.core.PApplet;
import processing.core.PImage;

public class TestSchnitterkennung extends PApplet {

	private PImage img;
	private int WHITE = -1;

	float angle = 0;
	float ydiff = 0;

	ScanLineDetector sld = new ScanLineDetector();

	public void setup() {
		PAppletBridge pb = new PAppletBridge(this);
		size(400, 300);
		// size (1000, 700, P3D);
		// size (1000, 700);
		img = loadImage("nine-01.png");
	}

	public void draw() {
		background(255);

		pushMatrix();
		translate(width / 2, height / 2);
		rotate(radians(angle));

		pushStyle();
		translate(-img.width / 2, -img.height / 2);
		scale(3);
		image(img, 0, 0);

		// binarisieren
		filter(THRESHOLD, 0.574f);
		// filter(ERODE);

		popStyle();
		popMatrix();

		BoundingBox bb = (new BoundingBox(0, 0, width, height));
		bb.minimize();
		sld = new ScanLineDetector(bb);
		ResultList res = sld.getFeatures();
		// bb.draw();
		res.out();

		// int val = sld.scanCrossings(0, int(mouseY+ydiff), width,
		// int(mouseY-ydiff));
		int val = sld.scanCrossings(mouseX, 0, mouseX, height);

		// Anzahl uebergaenge
		fill(0);
		text(val + "", mouseX, mouseY);

		// angle = map (mouseX, 0, width, -180, 180);
		ydiff = map(mouseY, 0, height, 0, height);
	}

	public void keyPressed() {

		// 0

		if (key == '1') {
			img = loadImage("one-01.png");
		}

		if (key == '2') {
			img = loadImage("two-01.png");
		}

		if (key == '3') {
			img = loadImage("three-01.png");
		}

		if (key == '4') {
			img = loadImage("four-01.png");
		}

		if (key == '5') {
			img = loadImage("five-01.png");
		}

		if (key == '6') {
			img = loadImage("six-01.png");
		}

		// 7 und 8

		if (key == '9') {
			img = loadImage("nine-01.png");
		}
	}

	static public void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "TestSchnitterkennung" };
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
	}
}
