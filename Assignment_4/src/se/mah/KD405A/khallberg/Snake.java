package se.mah.KD405A.khallberg;

public class Snake extends Animal {

	private boolean poisonous = false;

	public Snake(String latinName, boolean poisonous) {
		super(latinName);
		this.poisonous = poisonous;
	}
	/**Method that checks the value of the boolean poisonous */
	public boolean isPoisonous() {
		return this.poisonous;
	}
	/**Method that gets the info from snake and generate a String with the latin name and if it poisonous or not */
	@Override
	public String getInfo() {
		String poisonousOrNot = "not poisonous";
		if(isPoisonous()){
			poisonousOrNot = "poisonous";
		}
		String info = "The snake with the latin name \""+latinName + "\" is " +poisonousOrNot +"."+"\n";
		return info;
	}

}
