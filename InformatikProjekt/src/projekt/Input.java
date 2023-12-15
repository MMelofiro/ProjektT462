package projekt;

import java.util.Scanner;

public class Input {
	
	private Scanner scanner;
	
	public Input() {
		
		scanner = new Scanner(System.in);
		
	}
	
	public int scannerInt(String frage, int min, int max) { //method for every decision we will give. You can see an example of how I used this method in the class SchwierigCharakter and Player
								//min is always 1, max is the number of decision the player can make. This is declared so that the player can't give a bigger number than the actual number of options.
        int nummer;
        
        System.out.println(frage);
        
        do { //this will repeat at least once
            //this while below verifies if the input given by the player was an int
            while (!scanner.hasNextInt()) { //hasNextInt() verifies if "next input" is an int, if it is, then returns the value true. So basically this line of code means: 
            								//while hasNextInt = false (! inverts the boolean)...
                System.out.println(frage); //...then print this
                
                scanner.next(); // this is the "next input", it's a String, so it could be anything
                		
            } //notice how if the input was not an int, we won't go to the next line, so it will ask forever to get an int.
            
            nummer = scanner.nextInt(); //now the "next input", if it goes out of the loop, will be saved here, so that nummer = "next input". I don't know why, literally no idea
            
            if (nummer < min || nummer > max) { //this verifies if nummer is out of the range
            	System.out.println(frage); //if it is then it will ask again
            }
            
        } while (nummer < min || nummer > max); //will loop while nummer is out of range
        
        return nummer; //finally when everything is correct, nummer will be returned
        
    }

    public void closeScanner() { //method to close the scanner, VERY IMPORTANT!
        scanner.close();	//Close the scanner for every decision, if not, then the last input will
    }						//still be saved, and compared in the loop by hasNextInt() method.

}
