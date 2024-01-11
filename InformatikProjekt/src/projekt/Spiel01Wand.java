package projekt;

public class Spiel01Wand { // Phuong Uyen To

	Input input = new Input(); //ein Instanz erzeugen, um Input Klasse zu benutzen

	public void  wand (Player player) {
		
		input.next();//die method next wird benutzt, um darauf zu warten, dass der Spieler die Eingabetaste drückt, um die Zeile zu ändern
		
		player.recover(); //Erhalten zuvor gespeicherte HP und ST zurück
		// Vorstellung
		System.out.println("Wand erklimmen");
		System.out.println("Wenn Sie den ersten Raum betreten, sehen Sie eine 5 Meter hohe Wand, die auf der weichen Erde sich befindet.");
		System.out.print("Plötzlich war eine Stimme zu hören: Willkommen im Labyrinth. Das Spiel ist in mehrere Runden unterteilt. ");
		System.out.println("Wer alle Runden besteht und als Erster die Ziellinie erreicht, erhält 3 Millionen Dollar. Viel Glück.");
		input.next();
		
		System.out.println("Dies ist die erste Herausforderung für sie: Finden Sie einen Weg, über die Mauer zu gelangen und zur Tür dahinter zu gelangen.");
		input.next();
		System.out.println("Sie schauen sich um und bemerken zwei Details.");																					
		System.out.println(
				"Die Decke des Raums ist hoch genug, um über die Wand zu springen. Es gibt noch "
				+ "im Raum: ein Seil, ein 3 Meter langer Bambus, und eine Schaufel.");
		System.out.print("Sie besprechen mit "+ player.getMitspieler() +", wie Sie Herausforderungen meistern können,");
		System.out.println("und"+ player.getMitspieler() + "schlägt die Verwendung von Seil vor");
		input.next();
																								
		int nummer = input.scannerInt("1. Seil\n2. Bambus\n3. Schaufel", 3); //der Nummer wird von dem Spieler gegeben mithilfe der method scannerInt 

		while (nummer != 3) { // eine while Schleife wird ausgefuhrt wenn falsche Entscheidung getroffen wird.(wenn nummer unterschiedlich von schaufel(3) ist)
			System.out.println("Die Wand ist weich und rutschig deshalb kann es nicht benutzt werden. Sie sind gefallen");
			input.next();
			input.fixNext();
			player.setHp(player.getHp() - 10);//Hp wird reduziert 
			player.setSt(player.getSt() - 10);//ST wird reduziert 
			if (player.getHp() > 0 && player.getSt() > 0) { // Prufen, ob alle HP oder ST verloren sind
				player.statusZeigen(); //ST und Hp anzeigen durch die Method statusZeigen 
				input.next();
				System.out.println("Noch einmal versuchen");
				
				nummer = input.scannerInt("1. Seil\n2. Bambus\n3. Schaufel", 3); //noch einmal die Antwort geben
				
			} else {
				player.statusZeigen();//ST und Hp anzeigen durch die Method statusZeigen 
				input.next();
				wand(player); // Das Spiel wird wiederholt wenn alle ST oder HP verloren sind.
				
				break; // Schleife abbrechen
				
			} 
		}

		if (nummer == 3) { // wenn der Spieler Schaufel wahlt, dann fuhrt diese entscheidung aus
			
			player.setSt(player.getSt() - 10); //ST wird reduziert 
			
			if ((player.getHp() > 0) && (player.getSt() > 0)) { //uberprufen, ob der Spieler noch HP und ST hat
				
				System.out.println("Erfolgreich! Sie sind an der Tür, die zum nächsten Spiel führt, angekommen.");
				
				player.setSt(player.getSt() + 5); // Der Spieler erhalt ST und HP
				player.setHp(player.getHp() + 5);
				
			} else {
				player.statusZeigen();//ST und Hp anzeigen durch die Method statusZeigen
				wand(player); // Das Spiel wird wiederholt wenn alle ST oder HP verloren sind.
				
			}
			
		}
		
	}

}
