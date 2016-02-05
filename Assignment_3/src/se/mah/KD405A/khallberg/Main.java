package se.mah.KD405A.khallberg;

import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<Bike> bikeList = new ArrayList<Bike>();
		
		Random sizeRandom = new Random();
		Random priceRandom = new Random();
		
		String[] testColors = {"röd","grå","blå","gul","grön"};
		// Sets random values to Bike in ArrayList bikelist
		for(int i = 0; i < 10; i= i+1){
			int randomSize = sizeRandom.nextInt(31) + 10; // random size set to range between 10 & 40 + 1 to include 10
			int randomPrice = priceRandom.nextInt(9001) + 1000; // random price set to range between 1000 & 10000 + 1 to include 1000
			String randomColors = (testColors[new Random().nextInt(testColors.length)]);
	
			bikeList.add(new Bike(randomColors,randomSize, randomPrice));  
		}
		// int index gets the place in the arrayList
		int index = 0;
		//Loops thrue the the arrayList and prints our it´s value in console
		for(Bike b:bikeList){
				System.out.println("Cykeln på plats nr: "+(index++)+" kostar: "+b.getPrice()+" är "+b.getColor()+" och "+ b.getSize()+ " tum stor.");
				
		}
	}
}
