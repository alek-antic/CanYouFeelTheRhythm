package music;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.*;


public class Song implements Runnable {

	
	private AdvancedPlayer player;
	private FileInputStream FIS;

	
	
	
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
	

	public void play() {
		new Thread(this).start();
	}
	
	public void pause() {
		player.stop();
	}
}
