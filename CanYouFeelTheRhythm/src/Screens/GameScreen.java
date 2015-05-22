package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import music.Beatmap;
import beats.Beat;
import beats.CircleBeat;

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
	private Beat currentBeat;
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

		currentBeat = new CircleBeat("lib/Images/CircleBeat1.png", -500, -500, 0, 0);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (currentBeat != null){
			currentBeat.moveToLocation(currentBeat.x * f.getWidth() / 1000.0, currentBeat.y * f.getWidth() / 1000.0);
			currentBeat.draw(g, this);
			currentBeat.getApproachCirlce().draw(g,this);
		}
	}

	public void actionPerformed(ActionEvent e) {
		f.toSongSelect();
//		bmap.kill();
	}

	public void recieveBeat(Beat b) {
		currentBeat = b;
		repaint();
	}

	public void recieveBeatmap(Beatmap b) {
		bmap = b;
		new Thread(bmap).start();
	}

	public void setListeners(KeyListener k) {
		addKeyListener(k);
	}

	public void deleteCurrent() {
		currentBeat.setImage(null);
		repaint();
	}
}
