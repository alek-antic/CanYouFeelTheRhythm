package beats;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;

/**
 * the slider scored by dragging the mouse along it
 * 
 * @author Alek Antic
 * @version 5/15/15
 */

public class Slider extends Beat {

	private int x2;
	private int y2;
	private ArrayList<Beat> checkpoints;

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
	 * @param c
	 *            the color of the slider
	 */
	public Slider(String filename, int x, int y, int r, long time, Color c,
			int x2, int y2) {
		super(filename, x, y, r, time, new ApproachCircle("approach.png", x, y,
				r + 50, c), c);
		this.x2 = x2;
		this.y2 = y2;
		checkpoints = new ArrayList<Beat>();
		
		checkpoints.add(new CircleBeat(filename, x, y, 100,
				1000));
		if (x == x2) {
			for (int i = y; i < y2; i = +100) {
				Beat check = new CircleBeat(filename, x,
						i, 5, time);
				check.removeApproachCircle();
				checkpoints.add(check);
			}
		}

		if (y == y2) {
			for (int i = x; i < x2; i = +100) {
				Beat check = new CircleBeat(filename, x,
						y, 5, time);
				check.removeApproachCircle();
				checkpoints.add(check);
			}
		}

	}

	/**
	 * @post ensures that the slider has an image at the start of the beatmap
	 */
	@Override
	public void resetImage() {
		for(Beat b : checkpoints)
			b.resetImage();
	}

	@Override
	public void draw(Graphics g, ImageObserver io){
		for(Beat b : checkpoints)
			b.draw(g, io);
	}
}
