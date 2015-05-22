package music;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.Timer;

import Screens.GameScreen;
import beats.Beat;

/**
 * stores all beats to and the song
 * 
 * @author Alek Antic
 */
public class Beatmap implements Runnable {

	private Song song;
	private Song clap;
	private Score score;
	private ArrayList<Combo> beatCombos;
	private Timer time;
	private long currentTime;
	private GameScreen gamescreen;
	private Beat currentBeat;
	private KeyListener k;

	/**
	 * creates a new beatmap
	 * 
	 * @param filename
	 *            the filename of the song to be in the beatmap
	 */
	public Beatmap(String filename) {
		beatCombos = new ArrayList<Combo>();
		time = new Timer(1, new TimerHandler());
		song = new Song(filename);
		currentTime = 0l;
		k = new KeyHandler();
		clap = new Song("lib/clap.mp3");
	}

	/**
	 * starts the timer and beats will start appearing
	 */
	public void run() {
		for(Combo c: beatCombos){
			for(Beat b: c.getBeatArray()){
				b.resetImage();
			}
		}
		time.start();
		currentTime = 0;
		song.play();

	}

	/**
	 * adds a combo to the beatmap
	 * 
	 * @param c
	 *            the combo to be added
	 */
	public void addCombo(Combo c) {
		beatCombos.add(c);
	}

	public void setGamescreen(GameScreen gs) {
		gamescreen = gs;
		gamescreen.setListeners(new KeyHandler());
	}

	private class TimerHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			currentTime++;
			for (Combo c : beatCombos) {
				ArrayList<Beat> beats = c.getBeatArray();
				for (Beat b : beats) {
					if (b.getTime() - b.getApproach() <= currentTime
							&& b.getTime() >= currentTime) {
						gamescreen.recieveBeat(b);
<<<<<<< HEAD
						currentBeat = b;
					} else if (b.getTime() <= currentTime) {
						gamescreen.recieveBeat(null);
=======
						b.getApproachCirlce().act();
>>>>>>> origin/mobeats
					}
				}
			}

		}

	}

	private class KeyHandler implements KeyListener {

		private long timePressed;

		@Override
		public void keyPressed(KeyEvent e) {
			timePressed = currentTime;
			Point p = MouseInfo.getPointerInfo().getLocation();
			Point p2 = gamescreen.getLocationOnScreen();
			double mouseX = p.getX() - p2.getX();
			double mouseY = p.getY() - p2.getY();

			if (Math.abs(timePressed - currentBeat.getTime()) <= 500
					&& mouseX > currentBeat.getX()
					&& mouseX < currentBeat.getX() + currentBeat.getWidth()
					&& mouseY > currentBeat.getX()
					&& mouseY < currentBeat.getY() + currentBeat.getHeight() && currentBeat.getClickable()
					&& (e.getKeyCode() == KeyEvent.VK_Z || e.getKeyCode() == KeyEvent.VK_X)) {
				gamescreen.deleteCurrent();
				currentBeat.setClickable(false);
				clap.play();
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
