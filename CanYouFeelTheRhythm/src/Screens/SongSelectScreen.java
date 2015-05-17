package Screens;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import beats.Beat;
import beats.CircleBeat;
import music.Beatmap;
import music.Combo;

/**
 * The screen on which the game itself is drawn
 * 
 * @author Ben Bauer
 * @version 5/15/15
 *
 */
public class SongSelectScreen extends JPanel implements ActionListener {

	private RhythmFrame f;
	private JButton toMM;
	private JButton song1;
	private JButton song2;
	private Beatmap b;
	private Reciever r;

	/**
	 * Creates a new SongSelectScreen on the given RhythmFrame
	 * 
	 * @param frame
	 *            the frame that this screen is constructed around
	 */
	public SongSelectScreen(RhythmFrame frame) {
		super();
		f = frame;
		setBackground(Color.pink);
		setLayout(new BorderLayout());

		b = new Beatmap("lib/chasingtime.mp3");
		Combo testCombo = new Combo();
		Beat testBeat = new CircleBeat("lib/Images/circle.png", 100, 100, 100, 1000);
		testCombo.addBeat(testBeat);
		b.addCombo(testCombo);

		JLabel ssLabel = new JLabel("Select Your Song");
		add(ssLabel, BorderLayout.NORTH);

		toMM = new JButton("Back");
		toMM.addActionListener(this);
		add(toMM, BorderLayout.SOUTH);

		JPanel selectSong = new JPanel();
		selectSong.setBackground(Color.pink);
		song1 = new JButton("song1");
		song2 = new JButton("song2");
		song1.addActionListener(this);
		song2.addActionListener(this);
		selectSong.add(song1);
		selectSong.add(song2);
		add(selectSong, BorderLayout.CENTER);

	}
	
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == toMM)
			f.toMain();
		if (source == song1 || source == song2)
			f.toGame(b);
	}
}
