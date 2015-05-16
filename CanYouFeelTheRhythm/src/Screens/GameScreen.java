package Screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import music.Beatmap;
import beats.Beat;

/**
 * The Screen on which CanYouFeelTheRhythm is played
 * @author Ben Bauer
 * @version 5/15/15
 *
 */
public class GameScreen extends JPanel implements Reciever, ActionListener {

	private RhythmFrame f;
	private JButton quit;
	private Beatmap b;
	private Beat beatToBeDrawn;

	/**
	 * Creates a new GameScreen on the given frame
	 * @param frame the frame that this screen is constructed around
	 */
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
	public void paintComponent(Graphics g) {
		
		if(beatToBeDrawn != null)
		beatToBeDrawn.draw(g, this);
		
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		f.toSongSelect();
	}

	@Override
	public void recieveBeat(Beat b) {
		beatToBeDrawn = b;
	}

	@Override
	public void recieveBeatmap(Beatmap bm) {
		b = bm;
		new Thread(b).start();
	}
}
