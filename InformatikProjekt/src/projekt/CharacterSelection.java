package projekt;

public class CharacterSelection { // Marcello Melofiro
	
	Input input = new Input();
	
	public void charakterAuswaehlen(Player player) { // Methode um Charakter auszuwählen
		
		System.out.println("Wählen Sie Ihren Charakter aus");
		
		player.charakter(
				input.scannerInt("1. Jason\n2. Allice", 2) ); // der von der Methode scannerInt() returned Wert ist der Parameter der Methode charakter()
		
		System.out.println("Sie spielen als " + player.getSpieler() + "."); // Nutzung des Getters von spieler, um den Namen des Spielers zu erhalten
		
	}

}
