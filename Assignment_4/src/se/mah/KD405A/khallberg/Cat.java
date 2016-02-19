package se.mah.KD405A.khallberg;

public class Cat extends Mammal {

	private int numberOfLives;

	public Cat(String latinName, int gestationTime, int numberOfLives) {
		super(latinName, gestationTime);  //variables from the superclass
		this.setNumberOfLives(numberOfLives); //// sets numberOfLives with the method setNumberOfLIves
	}
	/**Method the returns the value of number of lives */
	public int getNumberOfLives() {
		return numberOfLives;
	}
	/** Method the sets value to numberOfLives*/
	public void setNumberOfLives(int numberOfLives) {
		this.numberOfLives = numberOfLives;
	}
	/**Method that gets the info from Cat and generate a String with the  latin name, gestation time and number of Lives. */
	@Override
	public String getInfo() {
		String info = "The cat with the latin name \""+ latinName+ "\" nurses for " + gestationTime +" months and has " + getNumberOfLives() +" lives." + "\n";
		return info;
	}

}
