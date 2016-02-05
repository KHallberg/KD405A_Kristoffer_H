package se.mah.KD405A.khallberg;

public class BikeStoreTest {

	public static void main(String[] args) {
	
		
		BikeStore bikeStore = new BikeStore();
		
		String color = "röd";
		int size = 14;
		int price = 1200;
		bikeStore.addBike(color, size, price);
		
		String color1 = "grå";
		int size1 = 8;
		int price1 = 233000;
		bikeStore.addBike(color1, size1, price1);
		
		
		System.out.println(bikeStore.getAllBikes());
		
	}

}
