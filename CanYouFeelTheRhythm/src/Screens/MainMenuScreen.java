package Screens;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MainMenuScreen extends JPanel {
	public MainMenuScreen() {
		super();

		JLabel mmLabel = new JLabel("Main Menu Screen");
		add(mmLabel);

		JButton toSS = new JButton("To Song Select Screen");
		add(toSS);
	}
}
