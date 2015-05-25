package music;

import java.awt.Color;
import java.util.ArrayList;

import beats.Beat;

/**
 * Contains a string of beats
 * 
 * @author Alek Antic
 */
public class Combo {

	private ArrayList<Beat> beats;
	private Color c;

	/**
	 * creates a new combo
	 * 
	 */
	public Combo(/* Color color */) {
		beats = new ArrayList<Beat>();
		// c = color;
		// setColor(color);
	}

	/**
	 * add a beat to the combo
	 * 
	 * @param b
	 *            the beat to be added to the combo
	 */
	public void addBeat(Beat b) {
		beats.add(b);
	}

	public ArrayList<Beat> getBeatArray() {
		return beats;
	}

	/**
	 * @post all Beats in this Combo have their number initialized properly
	 */
	public void setNumbers() {
		for (int i = 0; i < beats.size(); i++) {
			beats.get(i).setNumber(i + 1);
		}
	}

	public long getLatestBeatTime() {
		long time = 0;
		for (Beat b : beats) {
			if (b.getTime() > time)
				time = b.getTime();
		}
		return time;
	}

	/*
	 * public void setColor(Color c) { for (Beat b : beats) { b.setColor(c); } }
	 */

}
