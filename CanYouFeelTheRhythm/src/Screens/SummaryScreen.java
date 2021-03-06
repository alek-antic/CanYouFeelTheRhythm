package screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import music.Beatmap;
import music.Score;

/**
 * The class to represent the summary screen of the player's performance after a beatmap
 * @author Alek
 *
 */
public class SummaryScreen extends JPanel implements ActionListener {

	private RhythmFrame f;
	private Beatmap b;
	private Score s;
	private JButton button;

	/**
	 * Creates a new instance of a SummaryScreen
	 * @param frame The frame to put this SummmaryScreen on
	 */
	public SummaryScreen(RhythmFrame frame) {
		super();

		this.f = frame;

		setBackground(Color.green);
		setLayout(new BorderLayout());

		button = new JButton("To Song Selection");
		button.addActionListener(this);

		add(button, BorderLayout.SOUTH);
	}

	/**
	 * @post draws the summary screen
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int width = getWidth();
		int height = getHeight();

		Image three = (new ImageIcon("lib/Images/300.png")).getImage();
		Image one = (new ImageIcon("lib/Images/100.png")).getImage();
		Image fifty = (new ImageIcon("lib/Images/50.png")).getImage();

		g.setFont(new Font("Monospaced", Font.BOLD, 54));
		g.setColor(new Color(75, 84, 200));

		g.drawImage(three, 0, 0, 150, 100, this);
		g.drawString(": x" + s.getThrees(), 150, 67);

		g.setColor(new Color(217, 35, 73));
		g.drawImage(one, 0, 100, 150, 100, this);
		g.drawString(": x" + s.getOnes(), 150, 167);

		g.setColor(new Color(220, 38, 236));
		g.drawImage(fifty, 0, 200, 150, 100, this);
		g.drawString(": x" + s.getFifties(), 150, 267);
		
		g.setColor(new Color(147,11,11));
		g.drawString("Miss: x" + s.getMisses(), 25, 367);

		g.setColor(new Color(77, 167, 181));
		g.drawString("Max Combo: " + s.getMaxMult(), 25, 467);
		
		g.setColor(new Color(128,128,128));
		g.drawString(s.getTotal() + "", 550, 75);
		
		g.setColor(new Color(128,0,128));
		g.drawString(s.calcPercentage() + "%", 550, 467);

		
		String grade = s.calcGrade();
		g.drawImage((new ImageIcon("lib/Images/" + grade+".png")).getImage(), 550,70, this);
		
	}

	/**
	 * 
	 * @param b the beatmap to be received
	 */
	public void recieveBeatmap(Beatmap b) {
		this.b = b;
		s = b.getScore();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		f.toSongSelect();
	}
}
