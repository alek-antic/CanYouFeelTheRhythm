package screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import music.Beatmap;

/**
 * Represents the screen that shows up when the player fails a beatmap
 * @author Alek
 *
 */
public class FailureScreen extends JPanel implements ActionListener, KeyListener{

	
	private JButton retry, back;
	private RhythmFrame f;
	private Beatmap b;
	
	/**
	 * Creates a new FaliureScreen on the given frame
	 * 
	 * @param frame the frame that this screen is constructed around
	 */
	public FailureScreen(RhythmFrame frame) {
		back = new JButton("Back to Song Select");
		f = frame;
		setLayout(new BorderLayout());
		back.addActionListener(this);
		addKeyListener(this);
		
		ImageIcon titlePic = new ImageIcon("lib/Images/LoseText.png");
		JLabel lose = new JLabel(titlePic);
		
		add(lose, BorderLayout.CENTER);
		add(back, BorderLayout.SOUTH);
		
		
		setBackground(new Color(159,13,13));
	}
	
	
	public void setBeatmap(Beatmap b) {
		this.b = b;	
	}
	
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE)
			f.toSongSelect();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(retry)){
			f.toGame(b);
		} else if(e.getSource().equals(back)) {
			f.toSongSelect();
		}
	}

}
