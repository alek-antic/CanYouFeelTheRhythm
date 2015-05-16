package Screens;

import music.Beatmap;
import beats.Beat;
/**
 * 
 * @author Alek Antic
 * @version 5/15/15
 */
public interface Reciever {
	
	/**
	 * Provides a reference to 
	 * @param b a beat to be recieved
	 * @return the beat b
	 */
	void recieveBeat(Beat b);
	void recieveBeatmap(Beatmap b);
}
