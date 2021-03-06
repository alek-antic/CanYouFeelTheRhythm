package screens;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

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
	 * 
	 * @param b
	 *            a beat to be received
	 */
	void recieveBeat(Beat b);

	void recieveBeatmap(Beatmap b);

	void setListeners(KeyListener k, MouseListener m);
}
