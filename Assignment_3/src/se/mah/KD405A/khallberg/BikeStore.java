package se.mah.KD405A.khallberg;

import java.util.ArrayList;

public class BikeStore {
	
	public BikeStore(){
	}
	
	/**Creates an ArrayList filed with Bike, named bikes*/
	private ArrayList<Bike> bikes = new ArrayList<Bike>();
	
	/**Method that generates a String with specification of each bike in bikes arrayList   */
	public String getAllBikes(){
		String s = "";
		for (Bike b : bikes) {
			s = s + "Färg: "+ b.getColor()+"    Storlek: "+ b.getSize()+" tum "+"    Pris: "+b.getPrice()+" kr"+"\n";
		}
		return s;
	}
	/** Method that adds a Bike with specific color, size and price to the arrayList bikes */ 
	public void addBike(String color, int size, int price){
		Bike b = new Bike(color, size, price);
		this.bikes.add(b);
	}

}
