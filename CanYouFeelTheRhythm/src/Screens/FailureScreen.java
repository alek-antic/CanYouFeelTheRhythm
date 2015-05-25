package screens;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import music.Beatmap;

public class FailureScreen extends JPanel implements ActionListener, KeyListener{

	
	private JButton retry, back;
	private RhythmFrame f;
	private Beatmap b;
	
	
	public FailureScreen(RhythmFrame frame) {
		retry = new JButton("Retry");
		back = new JButton("Back to Menu");
		f = frame;
		
		retry.addActionListener(this);
		back.addActionListener(this);
		addKeyListener(this);
		
		
		BoxLayout boxes = new BoxLayout(this, BoxLayout.X_AXIS);		
		setLayout(boxes);
		
		add(Box.createHorizontalStrut(300));
		
		Box box = Box.createVerticalBox();
		
		box.add(Box.createVerticalStrut(400));
		box.add(retry);
		box.add(Box.createVerticalStrut(100));
		box.add(back);
		
		add(box);
		
		add(Box.createHorizontalStrut(300));
		
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
