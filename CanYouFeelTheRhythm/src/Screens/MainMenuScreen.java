package Screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class MainMenuScreen extends JPanel implements ActionListener {
	
	private RhythmFrame f;
	
	public MainMenuScreen(RhythmFrame frame) {
		super();

		f = frame;
		
		JLabel mmLabel = new JLabel("Main Menu Screen");
		add(mmLabel);

		JButton toSS = new JButton("To Song Select Screen");
		toSS.addActionListener(this);
		add(toSS);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		f.toSongSelect();
	}
}
