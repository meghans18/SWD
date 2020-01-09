import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

/**
 * Class that handles the testing of the Easter class.
 */
class EasterTest {

    /**
     * Verifies that the Easter class calculates the right date for Easter for the twenty different years given.
     */
    @Test
    void test20Years() {
        /*
        I used this article to verify the Easter dates of the years in the array:
        http://tlarsen2.tripod.com/thomaslarsen/easterdates.html
        */
        int[] years = {1700, 1743, 1798, 1777, 1801, 1888, 1899, 1963, 1920, 1998, 2000, 2019, 2050, 2069, 2075, 2099, 2196, 2201, 2237, 2299};
        String[] ans = {"April 11, 1700", "April 14, 1743", "April 8, 1798", "March 30, 1777", "April 5, 1801", "April 1, 1888", "April 2, 1899", "April 14, 1963", "April 4, 1920", "April 12, 1998", "April 23, 2000", "April 21, 2019", "April 10, 2050", "April 14, 2069", "April 7, 2075", "April 12, 2099", "April 17, 2196", "April 19, 2201", "April 16, 2237", "April 16, 2299"};
        for (int i = 0; i < years.length; i++) {
            Easter e = new Easter(years[i]);
            assertEquals(ans[i], e.toString());
        }
    }

    /**
     * Prints all the easters to the command window.
     */
    @Test
    void testAll() {
        Easter.allEasters();
    }

}