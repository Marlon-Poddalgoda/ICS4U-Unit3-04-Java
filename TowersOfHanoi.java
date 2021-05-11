import java.util.Scanner;
/**
 * This program is the Tower's of Hanoi problem.
 *
 * @author  Marlon Poddalgoda
 * @version 1.0
 * @since 2021-05-10
 */

public final class TowersOfHanoi {
    private TowersOfHanoi() {

        // Throw an exception if this ever *is* called
        throw new AssertionError("Instantiating utility class.");
    }

    /**
    * This method calculates the solution for the towers of hanoi.
    * @param ndisks This value is the number of disks.
    * @param startPeg This value is the value of the starting peg.
    * @param endPeg This value is the value of the ending peg.
    */
    public static void hanoi(final int ndisks, final int startPeg,
                             final int endPeg) {
        // recursive function, finds solution to towers of hanoi

        // constants
        final int six = 6;

        // if statement
        if (ndisks == 1) {
            System.out.println("Move disk 1 from peg " + startPeg + " to peg "
                             + endPeg);
        } else {
            hanoi(ndisks - 1, startPeg, six - startPeg - endPeg);
            System.out.println("Move disk " + ndisks + " from peg " + startPeg
                             + " to peg " + endPeg);
            hanoi(ndisks - 1, six - startPeg - endPeg, endPeg);
        }
    }


    /**
    * This method takes in user input and passes to the function.
    * @param args
    */
    public static void main(final String[] args) {

        // Create new Scanner-type variable
        Scanner userInput = new Scanner(System.in);

        // variables
        int numOfDisks;
        int intInput;

        // constants
        final int startPeg = 1;
        final int endPeg = 3;

        // program information
        System.out.println("This is the Towers of Hanoi program.");
        System.out.println();

        while (true) {
            // Asks user to enter a integer
            System.out.print("Enter how many disks you want in your tower: ");

            // check if input is an integer
            while (!userInput.hasNextInt()) {
                System.out.println("That's not a number!");
                System.out.print("Enter how many disks you want: ");
                userInput.next(); // moves scanner until correct value
            }
            intInput = userInput.nextInt();

            if (intInput <= 0) {
                System.out.println("That's not a positive number!");
                continue;
            } else {
                System.out.println();
                hanoi(intInput, startPeg, endPeg);
            }
            break;
        }
        System.out.println("");
        System.out.println("Done.");
    }
}
