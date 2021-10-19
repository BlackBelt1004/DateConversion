package clandar;
import java.util.*;
public class DateConversion {
	public static int maximumDay(int monthNumber) {
		switch(monthNumber) {
		//assigns the maximum amount of days to each month
		case 2:
			return 28;
		case 4:
		case 6:
		case 9:
		case 11:
			return 30;
		default:
			return 31;
		}
	}
	//reads the month number and catches the exception and reacts accordingly
	public static int readMonth() throws MonthException{
		 @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int month;
		System.out.println("Enter the number of the month: ");
		try {
			month = sc.nextInt();
			if (month<=0 || month >12)
				throw new MonthException();
		}
		catch(InputMismatchException e) {
			throw new MonthException();
		}
		return month;
	}
	// reads the day number and reacts if the exception is triggered
	public static int readDay(int month) throws DayException{
		 @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int day;
		System.out.println("Enter the day number: ");
		
		try {
			day = sc.nextInt();
			if(month !=2 && (day<=0|| day > maximumDay(month)))
				throw new DayException();
		}
		catch(InputMismatchException e) {
			throw new DayException();
		}
		return day;
	}
	//reads the year and reacts if the exception is triggered
	public static int readYear() throws YearException{
		 @SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int year;
		System.out.println("Enter the year number: ");
		
		try {
			year = sc.nextInt();
			if(year<=1000||year>3000)
				throw new YearException();
		}
		catch(InputMismatchException e) {
			throw new YearException();
		}
		return year;
	}
	//checks if the year is a leap year and adds an extra day to feb if it is, and it throws an exception if the day is lower than 0 or higher than the max day
	public static int checkFebruary(int day, int year) throws DayException{
		int maxDay = maximumDay(2);
		if(year%4 == 0)
			maxDay++;
		if(day<=0 || day>maxDay) {
			throw new DayException();
		}
		else
			return day;
	}
	//assigns the names to the months
	public static String monthString(int monthNumber) {
		switch(monthNumber) {
		case 1:
			return "January";
		case 2:
			return "February";
		case 3:
			return "March";
		case 4:
			return "April";
		case 5:
			return "May";
		case 6:
			return "June";
		case 7:
			return "July";
		case 8:
			return "August";
		case 9:
			return "September";
		case 10:
			return "October";
		case 11:
			return "November";
		case 12:
			return "December";
		default:
			System.out.println("Fatal Error");
			System.exit(0);
			return "Error";
		}
	}
	//main method
	public static void main(String args[]) {
		int month = 1, day = 1, year = 1000;
		boolean gotMonth = false;
		while(!gotMonth) {
			try {
				month = readMonth();
				gotMonth = true;
			}
			catch (MonthException e) {
				System.out.println(e.getMessage());
			}
		}
		boolean gotDay = false;
		while(!gotDay) {
			try {
				day = readDay(month);
				gotDay = true;
			}
			catch (DayException e) {
				System.out.println(e.getMessage());
			}
		}
	
	boolean gotYear = false;
    while(!gotYear)
    {
     try 
     {
      year = readYear();
      gotYear = true;
     } 
     catch (YearException e) 
     {
        System.out.println(e.getMessage());
     }
    }
    //checks february to see if the day is correct and if the year is a leap year
    if (month == 2) {
    	boolean okFebDate = false;
    	while(!okFebDate) {
    		System.out.println("Checking February date..");
    		try {
    			day = checkFebruary(day,year);
    			okFebDate = true;
    			
    		}
    		catch(DayException e) {
    			System.out.println(e.getMessage());
    			try {
    				day = readDay(month);
    			}
    			catch(DayException e1) {
    				
    			}
    			
    		}
    	}
    }
    System.out.println("The date is "+monthString(month)+" "+ day+ ", "+ year);
     
	}
}
