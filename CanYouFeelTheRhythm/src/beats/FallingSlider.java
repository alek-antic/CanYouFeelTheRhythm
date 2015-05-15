package beats;

import java.awt.Color;

/**
 * the slider that falls down the screen for cath the beat and music flow
 * 
 * @author Alek Antic
 * @version 5/15/15
 */

public class FallingSlider extends Slider {

	/**
	 * Creates a new falling slider
	 * 
	 * @param filename
	 *            the name of the image file to be used for the circle
	 * @param x
	 *            the x value of the falling slider
	 * @param y
	 *            the y value of the falling slider
	 * @param r
	 *            the length of the radius of the falling slider
	 * @param time
	 *            the time the falling slider should be clicked
	 */
	public FallingSlider(String filename, int x, int y, int r, long time,
			Color c) {
		super(filename, x, y, r, time, c);
		// TODO Auto-generated constructor stub
	}

}
