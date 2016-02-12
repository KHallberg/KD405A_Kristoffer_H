package se.mah.KD405A.khallberg_4A;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class HumanDogGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtNamn;
	private JTextField txtHund;
	private JTextField txtInfo;
	private JTextField txtError;
	
	private Human h;
	private Dog d;
	private boolean humanExist = false;
	
	private final JLabel lblNewLabel = new JLabel("");
	private JLabel lblInformation;
	private JLabel lblErrorMessage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
		    	UIManager.setLookAndFeel(new MetalLookAndFeel());// allows background color on jbuttons on Mac
		    }	
		    catch(Exception e) {}	
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HumanDogGUI frame = new HumanDogGUI();
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
	public HumanDogGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 390, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblErrorMessage = new JLabel("Error message");
		lblErrorMessage.setBounds(15, 218, 102, 16);
		contentPane.add(lblErrorMessage);
		
		lblInformation = new JLabel("Information");
		lblInformation.setBounds(15, 156, 88, 16);
		contentPane.add(lblInformation);
		
		txtNamn = new JTextField();
		txtNamn.setText("Name");
		txtNamn.setBounds(66, 39, 130, 26);
		contentPane.add(txtNamn);
		txtNamn.setColumns(10);
		
		txtHund = new JTextField();
		txtHund.setText("Dogname");
		txtHund.setBounds(66, 77, 130, 26);
		contentPane.add(txtHund);
		txtHund.setColumns(10);
		
		txtError = new JTextField();
		txtError.setBounds(12, 235, 345, 26);
		contentPane.add(txtError);
		txtError.setColumns(10);
		
		txtInfo = new JTextField();
		txtInfo.setBounds(12, 180, 345, 26);
		contentPane.add(txtInfo);
		txtInfo.setColumns(10);
		
		JButton btnNewHuman = new JButton("New Human");
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtError.setText("");
				txtInfo.setText("");
				if(txtNamn.getText().length()>=3){         //checks if the name length
					String newHuman = txtNamn.getText();	
					h = new Human(newHuman);				// creates a new human if the name at least 3 letters
					humanExist = true;
				}
				else{
					txtError.setText("namnet är för kort");	// error message if the name is to short
				}
			}
		});
		btnNewHuman.setBounds(208, 39, 117, 29);
		contentPane.add(btnNewHuman);
		
		JButton btnBuyDog = new JButton("Buy Dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtError.setText("");
				txtInfo.setText("");
				
				if(humanExist == true){						//checks that a human is created
					String hund = txtHund.getText();
					
				d = new Dog(hund);							//creates a new dog
					h.buyDog(d);							// the dog gets a owner
				System.out.println("namnet är : " +h.getName());
				System.out.println("Hundnamnet är : " +txtHund.getText());
				System.out.println("hund : " + hund);
				
				}
				else{
					txtError.setText("Du måste skapa en människa för att köpa en hund.");
				}
			}
		});
		btnBuyDog.setBounds(208, 77, 117, 29);
		contentPane.add(btnBuyDog);
		
		JButton btnPrintInfo = new JButton("Print Info");
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtError.setText("");
				txtInfo.setText("");
				txtNamn.setText("");
				txtHund.setText("");
				if (humanExist == true){
				txtInfo.setText(h.getInfo());
				System.out.println("test : " +h.getInfo());
				}
				humanExist = false;		// resets humanExsist
			}
		});
		btnPrintInfo.setBounds(61, 115, 264, 29);
		contentPane.add(btnPrintInfo);
		lblNewLabel.setIcon(new ImageIcon(HumanDogGUI.class.getResource("/se/mah/KD405A/khallberg_4A/img/DogBackground.jpg")));
		lblNewLabel.setBounds(0, 0, 390, 402);
		contentPane.add(lblNewLabel);	
	}
}
