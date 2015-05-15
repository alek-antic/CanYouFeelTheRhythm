package music;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.*;

/**
 * The class to represent a song
 * @author Alek Antic
 *
 */
public class Song implements Runnable {

	
	private AdvancedPlayer player;
	private FileInputStream FIS;

	
	
	/**
	 * Creates a new song from the given filename
	 * @param filename The filepath to the sound file, with the file format of mp3
	 */
	public Song(String filename) {
		try {
			FIS = new FileInputStream(filename);
			player = new AdvancedPlayer(FIS);
		} catch (FileNotFoundException e) {
			System.out.println("**** " + filename + " not found" + "****");
		} catch (JavaLayerException e) {
			System.out.println("*** Failed to play the file ***");	
		}
	}

	
	@Override
	public void run() {
		try {
			player.play();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Starts playing the song 
	 */
	public void play() {
		new Thread(this).start();
	}
	
	/**
	 * Stops playing the song
	 */
	public void pause() {
		player.stop();
	}
}
