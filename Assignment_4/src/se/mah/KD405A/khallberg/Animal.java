package se.mah.KD405A.khallberg;

public abstract class Animal {
	
	protected String latinName;
	private String friendlyName = "noname";
	
	public Animal(String latinName){
		this.latinName = latinName;
	}
	
	public abstract String getInfo();
	/**Method to set friendlyName */
	public void setFriendlyName(String name){
		this.friendlyName = name;
	}
	/**Method to get friendlyName */
	public String getFriendlyName(){
		return this.friendlyName;
	}
}
