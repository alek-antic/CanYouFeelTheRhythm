package beats;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

/**
 * The circle that appears around the beat to show the player what to click
 * 
 * @author Alek Antic
 * @version 5/15/15
 */

public class ApproachCircle extends MovingImage {

	private Color c;
	private int initR;
	private int initX, initY;
	
	/**
	 * Creates a new approach circle
	 * 
	 * @param filename
	 *            the file path of the image to be used for the approach circle
	 * @param x
	 *            the x value of the approach circle
	 * @param y
	 *            the y value of the approach circle
	 * @param r
	 * 			  the radius of the approach circle
	 * @param c
	 * 			  the color of the approach circle
	 */
	public ApproachCircle(String filename, int x, int y, int r, Color c) {
		super(filename, x, y, r, r);
		initR = r;
		initX = x;
		initY = y;
		// setColor(c);
	}

	/**
	 * how this ApproachCircle should act in one frame of time
	 * 
	 * @post radius shrinks, circle stays in the same place relative to the
	 *       center
	 */
	public void act() {
		x += 0.5;
		y += 0.5;
		if (width >= 0)
			changeRadiusBy(-1);
	}

	/**
	 * Changes the color of the beat
	 * 
	 * @param c
	 *            the color the beat should be changed to
	 */
	public void setColor(Color c) {
		this.c = c;
		setImage(colorImage((BufferedImage) getImage(), c));
	}

	private BufferedImage colorImage(BufferedImage image, Color c) {
		int width = image.getWidth();
		int height = image.getHeight();
		WritableRaster raster = image.getRaster();

		for (int xx = 0; xx < width; xx++) {
			for (int yy = 0; yy < height; yy++) {
				int[] pixels = raster.getPixel(xx, yy, (int[]) null);
				pixels[0] = c.getRed();
				pixels[1] = c.getGreen();
				pixels[2] = c.getBlue();
				raster.setPixel(xx, yy, pixels);
			}
		}
		return image;
	}

	public void resetSize() {
		super.width = initR;
		super.height = initR;
		super.x = initX;
		super.y = initY;
	}
	
}
