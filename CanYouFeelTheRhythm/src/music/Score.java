package music;

import java.awt.Graphics;
import java.awt.image.ImageObserver;

import javax.swing.ImageIcon;

import beats.Beat;

public class Score {

	private int total;
	private int multiplier;
	private int maxScore;
	private int threeHundreds, oneHundreds, fifties, miss, maxMult;

	public Score() {
		total = 0;
		multiplier = 0;
		maxScore = 0;
		threeHundreds = 0;
		oneHundreds = 0;
		fifties = 0;
		miss = 0;
		maxMult = 0;
	}

	/**
	 * @param amount
	 *            The amount to be added to the total. The amount added will be
	 *            the amount multiplied by the current multiplier
	 * 
	 * @post the total is increased by amount * multiplier
	 */
	public void addToScore(int amount) {
		total += amount * multiplier;
		addToMax();
		if (amount == 300)
			threeHundreds++;
		else if (amount == 100)
			oneHundreds++;
		else if (amount == 50)
			fifties++;
		else if (amount == 0)
			miss++;
	}

	private void addToMax() {
		maxScore += 300 * multiplier;
	}

	/**
	 * @post sets the total to 0 and the multiplier to 0
	 */
	public void resetValues() {
		total = 0;
		multiplier = 0;
	}

	/**
	 * @post adds one to the current multiplier
	 */
	public void incrementMultiplier() {
		multiplier++;
		if (maxMult < multiplier)
			maxMult = multiplier;
	}

	/**
	 * @post the multiplier is equal to 0
	 */
	public void resetMultiplier() {
		multiplier = 0;
	}

	public int getTotal() {
		return total;
	}

	/**
	 * 
	 * @return the percentage of the total points at that time that the player
	 *         has gotten. For example, after 3 CircleBeats, the maximum score
	 *         is 1800. If the player has scored 300, 100, and 50 (in that
	 *         order, and without reseting his multiplier), he would have 650
	 *         points, and this would return 36.11%.
	 */
	public double calcPercentage() {
		return (int) (10000 * (double) (total) / maxScore) / 100.0;
	}

	public int getMultiplier() {
		return multiplier;
	}

	public int getMaxMult() {
		return maxMult;
	}

	public int getThrees() {
		return threeHundreds;
	}

	public int getOnes() {
		return oneHundreds;
	}

	public int getFifties() {
		return fifties;
	}

	public void reset() {
		total = 0;
		multiplier = 0;
		maxMult = 0;
		maxScore = 0;
		threeHundreds = 0;
		oneHundreds = 0;
		fifties = 0;
		miss = 0;
	}

}
