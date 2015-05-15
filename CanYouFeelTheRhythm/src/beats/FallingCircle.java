package beats;

import java.awt.Color;

public class FallingCircle extends Circle {

	
	public FallingCircle(String filename, int x, int y, int r, long time) {
		super(filename, x, y, r, time);

	}
	
	public FallingCircle(String filename, int x, int y, int r, long time, Color c) {
		super(filename, x, y, r, time);
		setColor(c);

	}
	
	
}
