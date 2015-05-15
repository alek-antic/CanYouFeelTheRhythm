package beats;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;

public abstract class Beat extends MovingImage {

	private int r;
	private long time;
	private final long approachRate = 500;
	private Color c;

	public Beat(String filename, int x, int y, int r, long time) {
		super(filename, x, y, r, r);
		this.time = time;
		setColor(new Color(72, 196, 224));
	}

	public Beat(String filename, int x, int y, int r, long time, Color c) {
		this(filename, x, y, r, time);
		setColor(c);
	}

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
	 
}
