package projekt;

public class SchwierigCharakter {
	
	Input input = new Input(); //We will have to create these objects for every class...
	
	Player player = new Player(); //...in order to use the methods in them.
	
	public void charakterAuswaehlen() { //method of character selection
		
		System.out.println("Wählen Sie Ihren Charakter aus");
		
		player.charakter(input.scannerInt("1. Jason\n2. Allice", 1, 2)); //here are 2 methods: charackter from class Player, and scannerInt from class Input
		
		System.out.println("Sie spielen als " + player.getSpieler() + "."); //use of getter of spieler to get the name of the player.
		
		input.closeScanner(); //scanner closes
		
		
	}
	
	public void schwierigkeitsgrad() {
		
		
		
	}

}
