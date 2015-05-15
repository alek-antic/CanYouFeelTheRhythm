package beats;

import java.awt.Color;

/**
 * the slider scored by dragging the mouse along it
 * 
 * @author Alek Antic
 * @version 5/15/15
 */

public class Slider extends Beat {

	/**
	 * Creates a new slider
	 * 
	 * @param filename
	 *            the name of the image file to be used for the circle
	 * @param x
	 *            the x value of the slider
	 * @param y
	 *            the y value of the slider
	 * @param r
	 *            the length of the radius of the slider
	 * @param time
	 *            the time the slider should be clicked
	 */
	public Slider(String filename, int x, int y, int r, long time, Color c) {
		super(filename, x, y, r, time, c);
		// TODO Auto-generated constructor stub
	}

}
