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
	
	/**
	 * Creates a new approach circle
	 * 
	 * @param filename
	 *            the file path of the image to be used for the approach circle
	 * @param x
	 *            the x value of the approach circle
	 * @param y
	 *            the y value of the approach circle
	 * @param w
	 *            the height of the approach circle
	 * @param h
	 *            the width of the approach circle
	 */
	public ApproachCircle(String filename, int x, int y, int r, Color c) {
		super(filename, x, y, r, r);
		//setColor(c);
	}
	
	
	public void act() {
		height -= 5;
		width -= 5;
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

}
