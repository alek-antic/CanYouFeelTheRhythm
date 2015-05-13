package Screens;

import java.awt.CardLayout;
import javax.swing.JFrame;

public class RhythmFrame extends JFrame {
	public RhythmFrame() {
		super("Can you feel the rhythm?");
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLayout(new CardLayout());

		MainMenuScreen mm = new MainMenuScreen();
		SongSelectScreen ss = new SongSelectScreen();
		add(mm);
		add(ss);

		setResizable(true);
	}
}
