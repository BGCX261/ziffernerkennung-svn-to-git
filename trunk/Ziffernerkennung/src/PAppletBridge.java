import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PFont;
import processing.core.PGraphics;
import processing.core.PImage;
import processing.data.XML;

public class PAppletBridge {
	private static PApplet parent = null;
	public static int CORNER;
	public static int CORNERS;
	public static int CENTER;
	public static int width;
	public static int height;
	public static int LEFT;
	public static char key;
	public static int keyCode;
	public static int CODED;

	public PAppletBridge(PApplet p) {
		parent = p;
		PAppletBridge.CORNER = PConstants.CORNER;
		PAppletBridge.CORNERS = PConstants.CORNERS;
		PAppletBridge.CENTER = PConstants.CENTER;
		PAppletBridge.width = parent.width;
		PAppletBridge.height = parent.height;
		PAppletBridge.key = parent.key;
		PAppletBridge.CODED = PConstants.CODED;
		this.LEFT = PConstants.LEFT;
	}

	public static float random(int low, int high) {
		return parent.random(low, high);
	}

	public static PGraphics createGraphics(int w, int h) {
		return parent.createGraphics(w, h);
	}

	public static PImage loadImage(String filename) {
		return parent.loadImage(filename);
	}

	public static PImage createImage(int w, int h, int format) {
		return parent.createImage(w, h, format);
	}

	public static void image(PImage img, int x, int y) {
		parent.image(img, x, y);
	}

	public static void image(PImage img, int x, int y, int w, int h) {
		parent.image(img, x, y, w, h);
	}

	public static void pushMatrix() {
		parent.pushMatrix();
	}

	public static void popMatrix() {
		parent.popMatrix();
	}

	public static void translate(int x, int y) {
		parent.translate(x, y);
	}

	public static void fill(int col) {
		parent.fill(col);
	}

	public static void fill(int col, int alpha) {
		parent.fill(col, alpha);
	}

	public static void rect(int x, int y, int w, int h, int r) {
		parent.rect(x, y, w, h, r);
	}

	public static void rect(int x, int y, int w, int h) {
		parent.rect(x, y, w, h);
	}

	public static float lerp(float start, float stop, float amt) {
		return PApplet.lerp(start, stop, amt);
	}

	public static int millis() {
		return parent.millis();
	}

	public static float radians(float degrees) {
		// TODO Auto-generated method stub
		return PApplet.radians(degrees);
	}

	public static void rotate(float angle) {
		parent.rotate(angle);
	}

	public static void noStroke() {
		parent.noStroke();
	}

	public static void triangle(int x1, int y1, float x2, float y2, float x3,
			float y3) {
		parent.triangle(x1, y1, x2, y2, x3, y3);
	}

	public static PImage requestImage(String fname) {
		return parent.requestImage(fname);
	}

	public static void imageMode(int mode) {
		parent.imageMode(mode);
	}

	public static void tint(int gray, float alpha) {
		parent.tint(gray, alpha);
	}

	public static void noTint() {
		parent.noTint();
	}

	public static void stroke(int rgb) {
		parent.stroke(rgb);
	}

	public static void line(int x1, int y1, int x2, int y2) {
		parent.line(x1, y1, x2, y2);
	}

	public static void textAlign(int alignX) {
		parent.textAlign(alignX);
	}

	public static void background(PImage image) {
		parent.background(image);
	}

	public static PFont loadFont(String fontname) {
		return parent.loadFont(fontname);
	}

	public static void textFont(PFont font, int size) {
		parent.textFont(font, size);
	}

	public static void text(String text, int x, int y) {
		parent.text(text, x, y);
	}

	public static float screenX(int x, int y) {
		return parent.screenX(x, y);
	}

	public static float screenY(int x, int y) {
		return parent.screenY(x, y);
	}

	public static XML loadXML(String fname) {
		return parent.loadXML(fname);
	}

	public static void println(String what) {
		parent.println(what);
	}

	public static void println(int what) {
		parent.println(what);
	}

	public static int get(int x, int y) {
		return parent.get(x, y);
	}

	public static void pushStyle() {
		parent.pushStyle();
	}

	public static void noFill() {
		parent.noFill();
	}

	public static void ellipse(float x1, float y1, int i, int j) {
		parent.ellipse(x1, y1, i, j);		
	}

	public static void popStyle() {
		parent.popStyle();
	}

	public static void rect(float x1, float y1, float x2, float y2) {
		parent.rect(x1, y1, x2, y2);
	}
}
