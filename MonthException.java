package clandar;
//month exception class
@SuppressWarnings("serial")
public class MonthException extends Exception {
	public MonthException() {
		super("Invalid month.");
	}
	public MonthException(String message) {
		super (message);
	}
}
