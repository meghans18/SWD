import java.lang.System;
import java.util.Scanner;

/**
 * Class that contains the main program for this module.
 */
public class Computus {
    /**
     * Main method that drives the program. Asks the user what they would like to do.
     * They are given options to calculate the date of Easter for a specific year or print each day Easter has occurred on and the number of times.
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        //initializing new scanner for input from user
        Scanner option = new Scanner(System.in);
        int opt = 0;

        while (opt != 3) {
            //asking the user which option they would like to choose
            System.out.println("What would you like to do? Enter corresponding number.");
            System.out.println("1. Calculate Easter of specific year");
            System.out.println("2. List of all Easters");
            System.out.println("3. Exit");
            opt = option.nextInt();

            Scanner input = new Scanner(System.in);
            //if they chose option one, keep entering years until -1 is typed
            if (opt == 1) {
                int num = 0;
                while (num != -1) {
                    System.out.print("Please enter a year. Type -1 to leave: \n");
                    num = input.nextInt();
                    if (num != -1) {
                        Easter e = new Easter(num);
                        System.out.println("The date of Easter is: " + e.toString());
                    }
                }
            }
            //option 2 is just printing all the easters
            else if (opt == 2) {
                Easter.allEasters();
            }
        }
    }
}
