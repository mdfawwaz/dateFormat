package projectOne;

public class DayOfTheWeek {
	
	private int day;
	private int month;
	private int year;
	
	public DayOfTheWeek (int day, int month, int year) {
		
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	public int getYear() {
		return year;
	}
	
	private boolean isLeapYear(int year) {
		return(year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
	}
	
	public String getDayOfTheWeek(int day, int month, int year) {
		
		
		int[] daysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfWeekNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        if (isLeapYear(year)) {
            daysPerMonth[2] = 29;
        }

        int q = day;
        int m = month;
        int k = year % 100;
        int j = year / 100;
        int h = q + 13*(m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
        h = h % 7;

        return dayOfWeekNames[h];
	} 
	
	public String toString() {
        String dayOfWeek = getDayOfTheWeek(day, month, year);
        return dayOfWeek ;
    }
	
	  public static void main(String[] args) {
	        DayOfTheWeek date = new DayOfTheWeek(2023, 7, 25);
	        System.out.println(date.toString()); 
	    }
}
