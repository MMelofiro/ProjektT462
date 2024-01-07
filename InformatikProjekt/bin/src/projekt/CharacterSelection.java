package projekt;

public class CharacterSelection { // Marcello Melofiro
	
	Input input = new Input();
	
	public void charakterAuswaehlen(Player player) { //method of character selection
		
		System.out.println("Wählen Sie Ihren Charakter aus");
		
		player.charakter(
				input.scannerInt("1. Jason\n2. Allice", 2) ); //the returned value from method scannerInt() is the parameter from the method charakter() from the class Player
		
		input.fixNext();
		input.next();
		
		System.out.println("Sie spielen als " + player.getSpieler() + "."); //use of getter of spieler to get the name of the player.
		
		player.statusZeigen(); //Show hp and st of player
		
	}

}
