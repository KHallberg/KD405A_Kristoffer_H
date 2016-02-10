package se.mah.KD405A.khallberg;

public class Snake extends Animal {

	private boolean poisonous = false;

	public Snake(String latinName, boolean poisonous) {
		super(latinName);
		this.poisonous = poisonous;
	}

	public boolean isPoisonous() {
		return this.poisonous;
	}

	@Override
	public String getInfo() {
		String poisonousOrNot = "not poisonous";
		if(isPoisonous()){
			poisonousOrNot = "poisonous";
		}
		String info = "The snake with the latin name "+latinName + " is " +poisonousOrNot +"\n";
		return info;
	}

}
