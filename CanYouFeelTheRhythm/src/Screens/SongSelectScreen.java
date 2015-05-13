package Screens;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SongSelectScreen extends JPanel implements ActionListener {
	
	private RhythmFrame f;
	
	public SongSelectScreen(RhythmFrame frame) {
		super();

		f = frame;
		
		JLabel ssLabel = new JLabel("Song Select Screen");
		add(ssLabel);

		JButton toMM = new JButton("To Main Menu Screen");
		toMM.addActionListener(this);
		add(toMM);
	}
	
	public void actionPerformed(ActionEvent e) {
		f.toMain();
	}
}
