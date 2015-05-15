package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameScreen extends JPanel implements DrawOnAble, ActionListener {

	private RhythmFrame f;
	private JButton quit;

	public GameScreen(RhythmFrame frame) {
		super();

		f = frame;

		setBackground(Color.cyan);
		setLayout(new BorderLayout());

		quit = new JButton("Quit");
		quit.addActionListener(this);
		add(quit, BorderLayout.SOUTH);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		f.toSongSelect();
	}
}
