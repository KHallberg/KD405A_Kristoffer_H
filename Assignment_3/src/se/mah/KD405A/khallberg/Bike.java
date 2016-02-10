package se.mah.KD405A.khallberg;

public class Bike {
	
	private String color;
	private int price;
	private int size;
	
	

	// Constructors
	
	public Bike(String color, int size){
		/*if(Arrays.asList(Constants.COLORS).contains(color)){
		this.color = color;
	}
	else{
		this.color = "omålad";
	}*/
		// Loops  thrue Contants.COLORS to check if color equals value in array
		boolean contains = false;
		
		for(int i=0; i<Constants.COLORS.length; i++){
			if(Constants.COLORS[i].equals(color)){
				contains = true;
			}
		}
		if(contains == true){
			this.color = color;
		}
		else{
			this.color = "omålad";
		}
		//checks if size is vaild, if not size set to 0
		if(size>= Constants.MIN_SIZE && size<= Constants.MAX_SIZE){
			this.size = size;
		}
		else{
			this.size = 0;
		}
	}
	
	public Bike(String color, int size, int price){
				/*if(Arrays.asList(Constants.COLORS).contains(color)){
					this.color = color;
				}
				else{
					this.color = "omålad";
				}*/
		// Loops  thrue Contants.COLORS to check if color equals value in array
		boolean contains = false;
		
		for(int i=0; i<Constants.COLORS.length; i++){
			if(Constants.COLORS[i].equals(color)){
				contains = true;
			}
		}
			if(contains == true){
				this.color = color;
			}
			else{
				this.color = "omålad";
			}
			//checks if size is vaild, if not price set to 0
		if(size>= Constants.MIN_SIZE && size<= Constants.MAX_SIZE){
			this.size = size;
		}
		else{
			this.size = 0;
		}
		//checks if price is vaild, if not price set to 0
		if(price>= Constants.MIN_PRICE && price<= Constants.MAX_PRICE){
			this.price = price;
		}
		else{
			this.price = 0;
		}
	}
	
//Methods
	/**Returns the color*/
	public String getColor(){
		return this.color;
	}
	/**Returns the size*/
	public int getSize(){
		return this.size;
	}
	/**Returns the price*/
	public int getPrice(){
		return this.price;
	}
	/**Sets the price*/  // ska även kollas om priset är rätt
	public void setPrice(int price){
		this.price = price;
	}

}
