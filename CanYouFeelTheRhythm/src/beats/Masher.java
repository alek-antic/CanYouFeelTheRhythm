package beats;

import java.awt.Color;

import javax.swing.ImageIcon;

/**
 * beat scored by mashing the keys as much as you can
 * 
 * @author Alek Antic
 * @version 5/15/15
 */

public class Masher extends Beat {

	private final long approachRate = 3000;

	/**
	 * Creates a new Masher
	 * 
	 * @param filename
	 *            the name of the image file to be used for the circle
	 * @param x
	 *            the x value of the Masher
	 * @param y
	 *            the y value of the Masher
	 * @param time
	 *            the time the Masher should be mashed
	 */
	public Masher(String filename, int x, int y, long time) {
		super(filename, x, y, 0, time, new ApproachCircle("approach.png", x, y,
				750, new Color(0, 0, 0)));
	}

	/**
	 * @post toggles which frame the masher is on
	 */
	public void switchImage() {
		if (getImage().equals(
				(new ImageIcon("lib/Images/MasherFrame1.png")).getImage()))
			setImage((new ImageIcon("lib/Images/MasherFrame2.png")).getImage());
		else if (getImage().equals(
				(new ImageIcon("lib/Images/MasherFrame2.png")).getImage()))
			setImage((new ImageIcon("lib/Images/MasherFrame1.png")).getImage());
	}

	/**
	 * @post resets the image to frame 1 at the start of a beatmap
	 */
	@Override
	public void resetImage() {
		setImage((new ImageIcon("lib/Images/MasherFrame1.png")).getImage());
	}

	public long getApproach() {
		return approachRate;
	}

}
