package beats;

import java.awt.Color;

/**
 * The basic circular beat scored by clicking on it
 * 
 * @author Alek Antic
 * @version 5/15/15
 */

public class CircleBeat extends Beat {

	private int number;
	private ApproachCircle c;
	
	/**
	 * Creates a new circle beat
	 * 
	 * @param filename
	 *            the name of the image file to be used for the circle
	 * @param x
	 *            the x value of the circle beat
	 * @param y
	 *            the y value of the circle beat
	 * @param r
	 *            the length of the radius of the circle beat
	 * @param time
	 *            the time the circle beat should be clicked
	 */
	public CircleBeat(String filename, int x, int y, int r, long time) {
		super(filename, x, y, r, time);
		c = new ApproachCircle("approach.png", x, y, r + 50, r + 50);
	}

	/**
	 * Creates a new circle beat of a certain color
	 * 
	 * @param filename
	 *            the name of the image file to be used for the circle beat
	 * @param x
	 *            the x value of the circle beat
	 * @param y
	 *            the y value of the circle beat
	 * @param r
	 *            the length of the radius of the circle beat
	 * @param time
	 *            the time the circle beat should be clicked
	 * @param c
	 *            the color of the circle beat
	 */
	public CircleBeat(String filename, int x, int y, int r, long time, Color c) {
		super(filename, x, y, r, time);
		setColor(c);
	}

}
