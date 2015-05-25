package screens;

import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import music.Beatmap;

/**
 * The JFrame on which CanYouFeelTheRhythm is created
 * 
 * @author Ben Bauer
 * @version 5/15/15
 *
 */
public class RhythmFrame extends JFrame {

	private JPanel framePanel;
	private MainMenuScreen mm;
	private SongSelectScreen ss;
	private GameScreen gs;
	private SummaryScreen summ;
	private FailureScreen fs;

	public RhythmFrame() {
		super("Can you feel the rhythm?");
		setBounds(100, 100, 1000, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePanel = new JPanel();
		framePanel.setLayout(new CardLayout());

		mm = new MainMenuScreen(this);
		ss = new SongSelectScreen(this);
		gs = new GameScreen(this);
		summ = new SummaryScreen(this);
		fs = new FailureScreen(this);
		framePanel.add(mm, "Main");
		framePanel.add(ss, "SongSelect");
		framePanel.add(gs, "Game");
		framePanel.add(summ, "Summary");
		framePanel.add(fs, "Fail");

		add(framePanel);
		requestFocus();

		// setResizable(true);
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
	 * Changes the current screen to the GameScreen and sets the beatmap
	 * @param b the beatmap to give to the GameScreen
	 */
	public void toGame(Beatmap b) {
		gs.recieveBeatmap(b);
		b.setGamescreen(gs);

		((CardLayout) framePanel.getLayout()).show(framePanel, "Game");
		requestFocus();
		gs.requestFocus();
	}
	
	public void toSummaryScreen(Beatmap b) {
		summ.recieveBeatmap(b);
		((CardLayout) framePanel.getLayout()).show(framePanel, "Summary");
		requestFocus();
	}
	
	public void toFailureScreen(Beatmap b) {
		fs.setBeatmap(b);
		((CardLayout) framePanel.getLayout()).show(framePanel, "Fail");
		requestFocus();
	}
}
