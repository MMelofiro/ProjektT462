package projekt;

/*
 * Input Class
 * How is this class used?
 * 	This class will be used everytime the game needs any input from the player.
 * 
 * What is inside this class?
 * 	scannerInt method:
 * 		Used to ask the player for an input. Verifies that the input is an int, and returns the input.
 * 	closeScanner:
 * 		
 */

import java.util.Scanner;

public class Input {

	private Scanner scanner;

	public Input() {

		scanner = new Scanner(System.in);

	}

	public int scannerInt(String frage, int max) { // method for every decision we will give. You can see an
															// example of how I used this method in the class
															// SchwierigCharakter and Player
		// min is always 1, max is the number of decision the player can make. This is
		// declared so that the player can't give a bigger number than the actual number
		// of options.
		int nummer = 0; // nummer is declared as 0, so that the next while will repeat at least once

		System.out.println(frage); // frage will be printed

		while (nummer < 1 || nummer > max) { // repeat while nummer is out of range

			if (scanner.hasNextInt()) { // if the next input is an int, then nummer changes as that new int

				nummer = scanner.nextInt(); // a new value for nummer will be asked, this will always happen, at least
											// once

			} else { // if the nummer asked the line above wasn't a number, then...

				System.out.println("Bitte, wählen Sie eine mögliche Antwort."); // ...this will be printed, and the loop
																				// goes back to ask you for the answer

				scanner.next(); // this stops the loop from printing the text above infinitely.

			}

		}

		return nummer; // finally when the loop ends, nummer will be returned

	}

	public void closeScanner() { // method to close the scanner, VERY IMPORTANT!
		scanner.close(); // Close the scanner for every decision. If you forget to close it, then nummer
							// will remain as what
	} // the last value was, and be used the next time the method scannerInt() is
		// used.

}
