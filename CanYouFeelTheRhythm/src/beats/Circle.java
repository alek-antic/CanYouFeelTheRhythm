package beats;

import java.awt.Color;

public class Circle extends Beat {

	public Circle(String filename, int x, int y, int r, double time) {
		super(filename,x,y,r, time);
	}
	
	public Circle(String filename, int x, int y, int r, double time, Color c) {
		super(filename,x,y,r, time);
		setColor(c);
	}
	
}
