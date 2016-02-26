package se.mah.KD405A.khallberg;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//import se.mah.KD405A.khallberg.GUITEST.GetJourneysThread;
import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class GUI extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextArea txtrResult;
	private JTextField txtStation;
	private JScrollPane scrollPane;
	private JPanel panel_1;
	private JTextField txtFrom;
	private JTextField txtTo;
	private JTextArea txtrJourneyresult;
	private JButton btnJourneysearch;
	private JButton btnSearch;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 553, 229);
		contentPane.add(panel);
		panel.setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 72, 537, 151);
		panel.add(scrollPane);

		txtrResult = new JTextArea();
		scrollPane.setViewportView(txtrResult);

		btnSearch = new JButton("Sök station");
		btnSearch.setBounds(290, 31, 117, 29);
		btnSearch.setForeground(new Color(220, 20, 60));
		btnSearch.addActionListener(this);
		panel.add(btnSearch);

		txtStation = new JTextField();
		txtStation.setBounds(6, 31, 189, 26);
		panel.add(txtStation);
		txtStation.setColumns(10);

		JLabel lblResml = new JLabel("Resmål");
		lblResml.setBounds(10, 16, 61, 16);
		panel.add(lblResml);

		panel_1 = new JPanel();
		panel_1.setBounds(0, 241, 553, 268);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		txtFrom = new JTextField();
		txtFrom.setForeground(new Color(169, 169, 169));
		txtFrom.setText("stationsnummer");
		txtFrom.setBounds(6, 35, 130, 26);
		panel_1.add(txtFrom);
		txtFrom.setColumns(10);

		txtTo = new JTextField();
		txtTo.setForeground(new Color(169, 169, 169));
		txtTo.setText("stationsnummer");
		txtTo.setBounds(148, 35, 130, 26);
		panel_1.add(txtTo);
		txtTo.setColumns(10);

		txtrJourneyresult = new JTextArea();
		txtrJourneyresult.setBounds(10, 78, 537, 183);
		panel_1.add(txtrJourneyresult);

		btnJourneysearch = new JButton("Sök resa");
		btnJourneysearch.setForeground(new Color(220, 20, 60));
		btnJourneysearch.addActionListener(this);
		btnJourneysearch.setBounds(290, 35, 117, 29);
		panel_1.add(btnJourneysearch);

		JLabel lblFrnStationsnummer = new JLabel("Från");
		lblFrnStationsnummer.setBounds(10, 18, 130, 16);
		panel_1.add(lblFrnStationsnummer);

		JLabel lblTill = new JLabel("Till");
		lblTill.setBounds(152, 18, 61, 16);
		panel_1.add(lblTill);
	}

	private String getTime(Calendar time) {
		return time.get(Calendar.HOUR_OF_DAY) + ":" + time.get(Calendar.MINUTE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSearch) {

			txtrResult.setText("Searching....");
			new StationsThreadSearch().start();
		}
		if (e.getSource() == btnJourneysearch) {

			txtrJourneyresult.setText("Searching....");
			new JourneysSearchThread().start();
		}
	}

	private class StationsThreadSearch extends Thread {
		@Override
		public void run() {
			// creates a ArrayList to hold the information
			ArrayList<Station> stations = new ArrayList<Station>();
			// adds the search result to the ArrayList
			stations.addAll(Parser.getStationsFromURL(txtStation.getText()));
			// clears the Result jTextArea
			txtrResult.setText("");

			// loops through the the ArrayList and collects information the
			// displays it in JtextArea Result
			for (Station s : stations) {
				txtrResult.append(s.getStationName() + " Stations nummer: " + s.getStationNbr() + " Latitud: "
						+ s.getLongitude() + " Longitud: " + s.getLatitude() + "\n");
			}

		}

	}

	private class JourneysSearchThread extends Thread {
		@Override
		public void run() {
			// URL for searching
			String searchURL = Constants.getURL(txtFrom.getText(), txtTo.getText(), 1);
			// ask journeys and receives a list from Skanetrafiken
			Journeys journeys = Parser.getJourneys(searchURL);
			ArrayList<Journey> journeySearchResult = journeys.getJourneys();

			// clears the Result jTextArea
			txtrJourneyresult.setText("");

			// checks if the ArrayLIst is empty - if so, displays a message
			if (journeySearchResult.isEmpty()) {
				txtrJourneyresult.append("Du måste fylla i stationsnummer");
			}

			// returns the value of the first (0) place in the ArrayList
			Journey MyJourney = journeySearchResult.get(0);

			try {
				// display the information
				txtrJourneyresult.append("Din sökta resa mellan " + MyJourney.getStartStation().getStationName()
						+ " och " + MyJourney.getEndStation().getStationName() + " avgår om "
						+ MyJourney.getTimeToDeparture() + " minuter" + "\n" + "\n");
				txtrJourneyresult.append("Avgår kl. " + getTime(MyJourney.getDepDateTime()) + " från "
						+ MyJourney.getStartStation().getStationName() + "\n");
				txtrJourneyresult.append("Du bör vara framme kl. " + getTime(MyJourney.getArrDateTime()) + " på "
						+ MyJourney.getEndStation().getStationName() + "\n");

				txtrJourneyresult.append("Restid: " + MyJourney.getTravelMinutes() + " minuter" + "\n");
				txtrJourneyresult.append("Antal zoner: " + MyJourney.getNoOfZones() + "\n");
				txtrJourneyresult.append("Antal byten: " + MyJourney.getNoOfChanges() + "\n");
				txtrJourneyresult.append("Linje : " + MyJourney.getLineOnFirstJourney() + "\n");
				txtrJourneyresult.append("Typ av färdmedel: " + MyJourney.getLineTypeName() + "\n");

				// if there is an deviation - display a message
				int depTimeDeviation = Integer.parseInt(MyJourney.getDepTimeDeviation());
				if (depTimeDeviation != 0) {

					txtrJourneyresult.append(
							"Resan avviker med " + Integer.toString(depTimeDeviation) + " minuter från ordinarie tid.");
				}
			} catch (Exception e) {
				e.printStackTrace();

			}

		}
	}
}