package beats;

import java.awt.*;

public abstract class Beat extends MovingImage {

	private int x, y, r;
	private double time;
	private final double approachRate = 500;
	private Color c;

	public Beat(String filename, int x, int y, int r, double time) {
		super(filename, x, y, r, r);
		this.time = time;
		setColor(new Color(72, 196, 224));
	}

	public Beat(String filename, int x, int y, int r, double time, Color c) {
		this(filename, x, y, r, time);
		setColor(c);
	}

	public void setColor(Color c) {
		this.c = c;
	}

}
