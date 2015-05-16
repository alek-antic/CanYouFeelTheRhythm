package Screens;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The JFrame on which CanYouFeelTheRhythm is created
 * @author Ben Bauer
 * @version 5/15/15
 *
 */
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
		GameScreen gs = new GameScreen(this);
		framePanel.add(mm, "Main");
		framePanel.add(ss, "SongSelect");
		framePanel.add(gs, "Game");

		ss.setReciever(gs);
		
		add(framePanel);
		

		setResizable(true);
	}

	/**
	 * Changes the current screen to the SongSelectScreen
	 */
	public void toSongSelect() {

		((CardLayout) framePanel.getLayout()).show(framePanel, "SongSelect");

		requestFocus();
	}

	/**
	 * Changes the current screen to the MainMenuScreen
	 */
	public void toMain() {

		((CardLayout) framePanel.getLayout()).show(framePanel, "Main");

		requestFocus();
	}

	/**
	 * Changes the current screen to the GameScreen
	 */
	public void toGame() {

		((CardLayout) framePanel.getLayout()).show(framePanel, "Game");

		requestFocus();
	}
}
