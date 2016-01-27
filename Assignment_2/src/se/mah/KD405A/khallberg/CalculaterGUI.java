package se.mah.KD405A.khallberg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CalculaterGUI extends JFrame {

	private JPanel contentPane;

	private Calculator myCalculator;
	private JTextField textField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculaterGUI frame = new CalculaterGUI();
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
	public CalculaterGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 393, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(6, 21, 375, 56);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("86");
		button.setBounds(6, 111, 117, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("8");
		button_1.setBounds(6, 152, 117, 29);
		contentPane.add(button_1);
		
		JButton btnAddera = new JButton("Addera");
		btnAddera.setBounds(135, 111, 117, 29);
		contentPane.add(btnAddera);
		
		JButton btnSubtrera = new JButton("Subtrahera");
		btnSubtrera.setBounds(135, 152, 117, 29);
		contentPane.add(btnSubtrera);
		
		JButton btnMultiplicera = new JButton("Multiplicera");
		btnMultiplicera.setBounds(264, 111, 117, 29);
		contentPane.add(btnMultiplicera);
		
		JButton btnNewButton = new JButton("Resultat");
		btnNewButton.setBounds(264, 152, 117, 29);
		contentPane.add(btnNewButton);

		myCalculator = new Calculator();

	
	}
}
