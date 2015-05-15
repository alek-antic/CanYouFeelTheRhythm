package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * The main menu of the game. Provides access to the SongSelectScreen
 * 
 * @author Ben Bauer 
 * @version 5/15/15
 *
 */
public class MainMenuScreen extends JPanel implements ActionListener {

	private RhythmFrame f;

	/**
	 * Constructs a MainMenuScreen on the given frame
	 * @param frame the frame that this screen is constructed around
	 */
	public MainMenuScreen(RhythmFrame frame) {
		super();

		f = frame;

		setBackground(Color.ORANGE);
		setLayout(new BorderLayout());

		JPanel title = new JPanel();
		JLabel mmLabel = new JLabel("Can You Feel the Rhythm?");
		title.add(mmLabel);
		title.setBackground(Color.ORANGE);
		add(title, BorderLayout.CENTER);

		JButton toSS = new JButton("Select Song");
		toSS.addActionListener(this);
		add(toSS, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		f.toSongSelect();
	}
}
