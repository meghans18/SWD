/**
 * Class that handles the Easter objects.
 */
public class Easter {
    /**
     * Holds the year that was entered into the constructor.
     */
    private int year;

    /**
     * Hold the month of the date of Easter.
     */
    private int month;

    /**
     * Holds the day of the date of Easter.
     */
    private int day;

    /**
     * Static variable shared between each instance that has an array of the months of the year.
     */
    static private String[] Months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    /**
     * Constructor for the Easter class that takes in the year and then calculates the date of Easter for that year.
     * Uses the Anonymous Gregorian algorithm found on Wikipedia.
     * @param year The year for calculating the date of Easter in.
     */
    public Easter(int year) {
        //doing the math given from the wikipedia article to get the month, day, and year of the easter of the year passed into constructor
        int a = year % 19, b = year/100, c = year % 100, d = b/4, e = b % 4;
        int f = (b+8)/25, g = (b-f+1)/3, h = (19*a+b-d-g+15) % 30;
        int i = c / 4, k = c % 4, l = (32+2*e+2*i-h-k) % 7;
        int m = (a + 11*h + 22*l)/451;
        int repeat = h + l - 7 * m + 114;
        //storing these in instance variables
        this.month = repeat / 31;
        this.day = (repeat % 31)+1;
        this.year = year;
    }

    /**
     * Method that prints all the dates Easter has occurred on and the number of times it has occurred on that date.
     */
    static public void allEasters() {
        //dates of easters are in a 35 day range
        for (int j = 0; j < 35; j++) {
            //math below is to determine the month and day of the easter we are checking count for
            int count = 0;
            int m = 3;
            int d = j + 22;
            if ((j+22) / 31 == 1 && (j+22) % 31 > 0) {
                m = 4;
                d = (j + 22) % 31;
            }
            //loop through all years in a cycle and count how many times the date of easter matches the date we are looking at in the outside for loop
            for (int k = 0; k < 5700000; k++) {
                Easter e = new Easter(k);
                if ((e.month == m) && (e.day == d)) {
                    count++;
                }
            }
            //print out the count for the corresponding date of easter
            System.out.println("" + Months[m-1] + " " + d + ": " + count);
        }
    }

    /**
     * Method to print the date of Easter in string format including the month, day and year.
     * @return a String representation of the date of Easter for the year passed into constructor.
     */
    public String toString() {
        String m = Months[month-1];
        return "" + m + " " + day + ", " + year;
    }
}
