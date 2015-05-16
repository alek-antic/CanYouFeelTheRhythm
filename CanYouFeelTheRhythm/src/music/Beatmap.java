package music;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Timer;

import Screens.GameScreen;
import Screens.Reciever;
import beats.Beat;

/**
 * stores all beats to and the song
 * 
 * @author Alek Antic
 */
public class Beatmap implements Runnable {

	private Song song;
	private Score score;
	private ArrayList<Combo> beatCombos;
	private Timer time;
	private long currentTime;
	private Reciever gamescreen;

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
	}

	/**
	 * starts the timer and beats will start appearing
	 */
	public void run() {
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

	public void setGamescreen(Reciever r) {
		gamescreen = r;
	}

	private class TimerHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			currentTime++;
			for (Combo c : beatCombos) {
				ArrayList<Beat> beats = c.getBeatArray();
				for (Beat b : beats) {
					if (b.getTime() - b.getApproach() >= currentTime
							&& b.getTime() <= currentTime) {
						gamescreen.recieveBeat(b);
					}
				}
			}

		}

	}

	private class KeyHandler implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub

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

	private class MouseHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

}
