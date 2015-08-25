import processing.core.*;
import processing.data.*;
import processing.event.*;
import processing.opengl.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;

public class Ziffernerkennung extends PApplet {

	PImage img;

	BoundingBox bb = (new BoundingBox(0, 0, 1200, 800));
	int xc = 0;
	int yc = 0;
	boolean db = false;

	float angle = 0;
	float ydiff = 0;

	public void setup() {
		PAppletBridge pb = new PAppletBridge(this);
		size(1100, 750);
		// size (1000, 700, P3D);
		// size (1000, 700);
		img = loadImage("zahlen-04-sehr-klein.png");
	}

	public void draw() {
		background(255);

		// anzeige und vorverarbeitung
		drawIt();

		// Analyse
		bb.minimize();
		xc = bb.nextVerticalCut();
		yc = bb.nextHorizontalCut();

		// kontrollausgabe
		bb.draw();
		stroke(0xffff0000);
		line(xc, 0, xc, height);
		line(0, yc, width, yc);

		// angle = map (mouseX, 0, width, -180, 180);
	}

	public void drawIt() {
		pushMatrix();
		translate(width / 2, height / 2);
		rotate(radians(angle));

		pushStyle();
		translate(-img.width / 2, -img.height / 2);
		image(img, 0, 0);

		// binarisieren
		filter(THRESHOLD, 0.574f);
		// filter(ERODE);
		popStyle();
		popMatrix();
	}

	public void keyPressed() {
		if (key == '1') {
			bb.x1 = 0;
			bb.y1 = 0;
			bb.x2 = 1200;
			bb.y2 = 800;
			bb.minimize();
		}
		if (key == '2') {
			bb.x1 = xc;
		}
		if (key == '3') {
			bb.y1 = yc;
		}

		if (key == '4') {
			bb.y2 = yc;
		}
	}

	static public void main(String[] passedArgs) {
		String[] appletArgs = new String[] { "Ziffernerkennung" };
		if (passedArgs != null) {
			PApplet.main(concat(appletArgs, passedArgs));
		} else {
			PApplet.main(appletArgs);
		}
	}
}
