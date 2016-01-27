import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CalculatorGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	Calculator myCalculator;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI frame = new CalculatorGUI();
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
	public CalculatorGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		myCalculator = new Calculator();

		textField = new JTextField();
		textField.setBounds(35, 137, 375, 102);
		contentPane.add(textField);
		textField.setColumns(10);

		JButton btnNewButton = new JButton("9");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("9");
				myCalculator.numberButtonPressed(9);
			}
		});
		btnNewButton.setBounds(35, 73, 89, 23);
		contentPane.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("+");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("+");
				myCalculator.plus();
			}
		});
		btnNewButton_1.setBounds(173, 73, 89, 23);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("=");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				myCalculator.equals();
				int i = myCalculator.getResult();
				textField.setText(String.valueOf(i));
			}
		});
		btnNewButton_2.setBounds(321, 73, 89, 23);
		contentPane.add(btnNewButton_2);

	}
}
