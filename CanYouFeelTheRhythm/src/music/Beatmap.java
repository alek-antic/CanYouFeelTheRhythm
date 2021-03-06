package music;

import io.github.jgkamat.JayLayer.JayLayer;

import java.awt.Color;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.UUID;

import javax.swing.Timer;

import screens.GameScreen;
import beats.Beat;
import beats.CircleBeat;
import beats.Masher;

/**
 * stores all beats to and the song
 * 
 * @author Alek Antic
 */
public class Beatmap implements Runnable {

	private JayLayer player;
	private Score score;
	private ArrayList<Combo> beatCombos;
	private Timer time;
	private long currentTime;
	private GameScreen gamescreen;
	private ArrayList<Beat> currentBeats;
	private KeyListener k;
	private UUID playing;
	private long length;
	private String filename;

	/**
	 * creates a new beatmap
	 * 
	 * @param filename
	 *            the filename of the song to be in the beatmap
	 */
	public Beatmap(String filename) {
		this.filename = filename;
		beatCombos = new ArrayList<Combo>();
		currentBeats = new ArrayList<Beat>();
		time = new Timer(1, new TimerHandler());
		player = new JayLayer("/audio/", "/audio/");
		player.addSoundEffect(filename);
		player.addSoundEffect("click.mp3");
		player.addSoundEffect("miss.mp3");
		currentTime = 0l;
		k = new KeyHandler();
		score = new Score();
	}

	/**
	 * starts the timer and beats will start appearing
	 */
	public void run() {
		long time = 0;
		for (Combo c : beatCombos) {
			c.setNumbers();
			if (c.getLatestBeatTime() > time)
				time = c.getLatestBeatTime();
			for (Beat b : c.getBeatArray()) {
				b.resetImage();
				b.setClickable(true);
			}
		}
		score.reset();
		length = time;
		this.time.start();
		currentTime = 0;
		playing = player.playSoundEffect(0);
		return;
	}

	/**
	 * @post kills the beatmap, indicating a failure, and bringing the
	 *       SongSelectScreen back up
	 */
	public void kill() {
		time.stop();
		currentTime = 0l;
		player.killSoundEffect(playing);
		gamescreen.goToFailureScreen();
	}

	/**
	 * @post ends the beatmap, bringing up the summary of the player's
	 *       performance
	 */
	public void end() {
		time.stop();
		currentTime = 0l;
		player.killSoundEffect(playing);
		gamescreen.goToSummaryScreen();
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
		gamescreen.setScore(score);
	}

	public Score getScore() {
		return score;
	}

	private class TimerHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (score.getLife() <= 0)
				kill();
			currentTime++;
			if (currentTime >= length) {
				if (currentTime % 75 == 0) {
					gamescreen.setBackground(gamescreen.getBackground()
							.darker());
				}
			}

			if (currentTime % 3 == 0) {
				score.decrementLife();
				gamescreen.repaint();
			}

			if (currentTime >= length + 75 * 5)
				end();
			else {
				for (Combo c : beatCombos) {
					ArrayList<Beat> beats = c.getBeatArray();
					ArrayList<Beat> toDraw = new ArrayList<Beat>();
					for (Beat b : beats) {
						if (b.getTime() - b.getApproach() <= currentTime
								&& b.getTime() >= currentTime) {
							toDraw.add(b);
						} else if (b.getTime() <= currentTime) {
							if (b.getClickable()) {
								score.addToScore(0);
								score.resetMultiplier();
								player.playSoundEffect(2);
								b.setClickable(false);
							}
							gamescreen.recieveBeats(null);
							b.getApproachCirlce().act();
							continue;
						}
						gamescreen.recieveBeats(toDraw);
						currentBeats = toDraw;
						
					}
				}
				for (Beat beat : currentBeats) {
					beat.getApproachCirlce().act();
				}
			}
		}
	}

	private class KeyHandler implements KeyListener {

		private long timePressed;
		private boolean pressedDown = false;

		@Override
		public void keyPressed(KeyEvent e) {

			timePressed = currentTime;
			Point p = MouseInfo.getPointerInfo().getLocation();
			Point p2 = gamescreen.getLocationOnScreen();
			double mouseX = p.getX() - p2.getX();
			double mouseY = p.getY() - p2.getY();

			if (!pressedDown) {
				for (Beat currentBeat : currentBeats) {
					if (currentBeat instanceof CircleBeat) {
						if (Math.abs(timePressed - currentBeat.getTime()) <= 50
								&& mouseX > currentBeat.getX()
								&& mouseX < currentBeat.getX()
										+ currentBeat.getWidth()
								&& mouseY > currentBeat.getX()
								&& mouseY < currentBeat.getY()
										+ currentBeat.getHeight()
								&& currentBeat.getClickable()
								&& (e.getKeyCode() == KeyEvent.VK_Z || e
										.getKeyCode() == KeyEvent.VK_X)) {
							gamescreen.deleteCurrent(currentBeat);
							currentBeat.setClickable(false);
							currentBeat.getApproachCirlce().height = 0;
							currentBeat.getApproachCirlce().width = 0;
							player.playSoundEffect(1);
							score.incrementMultiplier();
							score.addToScore(300);
							break;
						} else if (Math
								.abs(timePressed - currentBeat.getTime()) <= 100
								&& mouseX > currentBeat.getX()
								&& mouseX < currentBeat.getX()
										+ currentBeat.getWidth()
								&& mouseY > currentBeat.getX()
								&& mouseY < currentBeat.getY()
										+ currentBeat.getHeight()
								&& currentBeat.getClickable()
								&& (e.getKeyCode() == KeyEvent.VK_Z || e
										.getKeyCode() == KeyEvent.VK_X)) {
							gamescreen.deleteCurrent(currentBeat);
							currentBeat.setClickable(false);
							currentBeat.getApproachCirlce().height = 0;
							currentBeat.getApproachCirlce().width = 0;
							player.playSoundEffect(1);
							score.incrementMultiplier();
							score.addToScore(100);
							break;
						} else if (Math
								.abs(timePressed - currentBeat.getTime()) <= 150
								&& mouseX > currentBeat.getX()
								&& mouseX < currentBeat.getX()
										+ currentBeat.getWidth()
								&& mouseY > currentBeat.getX()
								&& mouseY < currentBeat.getY()
										+ currentBeat.getHeight()
								&& currentBeat.getClickable()
								&& (e.getKeyCode() == KeyEvent.VK_Z || e
										.getKeyCode() == KeyEvent.VK_X)) {
							gamescreen.deleteCurrent(currentBeat);
							currentBeat.setClickable(false);
							currentBeat.getApproachCirlce().height = 0;
							currentBeat.getApproachCirlce().width = 0;
							player.playSoundEffect(1);
							score.incrementMultiplier();
							score.addToScore(50);
							break;
						} else if (e.getKeyCode() == KeyEvent.VK_X
								|| e.getKeyCode() == KeyEvent.VK_Z) {
							score.resetMultiplier();
							player.playSoundEffect(2);
							break;
						}
					} else if (currentBeat instanceof Masher) {
						if (e.getKeyCode() == KeyEvent.VK_X
								|| e.getKeyCode() == KeyEvent.VK_Z) {
							score.incrementMultiplier();
							score.addToScore(100);
						}
						break;
					}
				}
				gamescreen.setScore(score);
				pressedDown = true;
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_X
					|| e.getKeyCode() == KeyEvent.VK_Z) {
				pressedDown = false;
			}

		}

		@Override
		public void keyTyped(KeyEvent arg0) {
		}

	}
}
