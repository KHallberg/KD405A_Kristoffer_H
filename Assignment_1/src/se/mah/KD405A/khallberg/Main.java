package se.mah.KD405A.khallberg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.GridLayout;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.UIManager;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTextField txtArnold;
	private JTextField txtSchwarzenegger_1;
	private JTextField textField_3;
	private JTextField txtMainStreet_1;
	private JTextField textField;
	private JTextField txtSantaMonica_1;
	private JTextField textField_1;
	private JTextField txtIllbebackgmailcom_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 697, 522);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArkiv = new JMenu("Arkiv");
		mnArkiv.setBackground(Color.WHITE);
		menuBar.add(mnArkiv);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Skriv ut");
		mnArkiv.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Avsluta");
		mnArkiv.add(mntmNewMenuItem_1);
		
		JMenu mnMedlem = new JMenu("Medlem");
		menuBar.add(mnMedlem);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Ny medlem");
		mnMedlem.add(mntmNewMenuItem_2);
		
		JMenuItem mntmHittaMedlem = new JMenuItem("Hitta medlem");
		mnMedlem.add(mntmHittaMedlem);
		
		JMenu mnNewMenu = new JMenu("Hjälp");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmHjlp = new JMenuItem("Hjälp");
		mnNewMenu.add(mntmHjlp);
		
		JMenuItem mntmOmProgramet = new JMenuItem("Om programet");
		mnNewMenu.add(mntmOmProgramet);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Main.class.getResource("/img/KarlAlfred-1.png")));
		lblNewLabel_2.setBounds(147, 353, 400, 119);
		contentPane.add(lblNewLabel_2);
		
		JButton btnSpara = new JButton("Spara");
		btnSpara.setBackground(Color.PINK);
		btnSpara.setForeground(new Color(255, 153, 0));
		btnSpara.setBounds(467, 339, 100, 39);
		//btnSpara.setOpaque(true); //background color, rect under the buttom
		contentPane.add(btnSpara);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(Main.class.getResource("/img/Arnold.jpg")));
		lblNewLabel_1.setBounds(491, 49, 180, 237);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBackground(UIManager.getColor("CheckBox.background"));
		textField_1.setText("(310) 396-5917");
		textField_1.setColumns(10);
		textField_1.setBounds(356, 263, 130, 26);
		contentPane.add(textField_1);
		
		JLabel lblTelefon = new JLabel("Telefon");
		lblTelefon.setForeground(new Color(255, 153, 0));
		lblTelefon.setFont(new Font("Helvetica Neue", Font.PLAIN, 8));
		lblTelefon.setBounds(359, 253, 61, 16);
		contentPane.add(lblTelefon);
		
		txtSantaMonica_1 = new JTextField();
		txtSantaMonica_1.setBackground(UIManager.getColor("CheckBox.background"));
		txtSantaMonica_1.setText("Santa Monica");
		txtSantaMonica_1.setColumns(10);
		txtSantaMonica_1.setBounds(356, 226, 130, 26);
		contentPane.add(txtSantaMonica_1);
		
		JLabel lblOrt = new JLabel("Ort");
		lblOrt.setForeground(new Color(255, 153, 0));
		lblOrt.setFont(new Font("Helvetica Neue", Font.PLAIN, 8));
		lblOrt.setBounds(359, 216, 61, 16);
		contentPane.add(lblOrt);
		
		JLabel lblPostnummer = new JLabel("Postnummer");
		lblPostnummer.setForeground(new Color(255, 153, 0));
		lblPostnummer.setFont(new Font("Helvetica Neue", Font.PLAIN, 8));
		lblPostnummer.setBounds(359, 181, 61, 16);
		contentPane.add(lblPostnummer);
		
		textField = new JTextField();
		textField.setBackground(UIManager.getColor("CheckBox.background"));
		textField.setText("90405-5354");
		textField.setColumns(10);
		textField.setBounds(356, 191, 130, 26);
		contentPane.add(textField);
		
		txtMainStreet_1 = new JTextField();
		txtMainStreet_1.setBackground(UIManager.getColor("CheckBox.background"));
		txtMainStreet_1.setText("3110 Main Street");
		txtMainStreet_1.setColumns(10);
		txtMainStreet_1.setBounds(356, 155, 130, 26);
		contentPane.add(txtMainStreet_1);
		
		JLabel lblGata = new JLabel("Gata");
		lblGata.setForeground(new Color(255, 153, 0));
		lblGata.setFont(new Font("Helvetica Neue", Font.PLAIN, 8));
		lblGata.setBounds(359, 145, 61, 16);
		contentPane.add(lblGata);
		
		JLabel lblEfternamn = new JLabel("Efternamn");
		lblEfternamn.setForeground(new Color(255, 153, 0));
		lblEfternamn.setFont(new Font("Helvetica Neue", Font.PLAIN, 8));
		lblEfternamn.setBounds(359, 76, 61, 16);
		contentPane.add(lblEfternamn);
		
		txtSchwarzenegger_1 = new JTextField();
		txtSchwarzenegger_1.setBackground(UIManager.getColor("CheckBox.background"));
		txtSchwarzenegger_1.setText("Schwarzenegger");
		txtSchwarzenegger_1.setColumns(10);
		txtSchwarzenegger_1.setBounds(356, 86, 130, 26);
		contentPane.add(txtSchwarzenegger_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 48, 157, 330);
		contentPane.add(scrollPane);
		
		JList list = new JList();
		list.setBackground(UIManager.getColor("CheckBox.background"));
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Johan Andersson", "Mattias Andersson", "Marcus Bader", "Marianne Bansell", "Emil Berzén", "Hampus Blomquist", "Lisa Blomsten", "Freja Detter", "Mårten Friman", "Jonas Gabrielsson", "Kelly Gelevska", "Kristoffer Hallberg", "Ida Hammer", "Oskar Hansson", "Lars Holmberg", "Jonatan Holmgren", "Marcus Håkansson", "Johannes Johansson", "Johanna Johnson", "Antonia Jungbeck", "Jennifer Larsson", "Viktor LInd", "Hans Lindberg", "Oliver Lundahl", "Clara Lundborg", "Amanda Lundius", "Robin Medin", "Amina Muftic", "Linn Nerlund", "Anton Nilsson", "Madeleine Nilsson", "Sebastian Nilsson", "Marcus Olofsson", "Helena Olsson", "Nicolina Orell", "Fredrik Påhlsson", "Arnold Schwarzenegger"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		JLabel lblMedlemmar = new JLabel("Medlemmar");
		lblMedlemmar.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		lblMedlemmar.setForeground(new Color(255, 153, 51));
		lblMedlemmar.setBounds(27, 20, 138, 16);
		contentPane.add(lblMedlemmar);
		
		JLabel lblProfil = new JLabel("Profil");
		lblProfil.setFont(new Font("Helvetica Neue", Font.PLAIN, 16));
		lblProfil.setBackground(new Color(255, 255, 255));
		lblProfil.setForeground(new Color(255, 153, 0));
		lblProfil.setBounds(359, 20, 61, 16);
		contentPane.add(lblProfil);
		
		JLabel lblFrnamn = new JLabel("Förnamn");
		lblFrnamn.setFont(new Font("Helvetica Neue", Font.PLAIN, 8));
		lblFrnamn.setForeground(new Color(255, 153, 0));
		lblFrnamn.setBounds(359, 41, 61, 16);
		contentPane.add(lblFrnamn);
		
		txtArnold = new JTextField();
		txtArnold.setBackground(UIManager.getColor("CheckBox.background"));
		txtArnold.setText("Arnold");
		txtArnold.setBounds(356, 51, 130, 26);
		contentPane.add(txtArnold);
		txtArnold.setColumns(10);
		
		JLabel lblPersonnummer = new JLabel("Personnummer");
		lblPersonnummer.setForeground(new Color(255, 153, 0));
		lblPersonnummer.setFont(new Font("Helvetica Neue", Font.PLAIN, 8));
		lblPersonnummer.setBounds(359, 111, 61, 16);
		contentPane.add(lblPersonnummer);
		
		textField_3 = new JTextField();
		textField_3.setBackground(UIManager.getColor("CheckBox.background"));
		textField_3.setText("470730-5139");
		textField_3.setColumns(10);
		textField_3.setBounds(356, 121, 130, 26);
		contentPane.add(textField_3);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 153, 0));
		lblEmail.setFont(new Font("Helvetica Neue", Font.PLAIN, 8));
		lblEmail.setBounds(359, 288, 61, 16);
		contentPane.add(lblEmail);
		
		txtIllbebackgmailcom_1 = new JTextField();
		txtIllbebackgmailcom_1.setBackground(UIManager.getColor("CheckBox.background"));
		txtIllbebackgmailcom_1.setText("ill_be_back@gmail.com");
		txtIllbebackgmailcom_1.setColumns(10);
		txtIllbebackgmailcom_1.setBounds(356, 301, 320, 26);
		contentPane.add(txtIllbebackgmailcom_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(0, -23, 697, 501);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(Main.class.getResource("/img/background.jpg")));
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
