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
	 * @param color
	 *            of each beat in the combo
	 */
	public Combo(/*Color color*/) {
		beats = new ArrayList<Beat>();
		//c = color;
		//setColor(color);
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
	
	public void setNumbers(){
		for(int i = 1; i < beats.size(); i++){
			beats.get(i).setNumber(i);
		}
	}
	

	/*
	public void setColor(Color c) {
		for (Beat b : beats) {
			b.setColor(c);
		}
	}
	*/

}
