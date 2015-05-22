package beats;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

import javax.swing.ImageIcon;

/**
 * superclass for all the beats that the player ineracts with
 * 
 * @author Alek Antic
 * @version 5/15/15
 */

public abstract class Beat extends MovingImage {

	private int r;
	private long time;
	private final long approachRate = 500;
	private Color c;

	private int number;
	private Boolean clickable;

	private ApproachCircle approachCircle;


	/**
	 * Creates a new beat
	 * 
	 * @param filename
	 *            the name of the image file to be used for the beat
	 * @param x
	 *            the x value of the beat
	 * @param y
	 *            the y value of the beat
	 * @param r
	 *            the length of the radius of the beat
	 * @param time
	 *            the time the beat should be pressed
	 */
	public Beat(String filename, int x, int y, int r, long time, ApproachCircle circle) {
		super(filename, x, y, r, r);
		this.time = time;

		clickable = true;

		approachCircle = circle;

		//setColor(new Color(72, 196, 224));
	}

	/**
	 * Creates a new beat of a certain color
	 * 
	 * @param filename
	 *            the name of the image file to be used for the beat
	 * @param x
	 *            the x value of the beat
	 * @param y
	 *            the y value of the beat
	 * @param r
	 *            the length of the radius of the beat
	 * @param time
	 *            the time the beat should be pressed
	 * @param c
	 *            the color of the beat
	 */
	public Beat(String filename, int x, int y, int r, long time, ApproachCircle circle, Color c) {
		this(filename, x, y, r, time, circle);
		//setColor(c);
		clickable = true;
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

	public long getTime() {
		return time;
	}

	public long getApproach() {
		return approachRate;
	}
	
	public void deleteImage(){
		setImage(null);
	}
	public void resetImage(){
		setImage((new ImageIcon("lib/Images/" + "CircleBeat" + "" /*+ number*/ + ".png")).getImage()); 
		clickable = true;
	}


	public void setNumber(int n) {
		number = n;
	}
	
	public boolean getClickable(){
		return clickable;
	}
	
	public void setClickable(Boolean b){
		clickable = b;
	}

	public ApproachCircle getApproachCirlce() {
		// TODO Auto-generated method stub
		return approachCircle;
	}


}
