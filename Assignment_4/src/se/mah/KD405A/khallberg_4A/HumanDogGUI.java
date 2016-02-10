package se.mah.KD405A.khallberg_4A;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HumanDogGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtNamn;
	private JTextField txtHund;
	private JTextField txtInfo;
	private JTextField txtError;
	
	private Human h;
	private Dog d;
	private boolean humanExist = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		setBounds(100, 100, 693, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtNamn = new JTextField();
		txtNamn.setText("namn");
		txtNamn.setBounds(20, 25, 130, 26);
		contentPane.add(txtNamn);
		txtNamn.setColumns(10);
		
		txtHund = new JTextField();
		txtHund.setText("hund");
		txtHund.setBounds(20, 77, 130, 26);
		contentPane.add(txtHund);
		txtHund.setColumns(10);
		
		txtError = new JTextField();
		txtError.setText("error");
		txtError.setBounds(20, 224, 371, 26);
		contentPane.add(txtError);
		txtError.setColumns(10);
		
		txtInfo = new JTextField();
		txtInfo.setText("info");
		txtInfo.setBounds(20, 187, 647, 26);
		contentPane.add(txtInfo);
		txtInfo.setColumns(10);
		
		JButton btnNewHuman = new JButton("New Human");
		btnNewHuman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtError.setText("");
				txtInfo.setText("");
				if(txtNamn.getText().length()>=3){         //kollar så att namnet är minst 3 bokstäver
					String newHuman = txtNamn.getText();
					h = new Human(newHuman);				// skapar en ny människa och ger den namnet
				
					humanExist = true;
				}
				else{
					txtError.setText("namnet är för kort");	// om fel 
				}
			}
		});
		btnNewHuman.setBounds(195, 25, 117, 29);
		contentPane.add(btnNewHuman);
		
		JButton btnBuyDog = new JButton("Buy Dog");
		btnBuyDog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtError.setText("");
				txtInfo.setText("");
				
				if(humanExist == true){						//kollar om det finns en människa
					String hund = txtHund.getText();
					
				d = new Dog(hund);							//skapar ny dog och ger den namn från txtHund
					h.buyDog(d);							// dog får en ägare
				System.out.println("namnet är : " +h.getName());
				System.out.println("Hundnamnet är : " +txtHund.getText());
				System.out.println("hund : " + hund);
				
				}
				else{
					txtError.setText("du är ingen människa");
				}
			}
		});
		btnBuyDog.setBounds(195, 77, 117, 29);
		contentPane.add(btnBuyDog);
		
		JButton btnPrintInfo = new JButton("Print Info");
		btnPrintInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtError.setText("");
				txtInfo.setText("");
				if (humanExist == true){
				txtInfo.setText(h.getInfo());
				System.out.println("test : " +h.getInfo());
				}
				humanExist = false;
			}
		});
		btnPrintInfo.setBounds(195, 128, 117, 29);
		contentPane.add(btnPrintInfo);
		
		
		
		
	}
}
