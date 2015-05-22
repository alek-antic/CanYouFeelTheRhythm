package music;

public class Score {

	private int total;
	private int multiplier;

	public Score() {
		total = 0;
		multiplier = 0;
	}

	/**
	 * @param int amount The amount to be added to the total. The amount
	 *        added will be the amount multiplied by the current multiplier
	 *        
	 * @post the total is increased by amount * multiplier
	 */
	public void addToScore(int amount) {
		total += amount * multiplier;
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
	}

	/**
	 * @post the multiplier is equal to 0
	 */
	public void resetMultiplier() {
		multiplier = 0;
	}

	
	
}
