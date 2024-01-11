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

	public int scannerInt(String frage, int max) { // Methode für Multiple Choice Spiele.
													// Ihr könnt ein Beispiel sehen, wie ich diese Methode in der Klasse SwierigkeitsCharachter und Player verwendet habe.
													// min ist immer 1, max ist die Anzahl der Entscheidungen, die der Spieler treffen kann.
													// Dies wird so deklariert, dass der Spieler keine größere Zahl als die eigentliche Anzahl der Optionen eingeben kann.
		int nummer = 0; // nummer wird als 0 deklariert, so dass das nächste while mindestens einmal wiederholt wird (ich konnte hier eine do while Schleife nutzen... ist ja dasselbe)

		System.out.println(frage); // frage wird gedruckt

		while (nummer < 1 || nummer > max) { // wiederholen, solange nummer kleiner als 1, oder grösser als max ist

			try { // try und catch, weil wenn man eine nummer mit komma schreibt, war alles kaputtgegangen haha
				
				if (scanner.hasNextDouble()) { // wenn die nächste Eingabe (nummer) ein int ist, dann true (wenn true, dann es wird eine unendliche Schleife werden)

					nummer = scanner.nextInt(); 
					
				} else { // wenn nummer keine Nummer war, dann...

					System.out.println("Bitte, geben Sie eine mögliche Antwort."); // ...dies wird ausgedruckt
																					
					scanner.next(); // Damit wird die ungültige Eingabe gelöscht, so dass bei der Wiederholung der Schleife ein neuer Wert eingegeben werden kann.

				} 
				
			} catch (InputMismatchException e) {
				
	            System.out.println("Bitte, geben Sie eine mögliche Antwort.");
	            
	            scanner.next();

			}
			
		}

		return nummer; // wenn die Schleife endet, wird nummer zurückgegeben
		
	}

	public double scannerDouble(String frage) {

		double nummer = 0; 

		System.out.println(frage); // frage wird ausgedruckt

	    do {
	    	
	        if (scanner.hasNextDouble()) {
	        	
	            nummer = scanner.nextDouble();
	            
	            break; // Schleife abbrechen, nach gültiger Eingabe
	            
	        } else {
	        	
	            System.out.println("Bitte, wählen Sie eine mögliche Antwort.");
	            
	        }
	        
	    } while (true);

		return nummer; // wenn die Schleife endet, wird nummer zurückgegeben

	}
	
	public void next() {
		
		System.out.println("\n...");
		
		scanner.nextLine();
		
	}
	
	public void fixNext() { // Verwendet diese Methode vor next(), wenn next() nicht auf eine Eingabe wartet (passiert manchmal)
		
		scanner.nextLine();
		
	}

	public void closeScanner() {
		scanner.close(); // schliesst den Scanner am Ende des Spiels, ich meine am Ende der Klasse Ende
	} 

}
