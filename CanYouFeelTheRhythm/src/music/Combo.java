package music;

import java.awt.Color;
import java.util.ArrayList;

import beats.Beat;

public class Combo {

	private ArrayList<Beat> beats;
	private Color c;
	
	public Combo(Color color) {
		beats = new ArrayList<Beat>();
		c = color;
		setColor(color);
	}
	
	public void addBeat(Beat b) {
		beats.add(b);
	}
	
	public ArrayList<Beat> getBeatArray() {
		return beats;
	}
	
	
	public void setColor(Color c) {
		for(Beat b: beats) {
			b.setColor(c);
		}
	}
	
}
