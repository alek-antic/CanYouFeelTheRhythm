package Screens;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SongSelectScreen extends JPanel {
	public SongSelectScreen() {
		super();

		JLabel ssLabel = new JLabel("Song Select Screen");
		add(ssLabel);

		JButton toMM = new JButton("To Main Menu Screen");
		add(toMM);
	}
}
