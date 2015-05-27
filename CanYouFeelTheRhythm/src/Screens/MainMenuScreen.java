package screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * The main menu of the game. Provides access to the SongSelectScreen
 * 
 * @author Ben Bauer
 * @version 5/15/15
 *
 */
public class MainMenuScreen extends JPanel implements ActionListener {

	private RhythmFrame f;
	private JButton toSS;
	private JButton quit;

	/**
	 * Constructs a MainMenuScreen on the given frame
	 * 
	 * @param frame
	 *            the frame that this screen is constructed around
	 */
	public MainMenuScreen(RhythmFrame frame) {
		super();

		f = frame;

		
		
		setBackground(Color.yellow);
		setLayout(new BorderLayout());

		ImageIcon titlePic = new ImageIcon("lib/Images/TitleText.png");
		JLabel title = new JLabel(titlePic);
		
		toSS = new JButton("Select Song ");
		toSS.addActionListener(this);
		toSS.setOpaque(false);
		toSS.setContentAreaFilled(false);
		
		quit = new JButton("    Quit    ");
		quit.addActionListener(this);
		quit.setOpaque(false);
		quit.setContentAreaFilled(false);
		
		add(title, BorderLayout.NORTH);
		add(toSS, BorderLayout.EAST);
		add(quit, BorderLayout.WEST);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == toSS)
			f.toSongSelect();
		if(e.getSource() == quit)
			System.exit(0);
	}
	
	/**
	 * @post draws the the images on the main menu
	 */
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image centerPic =  (new ImageIcon("lib/Images/MainBG.png")).getImage();
        ImageObserver io = null;
		g.drawImage(centerPic, 0, 0, getWidth(), getHeight(), io);
	}
}
