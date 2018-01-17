package ch.bfh.btx8081.w2017.green.Spero.model;

import ch.bfh.btx8081.w2017.green.Spero.exceptionHandling.IncorrectException;
import ch.bfh.btx8081.w2017.green.Spero.persistence.DB;

public class SettingsModel {
	//private static final DB DATABASE_MANAGER = DB.getInstance();

	private String username;
	private String reminder;
	private String snooze;
	private String chat;

	/**
	 * the input from the settings
	 * @param username
	 * @param reminder
	 * @param snooze
	 * @param chat
	 */
	public SettingsModel(String username, String reminder, String snooze,
			String chat) {
		this.username = username;
		this.reminder = reminder;
		this.snooze = snooze;
		this.chat = chat;
	}

	/**
	 * persists the input into the database
	 * @param username
	 * @param reminder
	 * @param snooze
	 * @param chat
	 */
//	public void persist(String username, String reminder, String snooze,
//			String chat) {
//		SettingsModel.DATABASE_MANAGER.persistObject(username);
//		SettingsModel.DATABASE_MANAGER.persistObject(reminder);
//		SettingsModel.DATABASE_MANAGER.persistObject(snooze);
//		;
//	}

	/**
     * checks that the snooze time is not empty
     * @param snooze
     * @throws IncorrectException
     */
	public void checkSnooze(String snooze) throws IncorrectException {
		if (snooze.length() > 3) {
			throw new IncorrectException(
					"Bei der Snooze Zeit dürfen nicht mehr als 999 Minuten notiert werden.");
		} else if (snooze.isEmpty()) {
			throw new IncorrectException(
					"Die Snooze Zeit darf nicht leer sein.");
		}
		try {
			Integer.parseInt(snooze.substring(0));
		} catch (final Exception e) {
			throw new IncorrectException(
					"Bei der Snooze Zeit dürfen nur Zahlen notiert werden.");
		}
	}

	/**
     * checks that the reminder is not empty
     * @param reminder
     * @throws IncorrectException
     */
	public void checkReminder(String reminder) throws IncorrectException {
		if (reminder.equals(null)) {
			throw new IncorrectException(
					"Reminder Value darf nicht leer sein.");
		}
	}

}
