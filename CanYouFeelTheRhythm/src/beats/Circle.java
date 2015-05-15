package beats;

import java.awt.Color;

public class Circle extends Beat {
	
	private int number;


	public Circle(String filename, int x, int y, int r, long time) {
		super(filename,x,y,r, time);
	}
	
	public Circle(String filename, int x, int y, int r, long time, Color c) {
		super(filename,x,y,r, time);
		setColor(c);
	}

}
