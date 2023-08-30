package projectOne;
public class DateFormat {

    public static String calculateNextDate(String inputDate) {
        int day = Integer.parseInt(inputDate.substring(0, 2));
        int month = Integer.parseInt(inputDate.substring(3, 5));
        int year = Integer.parseInt(inputDate.substring(6));

        if (!isValidDate(day, month, year)) {
            return "Invalid date format or invalid date.";
        }

        int maxDaysInMonth = getMaxDaysInMonth(month, year);

        if (day < maxDaysInMonth) {
            day++;
        } else {
            day = 1;
            if (month < 12) {
                month++;
            } else {
                month = 1;
                year++;
            }
        }
        String nextDate = String.format("%02d-%02d-%04d", day, month, year);
        return nextDate;
    }

    private static boolean isValidDate(int day, int month, int year) {
        if (year < 1 || month < 1 || month > 12 || day < 1 || day > 31) {
            return false;
        }

        int maxDays = getMaxDaysInMonth(month, year);
        return day <= maxDays;
    }

    private static int getMaxDaysInMonth(int month, int year) {
        int[] maxDaysPerMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int maxDays = maxDaysPerMonth[month];

        // Check for leap year and adjust February's days accordingly
        if (month == 2 && isLeapYear(year)) {
            maxDays++;
        }

        return maxDays;
    }

    // Helper method to check if a year is a leap year
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        String inputDate = "23-07-2023";
        String nextDate = calculateNextDate(inputDate);
        System.out.println("Next date from " + inputDate + " is " + nextDate);
    }
}
