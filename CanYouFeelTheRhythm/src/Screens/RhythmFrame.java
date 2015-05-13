package Screens;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class RhythmFrame extends JFrame {
	
	JPanel framePanel;
	
	public RhythmFrame() {
		super("Can you feel the rhythm?");
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePanel = new JPanel();
		framePanel.setLayout(new CardLayout());

		MainMenuScreen mm = new MainMenuScreen(this);
		SongSelectScreen ss = new SongSelectScreen(this);
		framePanel.add(mm, "Main");
		framePanel.add(ss, "SongSelect");

		add(framePanel);
		
		setResizable(true);
	}
	
	public void toSongSelect() {
		
		((CardLayout)framePanel.getLayout()).show(framePanel, "SongSelect");
		
		requestFocus();
	}
	
	public void toMain() {
		
		((CardLayout)framePanel.getLayout()).show(framePanel, "Main");
		
		requestFocus();
	}
}
