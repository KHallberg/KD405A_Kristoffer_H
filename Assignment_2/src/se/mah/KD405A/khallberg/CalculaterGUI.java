package se.mah.KD405A.khallberg;

import java.awt.Color;
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
import java.awt.Font;

public class CalculaterGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private Calculator myCalculator;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		 try {
		    	UIManager.setLookAndFeel(new MetalLookAndFeel());// allows background color on jbuttons on Mac
		    }	
		    catch(Exception e) {}								//as above
		 
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
		setTitle("Min första miniräknare");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 388, 455);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(175, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		myCalculator = new Calculator();
		
		textField = new JTextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 40));
		textField.setBounds(6, 12, 375, 78);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(CalculaterGUI.class.getResource("/img/86.png")));
		//button.setOpaque(true);
		button.setBackground(new Color(176, 196, 222));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("86");
				myCalculator.numberButtonPressed(86);
			}
		});
		button.setBounds(6, 111, 117, 67);
		contentPane.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(CalculaterGUI.class.getResource("/img/8.png")));
		button_1.setBackground(new Color(176, 196, 222));
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("8");
				myCalculator.numberButtonPressed(8);
			}
		});
		button_1.setBounds(6, 190, 117, 67);
		contentPane.add(button_1);
		
		JButton btnAddera = new JButton("Addera");
		btnAddera.setBackground(new Color(255, 215, 0));
		btnAddera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("+");
				myCalculator.plus();
			}
		});
		btnAddera.setBounds(135, 111, 117, 29);
		contentPane.add(btnAddera);
		
		JButton btnSubtrera = new JButton("Subtrahera");
		btnSubtrera.setBackground(new Color(221, 160, 221));
		btnSubtrera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("-");
				myCalculator.minus();
			}
		});
		btnSubtrera.setBounds(135, 152, 117, 29);
		contentPane.add(btnSubtrera);
		
		JButton btnMultiplicera = new JButton("Multiplicera");
		btnMultiplicera.setBackground(new Color(255, 165, 0));
		btnMultiplicera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("*");
				myCalculator.mult();
			}
		});
		btnMultiplicera.setBounds(264, 111, 117, 29);
		contentPane.add(btnMultiplicera);
		
		JButton btnNewButton = new JButton("Resultat");
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.equals();
				int i = myCalculator.getResult();
				textField.setText(String.valueOf(i));
			}
		});
		btnNewButton.setBounds(135, 190, 246, 67);
		contentPane.add(btnNewButton);
		
		JButton btnClear = new JButton("Rensa");
		btnClear.setBackground(new Color(178, 34, 34));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				myCalculator.clear();
			}
		});
		btnClear.setBounds(264, 152, 117, 29);
		contentPane.add(btnClear);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CalculaterGUI.class.getResource("/img/Barbapappa.png")));
		lblNewLabel.setBounds(41, 269, 309, 146);
		contentPane.add(lblNewLabel);

		

	
	}
}
