package se.mah.KD405A.khallberg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculaterGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private Calculator myCalculator;
	
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
		myCalculator = new Calculator();
		
		textField = new JTextField();
		textField.setBounds(6, 21, 375, 56);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("86");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("86");
				myCalculator.numberButtonPressed(86);
			}
		});
		button.setBounds(6, 111, 117, 29);
		contentPane.add(button);
		
		JButton button_1 = new JButton("8");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("8");
				myCalculator.numberButtonPressed(8);
			}
		});
		button_1.setBounds(6, 152, 117, 29);
		contentPane.add(button_1);
		
		JButton btnAddera = new JButton("Addera");
		btnAddera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("+");
				myCalculator.plus();
			}
		});
		btnAddera.setBounds(135, 111, 117, 29);
		contentPane.add(btnAddera);
		
		JButton btnSubtrera = new JButton("Subtrahera");
		btnSubtrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("-");
				myCalculator.minus();
			}
		});
		btnSubtrera.setBounds(135, 152, 117, 29);
		contentPane.add(btnSubtrera);
		
		JButton btnMultiplicera = new JButton("Multiplicera");
		btnMultiplicera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("*");
				myCalculator.mult();
			}
		});
		btnMultiplicera.setBounds(264, 111, 117, 29);
		contentPane.add(btnMultiplicera);
		
		JButton btnNewButton = new JButton("Resultat");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.equals();
				int i = myCalculator.getResult();
				textField.setText(String.valueOf(i));
			}
		});
		btnNewButton.setBounds(264, 152, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				myCalculator.clear();
			}
		});
		btnClear.setBounds(135, 193, 117, 29);
		contentPane.add(btnClear);

		

	
	}
}
