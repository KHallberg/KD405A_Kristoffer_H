
public class Cat {

	
		private String color ="gray";// start färgen kommer vara gray
		private String name = "noname";
		private int age = 0;
		private static int MAX_AGE = 220;// Age in months
		
		
		// Constructors
		/** creat cat*/
		
		public Cat(){
			this.name = "Knodden";
		}
		public Cat(String color, String name){
			this.color = color;
			this.name = name;
		}
	
		
		//Methods
		
		public String getColor(){
			return this.color;
		}
		
		public String getName(){
			return this.name;
		}
		public void setAge(int age){
			if (age>= 0 && age<= MAX_AGE){
				this.age = age;
			}
		}
		public int getAge(){
			return this.age;
		}

}
