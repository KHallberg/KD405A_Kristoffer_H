package se.mah.KD405A.khallberg;

public class Cat extends Mammal {

	private int numberOfLifes;

	public Cat(String latinName, int gestationTime, int numberOfLifes) {
		super(latinName, gestationTime);  //variables from the superclass
		this.setNumberOfLifes(numberOfLifes); //// sets numberOfLives with the method setNumberOfLIves
	}
	/**Method the returns the value of number of lives */
	public int getNumberOfLifes() {
		return numberOfLifes;
	}
	/** Method the sets value to numberOfLives*/
	public void setNumberOfLifes(int numberOfLifes) {
		this.numberOfLifes = numberOfLifes;
	}
	/**Method that gets the info from Cat and generate a String with the  latin name, gestation time and number of Lives. */
	@Override
	public String getInfo() {
		String info = "The cat with the latin name \""+ latinName+ "\" nurses for " + gestationTime +" months and has " + getNumberOfLifes() +" lives." + "\n";
		return info;
	}

}
