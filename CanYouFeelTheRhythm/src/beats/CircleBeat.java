package beats;

import java.awt.Color;

import javax.swing.ImageIcon;

/**
 * The basic circular beat scored by clicking on it
 * 
 * @author Alek Antic
 * @version 5/15/15
 */

public class CircleBeat extends Beat {

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
		super(filename, x, y, r, time, new ApproachCircle(
				"lib/Images/approach.png", x - 250, y - 250, r + 500,
				new Color(72, 196, 224)));

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
		this(filename, x, y, r, time);
		setColor(c);
	}

	/**
	 * @post ensures that this CircleBeat's has its image at the start of a
	 *       Beatmap
	 */
	public void resetImage() {
		setImage((new ImageIcon("lib/Images/" + "CircleBeat" + getNumber()
				+ ".png", "lib/Images/" + "CircleBeat" + getNumber()
				+ ".png")).getImage());
		getApproachCirlce().resetSize();
		
	}

}
