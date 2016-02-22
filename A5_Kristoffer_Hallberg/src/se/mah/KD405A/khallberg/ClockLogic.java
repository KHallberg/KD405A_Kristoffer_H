package se.mah.KD405A.khallberg;

import java.util.Calendar;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;

public class ClockLogic {

	private DigitalClockGUI clockGUI;
	private int alarmHour = -1;
	private int alarmMinute = -1;
	private String s;

	// constructor
	public ClockLogic(DigitalClockGUI digitalClockGUI) {
		this.clockGUI = digitalClockGUI;

		// starts the timeThred
		new TimeThread().start();
	}

	public static String nice(int i) {
		String s = String.valueOf(i);
		if (s.length() == 1) {
			s = "0 +" + s;
		}
		return s;
	}

	// sets the alarm
	public void setAlarm(int hour, int minute) {
		this.alarmHour = hour;
		this.alarmMinute = minute;

		System.out.println("set");
	}

	// clears and disable the alarm
	public void clearAlarm() {
		this.alarmHour = -1;
		this.alarmMinute = -1;
		System.out.println("clear");
	}

	//
	public class TimeThread extends Thread {
		@Override
		public void run() {
			// creates a decimal format
			DecimalFormat timeFormat = new DecimalFormat("00");
			while (true) {

				Calendar rightNow = Calendar.getInstance();
				int hour = rightNow.get(Calendar.HOUR_OF_DAY);
				int min = rightNow.get(Calendar.MINUTE);
				int sec = rightNow.get(Calendar.SECOND);
				clockGUI.setTimeOnLabel(
						timeFormat.format(hour) + ":" + timeFormat.format(min) + ":" + timeFormat.format(sec));

				// check the alarm time
				if (hour == alarmHour && min == alarmMinute && sec == 0) {
					clockGUI.alarm();
				}
				if (hour == alarmHour && min == alarmMinute && sec == 30) {
					clockGUI.activateAlarm(false);
				}
				try {
					Thread.sleep(900);
				} catch (InterruptedException e) {
				}

			}
		}

	}
}
