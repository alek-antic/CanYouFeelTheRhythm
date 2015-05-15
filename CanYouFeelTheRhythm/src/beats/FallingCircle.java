package beats;

import java.awt.Color;

/**
 * the beat moving down the screen for catch the beat and music flow
 * 
 * @author Alek Antic
 * @version 5/15/15
 */

public class FallingCircle extends CircleBeat {

	/**
	 * Creates a new falling circle
	 * 
	 * @param filename
	 *            the name of the image file to be used for the circle
	 * @param x
	 *            the x value of the falling circle
	 * @param y
	 *            the y value of the falling circle
	 * @param r
	 *            the length of the radius of the falling circle
	 * @param time
	 *            the time the falling circle should be clicked
	 */
	public FallingCircle(String filename, int x, int y, int r, long time) {
		super(filename, x, y, r, time);

	}

	/**
	 * Creates a new falling circle
	 * 
	 * @param filename
	 *            the name of the image file to be used for the circle
	 * @param x
	 *            the x value of the falling circle
	 * @param y
	 *            the y value of the falling circle
	 * @param r
	 *            the length of the radius of the falling circle
	 * @param time
	 *            the time the falling circle should be clicked
	 * @param c
	 *            the color of the falling circle
	 */
	public FallingCircle(String filename, int x, int y, int r, long time,
			Color c) {
		super(filename, x, y, r, time);
		setColor(c);

	}

}
