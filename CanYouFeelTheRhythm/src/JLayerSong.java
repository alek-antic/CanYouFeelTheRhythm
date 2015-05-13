import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.advanced.*;


public class JLayerSong implements Runnable {

	
	private AdvancedPlayer player;
	private int currentFrame;
	private FileInputStream FIS;
	private boolean isPaused;
	
	
	
	public JLayerSong(String filename) {
		try {
			FIS = new FileInputStream(filename);
			player = new AdvancedPlayer(FIS);
			player.setPlayBackListener(new PauseHandler());
		} catch (FileNotFoundException e) {
			System.out.println("**** " + filename + " not found" + "****");
		} catch (JavaLayerException e) {
			System.out.println("*** Failed to play the file ***");	
		}
		currentFrame = 0;
		isPaused = true;
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
		isPaused = false;
	}
	
	public void pause() {
		player.stop();
		isPaused = true;
	}
	
	public void setCurrentFrame(int frame) {
		currentFrame = frame;
	}
	
	public int getCurrentFrame()
	{
		return currentFrame;
	}
	public class PauseHandler extends PlaybackListener {
		
		@Override
		public void playbackFinished(PlaybackEvent e) {
			if(e.getId() == PlaybackEvent.STOPPED)
				setCurrentFrame(e.getFrame());
		}
		
		@Override
		public void playbackStarted(PlaybackEvent e) {
			if(isPaused)
			try {
				player.play(getCurrentFrame(), FIS.available());
			} catch (JavaLayerException ex) {
				ex.printStackTrace();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
			
		}
		
	}
}
