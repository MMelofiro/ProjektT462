package projekt;

import java.util.InputMismatchException; // um das Fehler zu zeigen

/*
 * Input Class
 * Most important class tbh. Used everytime the game needs any input from the player.
 * 
 * What is inside this class?
 * 		scannerInt() method:
 * 			Used to ask the player for an input. Verifies that the input is an int, and returns the input.
 * 		
 * 		scannerDouble():		
 * 			It allows any input from the type double.
 * 
 * 		next():
 * 			It won't save any input. It's just used so that the player must press enter to continue reading.
 * 
 * 		fixNext():
 * 			Sometimes next() doesn't work, and I don't know why. But the solution (at least the easiest one) is to put this method
 * 			above next() (examples in Spiel02).
 * 
 * 		closeScanner():
 * 			Closes the scanner... It's just used at the very end of the game.
 */

import java.util.Scanner;

public class Input { //Marcello Melofiro

	private Scanner scanner;

	public Input() {

		scanner = new Scanner(System.in);

	}

	public int scannerInt(String frage, int max) { // method for multiple choice type of games. You can see an
													// example of how I used this method in the class SchwierigCharakter and Player
													// min is always 1, max is the number of decision the player can make. This is
													// declared so that the player can't give a bigger number than the actual number of options.
		int nummer = 0; // nummer is declared as 0, so that the next while will repeat at least once

		System.out.println(frage); // frage will be printed

		while (nummer < 1 || nummer > max) { // repeat while nummer is out of range

			try { // try und catch, weil wenn man ein nummer mit komma schreibt, geht alles kaputt haha
				
				if (scanner.hasNextDouble()) { // if the next input is an int, then true

					nummer = scanner.nextInt(); // a new value for nummer will be asked, this will always happen, at least
												// once
				} else { // if the nummer asked the line above wasn't a number, then...

					System.out.println("Bitte, geben Sie eine mögliche Antwort."); // ...this will be printed, and the loop
																					// goes back to ask you for the answer
					scanner.next(); // this stops the loop from printing the text above infinitely.

				} 
				
			} catch (InputMismatchException e) {
	            System.out.println("Bitte, geben Sie eine mögliche Antwort.");
	            scanner.next();

			}
			
		}

		return nummer; // finally when the loop ends, nummer will be returned
		
	}

	public double scannerDouble(String frage) {

		double nummer = 0; // nummer is declared as 0, so that the next while will repeat at least once

		System.out.println(frage); // frage will be printed

	    do {
	    	
	        if (scanner.hasNextDouble()) {
	        	
	            nummer = scanner.nextDouble();
	            
	            break; // Stop loop after valid input
	            
	        } else {
	        	
	            System.out.println("Bitte, wählen Sie eine mögliche Antwort.");
	            
	        }
	        
	    } while (true);

		return nummer; // finally when the loop ends, nummer will be returned

	}
	
	public void next() {
		
		System.out.println("\n...");
		
		scanner.nextLine();
		
	}
	
	public void fixNext() { //Use this method above next() if next() is not waiting for an input
		
		scanner.nextLine();
		
	}

	public void closeScanner() {
		scanner.close(); //close the scanner at the end of the game, I mean literally after the ending.
	} 

}
