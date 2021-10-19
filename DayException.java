package clandar;
//day exception class
@SuppressWarnings("serial")
public class DayException extends Exception {
	public DayException() {
		super("Invalid day.");
	}
	public DayException(String message) {
		super (message);
	}
}
