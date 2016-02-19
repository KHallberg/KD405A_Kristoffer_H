package se.mah.KD405A.khallberg;

import java.awt.EventQueue;
import java.net.URL;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.Font;

public class DigitalClockGUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txtHour;
	private JTextField txtMin;

	private ClockLogic clockLogic;
	private JLabel lblTime;
	private JLabel lblAlarm;

	private JButton btnSetAlarm;
	private JButton btnClearAlarm;
	public JLabel lblNewLabel;

	public int checkHour;
	public int checkMinute;

	private String s;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// For be able to set icon in jFrame on OS X, looks like hell.
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			JFrame.setDefaultLookAndFeelDecorated(true);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 */
	public DigitalClockGUI() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DigitalClockGUI.class.getResource("/img/BeerIcon.png")));
		setTitle("Beer Time");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 328);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtHour = new JTextField();
		txtHour.setBounds(12, 186, 40, 26);
		contentPane.add(txtHour);
		txtHour.setColumns(10);

		txtMin = new JTextField();
		txtMin.setBounds(76, 186, 40, 26);
		contentPane.add(txtMin);
		txtMin.setColumns(10);

		btnSetAlarm = new JButton("Next beer");
		btnSetAlarm.addActionListener(this);
		btnSetAlarm.setBounds(12, 224, 104, 29);
		contentPane.add(btnSetAlarm);

		btnClearAlarm = new JButton("Emty");
		btnClearAlarm.addActionListener(this);
		btnClearAlarm.setBounds(12, 265, 104, 29);
		contentPane.add(btnClearAlarm);

		JLabel lblMin = new JLabel("Min");
		lblMin.setForeground(UIManager.getColor("Button.background"));
		lblMin.setBackground(new Color(238, 238, 238));
		lblMin.setBounds(76, 167, 60, 15);
		contentPane.add(lblMin);

		JLabel lblHour = new JLabel("Hour");
		lblHour.setForeground(UIManager.getColor("Button.background"));
		lblHour.setBounds(12, 167, 60, 15);
		contentPane.add(lblHour);

		lblTime = new JLabel("");
		lblTime.setBackground(new Color(255, 175, 175));
		lblTime.setFont(new Font("Impact", Font.PLAIN, 36));
		lblTime.setForeground(UIManager.getColor("Button.background"));
		lblTime.setBounds(12, 12, 139, 46);
		contentPane.add(lblTime);

		lblAlarm = new JLabel("");
		lblAlarm.setFont(new Font("Impact", Font.PLAIN, 20));
		lblAlarm.setText("Next beer:");
		lblAlarm.setForeground(UIManager.getColor("Button.background"));
		lblAlarm.setBounds(241, 12, 209, 36);
		contentPane.add(lblAlarm);

		// Create a new clockLogic instance
		clockLogic = new ClockLogic(this);

		lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		lblNewLabel.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/img/empty-beer-glass-665x385.jpg")));
		lblNewLabel.setBounds(0, 0, 450, 306);
		contentPane.add(lblNewLabel);
	}

	// sets and updates the current time
	public void setTimeOnLabel(String time) {
		lblTime.setText(time);
	}

	// sets the alarm time to the alarm label
	public void activateAlarm(boolean activate) {
		if (activate == true) {
			clockLogic.setAlarm(Integer.parseInt(txtHour.getText()), Integer.parseInt(txtMin.getText()));
			lblAlarm.setText("Next beer: " + txtHour.getText() + ":" + txtMin.getText());
		} else {
			clockLogic.clearAlarm();
			lblAlarm.setText("Next beer: Not set");
			lblNewLabel.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/img/empty-beer-glass-665x385.jpg")));
		}
		txtHour.setText("");
		txtMin.setText("");
	}

	// playing sound when called
	public void makeSound() {
		try {
			URL url = DigitalClockGUI.class.getResource("/music/cheering.wav");
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
			Clip clip;
			clip = AudioSystem.getClip();
			clip.open(audioIn);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// alarm action
	public void alarm() {
		System.out.println("alarm");
		makeSound();
		lblNewLabel.setIcon(new ImageIcon(DigitalClockGUI.class.getResource("/img/beer_toast-9122.jpg")));
	}

	// checks for actions from buttons
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSetAlarm) {

			if (txtHour.getText().length() == 2 && txtMin.getText().length() == 2) {
				checkHour = Integer.parseInt(txtHour.getText());
				checkMinute = Integer.parseInt(txtMin.getText());

				if (checkHour >= 0 && checkHour < 24 && checkMinute >= 0 && checkMinute <= 59) {
					this.activateAlarm(true);
				}
			} else {
				lblAlarm.setText("Next beer: Not valid");
			}
		} else if (e.getSource() == btnClearAlarm) {
			this.activateAlarm(false);
		}
	}
}