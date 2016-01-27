package se.mah.KD405A.khallberg;

import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class HouseGUI extends JFrame {

	private JPanel contentPane;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HouseGUI frame = new HouseGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HouseGUI() {
		setTitle("Uppgift 1 Huslista");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(5, 5, 597, 411);
		contentPane.add(scrollPane);
		
		//uppgift 1.2 
		
		House house1 = new House(1710, 57);
		House house2 = new House(1910, 8);
		House house3 = new House(2010, 557);
		
		//uppgift 1.3
		House[] houses;
		houses = new House [10];
		
		houses[0] = new House(1987,451);
		houses[1] = new House(1878,874);
		houses[2] = new House(2012,75);
		houses[3] = new House(1851,625);
		houses[4] = new House(2014,973);
		houses[5] = new House(1889,234);
		houses[6] = new House(1956,231);
		houses[7] = new House(1845,79);
		houses[8] = new House(1997,419);
		houses[9] = new House(2000,504);
		
		//uppgift 1.4
		ArrayList<House> houseList = new ArrayList<House>();
		
		Random sizeRandom = new Random();
		Random yearRandom = new Random();
			
		for(int i = 0; i < 100; i= i+1){
			int randomYear = yearRandom.nextInt(216) + 1800; // random year set to range between 1800 & 2015 + 1 to include 1800
			int randomSize = sizeRandom.nextInt(991) + 10; // random size set to range between 10 & 1000 + 1 to include 10
			houseList.add(new House(randomYear,randomSize));  
		}
		
		JTextArea txtr = new JTextArea();
		txtr.setText("");
		scrollPane.setViewportView(txtr);
		
		//Uppgift 1.2 print
		String b;
		String c;
		String d;
		
		String a = "Uppgift 1.2:\n";
		// checks if the YearBuilt and Size is valid if not string value is set to an error message
		if(house1.getYearBuilt() !=0 && house1.getSize() !=0 ){ 
		b = "Ett hus är byggt " +house1.getYearBuilt()+" som är "+house1.getSize()+" kvm stort.\n";
		}
		else{
		b ="Inget hus blev byggt \nFel år eller storlek, måste vara byggt mellan 1800 och 2015 och mellan 10 och 1000 kvm.\n";
		}
		if(house2.getYearBuilt() !=0 && house2.getSize() !=0 ){
			c = "Ett hus är byggt " +house2.getYearBuilt()+" och är "+house2.getSize()+" kvm stort.\n";
			}
			else{
			c ="Inget hus blev byggt \nFel år eller storlek, måste vara byggt mellan 1800 och 2015 och mellan 10 och 1000 kvm.\n";
			}
		if(house3.getYearBuilt() !=0 && house3.getSize() !=0 ){
			d = "Ett hus är byggt " +house3.getYearBuilt()+" och är "+house3.getSize()+" kvm stort.\n";
			}
			else{
			d ="Inget hus blev byggt \nFel år eller storlek, måste vara byggt mellan 1800 och 2015 och mellan 10 och 1000 kvm.\n";
			}
		
		txtr.append(a+b+c+d);
	    System.out.println(a+b+c+d);
	    
		//Uppgift 1.3 print
		txtr.append("Uppgift 1.3:\n");
		for(int i=0; i<houses.length; i=i+1){
			// checks if the YearBuilt and Size is valid if not error message
			if(houses[i].getYearBuilt() !=0 && houses[i].getSize() !=0 ){
				txtr.append("Hus nummer "+i+" är byggt "+houses[i].getYearBuilt()+" och är "+houses[i].getSize()+" kvm stort.\n");
			}
			else{
				txtr.append("Inget hus blev byggt \nFel år eller storlek, måste vara byggt mellan 1800 och 2015 och mellan 10 och 1000 kvm.\n"); 
			}
		}
		
		//Uppgift 1.4 print
		txtr.append("Uppgift 1.4:\n");
		// checks if the YearBuilt and Size is valid if not error message
		for(House h:houseList){
			if(h.getYearBuilt() !=0 && h.getSize() !=0 ){
				txtr.append("Ett hus är byggt "+h.getYearBuilt()+" och är "+h.getSize()+" kvm stort.\n");
			}
			else{
				txtr.append("Inget hus blev byggt \nFel år eller storlek, måste vara byggt mellan 1800 och 2015 och mellan 10 och 1000 kvm.\n"); 
			}
		}

		
	}
}
