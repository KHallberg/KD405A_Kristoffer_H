package se.mah.KD405A.khallberg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtStorlek;
	private JTextField txtFrg;
	private JTextField txtPris;
	
	private BikeStore bikeStore;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		bikeStore = new BikeStore();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLagersaldo = new JLabel("Lagersaldo");
		lblLagersaldo.setBounds(242, 92, 84, 16);
		contentPane.add(lblLagersaldo);
		
		txtStorlek = new JTextField();
		txtStorlek.setText("8-28");
		txtStorlek.setBounds(34, 110, 93, 26);
		contentPane.add(txtStorlek);
		txtStorlek.setColumns(10);
		
		txtFrg = new JTextField();
		txtFrg.setText("färg");
		txtFrg.setBounds(34, 138, 93, 26);
		contentPane.add(txtFrg);
		txtFrg.setColumns(10);
		
		txtPris = new JTextField();
		txtPris.setText("0-30000");
		txtPris.setBounds(34, 166, 93, 26);
		contentPane.add(txtPris);
		txtPris.setColumns(10);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(242, 113, 416, 254);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		
		JButton btnLggTill = new JButton("Lägg till");
		btnLggTill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bikeColor = txtFrg.getText();
				int bikeSize = Integer.parseInt(txtStorlek.getText()); // string from textField Storlek to int
				int bikePrice = Integer.parseInt(txtPris.getText());	// string from textField Pris to int
				bikeStore.addBike(bikeColor, bikeSize, bikePrice);		// adds bikes to the arrayList bikes with the method .addBike
				textArea.setText(bikeStore.getAllBikes());			// puts the string with the bikes in textArea with the method .getAllBikes
				
			}
			
		});
		btnLggTill.setBounds(30, 204, 102, 29);
		contentPane.add(btnLggTill);
		
		JLabel lblStorlek = new JLabel("Storlek");
		lblStorlek.setBounds(139, 115, 91, 16);
		contentPane.add(lblStorlek);
		
		JLabel lblFrg = new JLabel("Färg");
		lblFrg.setBounds(139, 143, 61, 16);
		contentPane.add(lblFrg);
		
		JLabel lblPris = new JLabel("Pris");
		lblPris.setBounds(139, 171, 61, 16);
		contentPane.add(lblPris);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(GUI.class.getResource("/img/TheBikeStore.jpg")));
		lblNewLabel.setBounds(0, 0, 720, 428);
		contentPane.add(lblNewLabel);
		
		
	}
}
