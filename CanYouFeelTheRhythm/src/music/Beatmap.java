package music;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.Timer;

import beats.Beat;

public class Beatmap implements Runnable {

	
	private Song song;
	private Score score;
	private ArrayList<Combo> beatCombos;
	private Timer time;
	private long currentTime;
	private DrawOnAble gamescreen
	
	
	public Beatmap(String filename) {
		beatCombos = new ArrayList<Combo>();
		time = new Timer(1, new TimerHandler());
		song = new Song(filename);
		currentTime = 0l;
		
	}
	
	
	@Override
	public void run() {
		time.start();
		currentTime = 0;
		
	}
	
	
	public void addCombo(Combo c) {
		beatCombos.add(c);
	}
	
	
	
	
	private class TimerHandler implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			currentTime++;
			for(Combo c: beatCombos) {
				ArrayList<Beat> beats = c.getBeatArray();
				for(Beat b : beats) {
					if(b.getTime() - b.getApproach() == currentTime) {
						gamescreen.draw(b);
					}
				}
			}
			
		}
		
	}
	
	
	
	
	
	
	
	private class KeyHandler implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	

	
	
	private class MouseHandler implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}





	
	
}
