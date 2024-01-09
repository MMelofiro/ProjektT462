package projekt;

/*
 * I still have to comment this, a lot, but it works :DD
 */

public class Spiel01Wand { // Phuong Uyen To

	Input input = new Input();

	public void  wand (Player player) {
		
		input.next();
		
		player.recover(); // recover() goes as the first line of every game method
		
		System.out.println("Wand erklimmen");

		System.out.println(
				"Das Spiel besteht darin, auf die andere Seite eines Raums zu kommen, der durch "
				+ "eine 5 Meter hohe Wand, die auf der weichen Erde sich befindet, geteilt ist. ");
		
		input.next();
		System.out.println("Sie schauen sich um und bemerken zwei Details.");																					
		System.out.println(
				"Die Decke des Raums ist hoch genug, um über die Wand zu springen. Es gibt noch "
				+ "im Raum: ein Seil, ein 3 Meter langer Bambus, und eine Schaufel.");
		System.out.print("Sie besprechen mit "+ player.getMitspieler() +", wie Sie Herausforderungen meistern können,");
		System.out.println("und"+ player.getMitspieler() + "schlägt die Verwendung von Bambus vor");
		input.next();
																								
		int nummer = input.scannerInt("1. Seil\n2. Bambus\n3. Schaufel", 3); //der Nummer wird von dem Spieler gegeben mithilfe der method scannerInt 

		while (nummer != 3) { // eine while Schleife wird ausgefuhrt wenn falsche Entscheidung getroffen wird.(wenn nummer unterschiedlich von schaufel(3) ist)
			System.out.println("Sie sind gefallen");
			
			input.fixNext();
			input.next();
			
			player.setHp(player.getHp() - 10);//Hp reduziert werden 
			player.setSt(player.getSt() - 10);//ST reduziert werden
			player.statusZeigen(); //ST und Hp anzeigen durch die Method statusZeigen in Player-Klasse
			
			input.next();

			if (player.getHp() > 0 && player.getSt() > 0) { // Prufen, ob alle HP oder ST verloren sind
				
				System.out.println("Noch einmal versuchen");
				
				nummer = input.scannerInt("1. Seil\n2. Bambus\n3. Schaufel", 3); //noch einmal die Antwort geben
				
			} else {
				
				wand(player); // the method wand will run again (player has to play again, from last checkpoint)
				
				break; // Schleife abbrechen
				
			} 
		}

		if (nummer == 3) { // wenn der Spieler Schaufel wahlt, dann fuhrt diese entscheidung aus
			
			player.setSt(player.getSt() - 10);
			
			if ((player.getHp() > 0) && (player.getSt() > 0)) { //uberprufen, ob der Spieler noch HP und ST hat
				
				System.out.println("Erfolgreich! Sie sind an der Tür, die zum nächsten Spiel führt, angekommen.");
				
				player.setSt(player.getSt() + 5); // Der Spieler erhalt ST und HP
				player.setHp(player.getHp() + 5);
				
			} else {
				
				wand(player); // minigame repeats
				
			}
			
		}
		
	}

}