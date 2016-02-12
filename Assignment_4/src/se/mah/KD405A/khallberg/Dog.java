package se.mah.KD405A.khallberg;

public class Dog extends Mammal{
	
	private boolean stupid;

	public Dog(String latinName, int gestationTime, boolean stupid) {
		super(latinName, gestationTime); // variables from the superclass 
		this.stupid=stupid;
	}
	public Dog(String latinName, int gestationTime, boolean stupid, String friendlyName) {
		this(latinName, gestationTime, stupid); // variables from the constructor above
		this.setFriendlyName(friendlyName);  // sets friendlyName with the method setFriendlyName
	}
	/**Method that return the value of the boolean stupid */
	public boolean isStupid(){
		return this.stupid;
	}
	/**Method that gets the info from Dog and generate a String with the friendly name, latin name, gestation time and if it stupid or not. */
	@Override
	public String getInfo() {
		String smartOrStupid = "not stupid";
		if(stupid==true){
			smartOrStupid = "stupid";
		}
		//String smartOrStupid = isStupid() ? "stupid" : "not stupid"; // other way to check the boolean 
		String info = "The dog named \"" + getFriendlyName()+ "\" with the latin name \""+ latinName+"\" nurses for "+ gestationTime + " months and is " +smartOrStupid + "."+"\n";
		return info;
	}

}
