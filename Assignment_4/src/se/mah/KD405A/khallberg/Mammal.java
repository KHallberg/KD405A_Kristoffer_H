package se.mah.KD405A.khallberg;

public abstract class Mammal extends Animal {
	
	protected int gestationTime;
	
	public Mammal(String latinName, int gestationTime){
		super(latinName);
		this.gestationTime = gestationTime;
	}
	public int getGestationTime(){
		return this.gestationTime;
	}

}
