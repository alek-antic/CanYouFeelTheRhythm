package screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import music.Beatmap;
import music.Score;
import beats.Beat;
import beats.CircleBeat;
import beats.Slider;

/**
 * The Screen on which CanYouFeelTheRhythm is played
 * 
 * @author Ben Bauer
 * @version 5/15/15
 *
 */
public class GameScreen extends JPanel implements ActionListener {

	private RhythmFrame f;
	private JButton quit;
	private Beatmap bmap;
	private ArrayList<Beat> currentBeats;
	private Score score;
	private Thread t;

	/**
	 * Creates a new GameScreen on the given frame
	 * 
	 * @param frame
	 *            the frame that this screen is constructed around
	 */
	public GameScreen(RhythmFrame frame) {
		super();

		f = frame;

		setBackground(Color.yellow);
		setLayout(new BorderLayout());

		quit = new JButton("Quit");
		quit.addActionListener(this);
		add(quit, BorderLayout.SOUTH);

		currentBeats = new ArrayList<Beat>();

		t = new Thread();
	}

	/**
	 * handles the drawing of the game and score
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (currentBeats != null) {
			for (int i = currentBeats.size() - 1; i >= 0; i--) {
				Beat currentBeat = currentBeats.get(i);
				if (currentBeat != null) {
					currentBeat.moveToLocation(currentBeat.x * f.getWidth()
							/ 1000.0, currentBeat.y * f.getWidth() / 1000.0);
					currentBeat.draw(g, this);
					currentBeat.getApproachCirlce().draw(g, this);
				}
			}
		}
		g.setFont(new Font("Monospaced", Font.BOLD, 36));
		g.drawString("x" + score.getMultiplier(), 50, getHeight() - 50);
		g.drawString("" + score.getTotal(), getWidth() - 100, 50);
		g.drawString("" + score.calcPercentage() + "%", getWidth() - 150, 100);

		g.setColor(new Color(237, 16, 16));
		g.fillRect(0, 0, (int) (600 * score.getLife() / 100.0), 25);

	}
	
	private void reset() {
		t = null;
		bmap = new Beatmap("");
		currentBeats = new ArrayList<Beat>();
		score = new Score();
	}

	public void actionPerformed(ActionEvent e) {
		f.toSongSelect();
		bmap.kill();
	}

	public void setScore(Score score) {
		this.score = score;
	}

	/**
	 * sets the current beat to be drawn
	 * 
	 * @param b
	 *            the beat to be received
	 */
	public void recieveBeats(ArrayList<Beat> b) {
		currentBeats = b;
		repaint();
	}

	/**
	 * sets the beatmap to be played, and starts the beatmap
	 * 
	 * @param b
	 *            the beatmap to be played
	 */
	public void recieveBeatmap(Beatmap b) {
		reset();
		setBackground(Color.yellow);
		bmap = b;
		t = new Thread(bmap);
		t.start();
	}

	public void setListeners(KeyListener k) {
		addKeyListener(k);
	}

	/**
	 * deletes the current beat from the screen
	 */
	public void deleteCurrent(Beat b) {
		for (Beat beat : currentBeats) {
			if (beat.equals(b))
				beat.setImage(null);
		}
		repaint();
	}

	/**
	 * @post changes the screen to the summary screen, with the current Beatmap
	 */
	public void goToSummaryScreen() {
		f.toSummaryScreen(bmap);
	}

	/**
	 * @post changes the screen to the song select screen
	 */
	public void goToSongSelect() {
		f.toSongSelect();
	}

	/**
	 * @post changes the screen to the failure screen
	 */
	public void goToFailureScreen() {
		f.toFailureScreen(bmap);
	}
}
