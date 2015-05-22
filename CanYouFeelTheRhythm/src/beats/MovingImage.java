package beats;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;

import javax.swing.*;

/**
 * The superclass for all images that move
 * 
 * @author Alek Antic
 * @version 5/15/15
 */

public class MovingImage extends Ellipse2D.Double {

	private Image image;

	/**
	 * Creates a new moving image from a file
	 * 
	 * @param filename
	 *            the name of the image file to be used for the circle
	 * @param x
	 *            the x value of the moving image
	 * @param y
	 *            the y value of the moving image
	 * @param w
	 *            the width of the moving image
	 * @param h
	 *            the height of the moving image
	 */
	public MovingImage(String filename, int x, int y, int w, int h) {
		this((new ImageIcon(filename)).getImage(), x, y, w, h);
	}

	/**
	 * Creates a new moving image from an image
	 * 
	 * @param img
	 *            the image to be used for the moving image
	 * @param x
	 *            the x value of the moving image
	 * @param y
	 *            the y value of the moving image
	 * @param w
	 *            the width of the moving image
	 * @param h
	 *            the height of the moving image
	 */
	public MovingImage(Image img, int x, int y, int w, int h) {
		super(x, y, w, h);
		image = img;
	}

	/**
	 * moves the moving image to a certain point
	 * 
	 * @param x
	 *            the x value to move to
	 * @param y
	 *            the y value to be moved to
	 */
	public void moveToLocation(double x, double y) {
		super.x = x;
		super.y = y;
	}

	/**
	 * moves the image by a certain amount
	 * 
	 * @param x
	 *            the amount to be moved by in x
	 * @param y
	 *            the amount to be moved by in y
	 */
	public void moveByAmount(double x, double y) {
		super.x += x;
		super.y += y;
	}

	/**
	 * reduces the radius of the moving image
	 * 
	 * @param amount
	 *            the amount to reduce the radius by
	 */
	public void changeRadiusBy(double amount) {
		super.height += amount;
		super.width += amount;
	}

	/**
	 * puts the moving image back in to the opposite side of the window if it
	 * goes off the edge
	 * 
	 * @param windowWidth
	 *            width of the window the moving image is in
	 * @param windowHeight
	 *            height of the window the moving image is in
	 */
	public void applyWindowLimits(int windowWidth, int windowHeight) {
		x = Math.min(x, windowWidth - width);
		y = Math.min(y, windowHeight - height);
		x = Math.max(0, x);
		y = Math.max(0, y);
	}

	/**
	 * draws the moving image on the screen
	 * 
	 * @param g
	 *            the graphics component to draw the moving image on
	 * @param io
	 *            receives information about the image as it is being drawn
	 */
	public void draw(Graphics g, ImageObserver io) {
		g.drawImage(image, (int) x, (int) y, (int) width, (int) height, io);
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image i) {
		image = i;
	}

}
