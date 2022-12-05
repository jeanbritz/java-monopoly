package monopoly;

public class Dice {
	
	private int first;
	private int second;
	

	/**
	 * 
	 * @return
	 */
	public Dice() {

	}
	
	/**
	 * 
	 * @return
	 */
	public int getOutcome() {
		return this.first + this.second;
	}
	
	/**
	 * Checks if the two dices has the same value, which implies that the player
	 * has thrown a double
	 * 
	 * @return true - thrown a double, false - different values
	 */
	public boolean hasThrownDouble() {
		return this.first == this.second;
	}
	
	/**
	 * Simulates the throw of the two dice.
	 * 
	 * @return The outcome of the 'throw'
	 */
	public int roll() {
		this.first = (int)(Math.random() * 6) + 1;
		this.second = (int)(Math.random() * 6) + 1;
		return getOutcome();
	}
}
