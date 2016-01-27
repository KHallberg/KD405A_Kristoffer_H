package se.mah.KD405A.khallberg;

public class House {
	private int yearBuilt;
	private int size;
	private final int minSize = 10;
	private final int maxSize = 1000;
	private final int yearOldest = 1800;
	private final int yearNewest = 2015;

	public House(int yearBuilt, int size) {
		//this.yearBuilt = yearBuilt;
		if(size>=minSize && size<=maxSize){
			this.size = size;	
		}
		else{
			this.size = 0;
		}
		if(yearBuilt>=yearOldest && yearBuilt<=yearNewest){
			this.yearBuilt = yearBuilt;
		}
		else{
			this.yearBuilt = 0;
		}
			
	}

	public int getYearBuilt(){
		return this.yearBuilt;
	}
	public int getSize(){
		return this.size;
	}
	
}
