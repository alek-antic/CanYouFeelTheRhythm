package screens;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import beats.Beat;
import beats.CircleBeat;
import beats.Masher;
import beats.Slider;
import music.Beatmap;
import music.Combo;

/**
 * The screen on which the game itself is drawn
 * 
 * @author Ben Bauer
 * @version 5/15/15
 *
 */
public class SongSelectScreen extends JPanel implements ActionListener {

	private RhythmFrame f;
	private JButton toMM;
	private JButton song1;
	private JButton song2;
	private Beatmap b;
	private Beatmap b2;

	/**
	 * Creates a new SongSelectScreen on the given RhythmFrame
	 * 
	 * @param frame
	 *            the frame that this screen is constructed around
	 */
	public SongSelectScreen(RhythmFrame frame) {
		super();
		f = frame;
		setBackground(Color.pink);
		setLayout(new BorderLayout());

		b = new Beatmap("orangefile.mp3");
		Combo comboOne = new Combo();
		Beat one = new CircleBeat("", 100, 100, 100, 972);
		Beat two = new CircleBeat("", 110, 110, 100, 1326);
		Beat three = new CircleBeat("", 115, 115, 100, 1824);
		Beat four = new CircleBeat("", 130, 130, 100, 2162);
		Beat five = new CircleBeat("", 130, 150, 100, 2318);
		Beat six = new CircleBeat("", 130, 130, 100, 2684);
		Beat seven = new CircleBeat("", 130, 130, 100, 3198);
		Beat eight = new CircleBeat("", 130, 170, 100, 3370);
		Beat nine = new CircleBeat("", 130, 130, 100, 3738);
		Beat ten = new CircleBeat("", 190,130, 100, 4225);
		Beat eleven = new CircleBeat("" , 130, 131, 100, 4561);
		Beat twelve = new CircleBeat("", 100, 100, 100, 4746);
		Beat thirteen = new CircleBeat("" , 150, 170, 100, 5112);
		Beat fourteen = new CircleBeat("",200,200,100,5434);
		Beat fifteen = new CircleBeat("",210,210,100, 5591);
		Beat sixteen = new CircleBeat("", 560, 570, 100, 5755);
		Beat seventeen = new CircleBeat("", 400, 700, 100, 5912);
		Beat eighteen = new CircleBeat("", 700, 400, 100,6294);
		Beat nineteen = new CircleBeat("", 500, 500, 100, 6446);
		Beat twenty = new CircleBeat("", 250, 750, 100, 6983);
		Beat twentyone = new CircleBeat("" , 700, 300, 100,7329);
		Beat twentytwo = new CircleBeat("", 500, 650, 100, 7497);
		Beat twentythree = new CircleBeat("" , 300, 200, 100, 7840);
		Beat twentyfour = new CircleBeat("" ,  725, 800, 100, 8323);
		Beat twentyfive = new CircleBeat("", 725, 700, 100, 8662);
		
		comboOne.addBeat(one);
		comboOne.addBeat(two);
		comboOne.addBeat(three);
		comboOne.addBeat(four);
		comboOne.addBeat(five);
		comboOne.addBeat(six);
		comboOne.addBeat(seven);
		comboOne.addBeat(eight);
		comboOne.addBeat(nine);
		comboOne.addBeat(ten);
		comboOne.addBeat(eleven);
		comboOne.addBeat(twelve);
		comboOne.addBeat(thirteen);
		comboOne.addBeat(fourteen);
		comboOne.addBeat(fifteen);
		comboOne.addBeat(sixteen);
		comboOne.addBeat(seventeen);
		comboOne.addBeat(eighteen);
		comboOne.addBeat(nineteen);
		comboOne.addBeat(twenty);
		comboOne.addBeat(twentyone);
		comboOne.addBeat(twentytwo);
		comboOne.addBeat(twentythree);
		comboOne.addBeat(twentyfour);
		comboOne.addBeat(twentyfive);
		
		Combo comboTwo = new Combo();
		
		
		Beat oneone = new CircleBeat("", 130, 130, 100, 4225);
		
		comboTwo.addBeat(oneone);
		b.addCombo(comboOne);
//		b.addCombo(comboTwo);

		b2 = new Beatmap("metronome.mp3");
		
		Combo combo = new Combo();
		Beat ichi = new CircleBeat("", 500, 500, 100, 500);
		Beat ni = new CircleBeat("", 600, 600, 100, 600);
		Beat san = new CircleBeat("", 700, 700, 100, 700);
		Beat yon = new CircleBeat("", 800, 800, 100, 800);
		Beat go = new CircleBeat("", 800, 600, 100, 900);
		Beat roku = new CircleBeat("", 800, 400, 100, 1000);
		Beat nana = new CircleBeat("", 500, 300, 100, 1100);
		Beat hachi = new CircleBeat("", 400, 100, 100, 1200);
		//Beat jyuu = new CircleBeat("", 900, 900, 100, 3738);
		//Beat kyuu = new CircleBeat("", 190, 130, 100, 4000);
		
		combo.addBeat(ichi);
		combo.addBeat(ni);
		combo.addBeat(san);
		combo.addBeat(yon);
		combo.addBeat(go);
		combo.addBeat(roku);
		combo.addBeat(nana);
		combo.addBeat(hachi);
		
		b2.addCombo(combo);
		
		ImageIcon titlePic = new ImageIcon("lib/Images/SelectText.png");
		JLabel title = new JLabel(titlePic);
		add(title, BorderLayout.CENTER);

		toMM = new JButton("Back");
		toMM.addActionListener(this);
		toMM.setOpaque(false);
		toMM.setContentAreaFilled(false);
		add(toMM, BorderLayout.SOUTH);  
		song1 = new JButton("    Tutorial    ");
		song2 = new JButton("Orange File");
		song1.addActionListener(this);
		song2.addActionListener(this);
		song1.setOpaque(false);
		song1.setContentAreaFilled(false);
		song2.setOpaque(false);
		song2.setContentAreaFilled(false);
		add(song1, BorderLayout.WEST);
		add(song2, BorderLayout.EAST);;

	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

		if (source == toMM)
			f.toMain();
		if (source == song2)
			f.toGame(b);
		if (source == song1)
			f.toGame(b2);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image centerPic =  (new ImageIcon("lib/Images/MainBG.png")).getImage();
        ImageObserver io = null;
		g.drawImage(centerPic, 0, 0, getWidth(), getHeight(), io);
	}
}
