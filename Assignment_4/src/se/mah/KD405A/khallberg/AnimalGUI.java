package se.mah.KD405A.khallberg;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class AnimalGUI extends JFrame {

	private JPanel contentPane;
	private ArrayList<Animal> animalList = new ArrayList();
	//private String animalInfo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalGUI frame = new AnimalGUI();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void addAnimals(){
		this.animalList.add(new Dog("Canis lupus", 3, true));
		this.animalList.add(new Dog("Canis lupus", 8, false, "Selma"));
		this.animalList.add(new Cat("Felis catus", 4, 23));
		this.animalList.add(new Snake("Vipera berus", true));
		this.animalList.add(new Snake("Anguis fragilis", false));
		this.animalList.add(new Dog("Canis lupus", 6, true, "Pelle svanslös"));
	}
	
	/**
	 * Create the frame.
	 */
	public AnimalGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 728, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 6, 716, 266);
		contentPane.add(scrollPane);
		
		JTextArea txtrAnimallist = new JTextArea();
		scrollPane.setViewportView(txtrAnimallist);
		addAnimals();
		for(Animal a: animalList){
			String animalInfo = a.getInfo();
		System.out.println(animalInfo);
		txtrAnimallist.append(animalInfo);
		}
	}
}
