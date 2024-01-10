package projekt;

public class Spiel05Seil { // Phuong Uyen To

	Input input = new Input();

	public void Seilschwingen(Player player) {
		
		player.recover();
		input.next();
		System.out.println("Seilschwingen");

		//Anweisung
		System.out.println("Nach der kurzen Erholung in letzte Herausforderung, gehen Sie zu dem Ort, an dem die 5. Herausforderung stattfindet");
		System.out.println("Dieses Zimmer ist wie ein tropischer Wald gestaltet");
		input.next();
		System.out.println("Sie werden von  Graben aufgehalten, unter der sich ein Fluss befindet.");
		input.next();
		System.out.println("Es ist zu gefährlich, durch den Fluss zu schwimmen, denn der Graben ist ziemlich tief.");
		System.out.println("An der Decke des Raumes sind viele Drähte befestigt, deren anderes Ende auf dem Boden liegt.");
		input.next();
		System.out.println("Sie verstehen sofort, dass Sie ein dortiges Seil nutzen müssen, um auf die andere Seite zu schwingen.");

		// notwendige Variable deklariert 
		double hohe = Math.random() * 100 + 1; // Zufällige Entfernung zwischen 1 und 100 Metern
		hohe = hohe * 100;
		hohe = Math.round(hohe);
		hohe = hohe / 100; // Diese letzten 3 Zeilen runden Zahlen auf 2 Dezimalstellen.
		double g = 9.8; // Gravitationskonstante

		double v = (2 * hohe) / g; // berechnung die tatsachliche Geschwindigkeit
		v = v * 100;
		v = Math.round(v);
		v = v / 100; // Diese letzten 3 Zeilen runden Zahlen auf 2 Dezimalstellen.
		
		System.out.println(
				"Um die andere Seite zu erreichen, müssen Sie das Seil mit der richtigen "
				+ "Geschwindigkeit schwingen. Die Gravitationskonstante ist 9.8m/s^2. Die Höhe ist "
				+ hohe + ". v = 2h/g =");
																								
		// Spielereingabe für die Geschwindigkeit mithilfe der method scannerdouble
		double vSpieler = input.scannerDouble(
				"Geben Sie die erforderliche Geschwindigkeit zum Schwingen des Seils ein (in m/s): ");
		
		while (vSpieler < v) { // 2 ergebnisse vergleichen
		
			System.out.println(
					"Die Geschwindigkeit ist nicht ausreichend. Das Seil schwingt nicht weit genug. Du bist hinterfallen.");
			System.out.println("Sie müssen zurückgehen, um das Seil zu holen, und verlieren dabei viel HP und ST");
			player.setHp(player.getHp() - 50); //HP und ST werden reduziert
			player.setSt(player.getSt() - 50);
			input.next();
			player.statusZeigen(); //aktuelle HP und ST anzeigen
			
			if (player.getHp() <= 0 || player.getSt() < 0) {
				System.out.println("Sie haben alle Lebenspunkte verloren.");
				Seilschwingen(player); //noch einmal spielen wenn HP oder ST 0 ist
				
				break;// Schleife abbrechen
			
			} else {
			
				System.out.println("Sie holen das Seil und versuchen noch einmal.");
				
				vSpieler = input.scannerDouble(
						"Geben Sie die erforderliche Geschwindigkeit zum Schwingen des Seils ein (in m/s): ");// wenn HP und ST bleiben noch ubrig, dann kann der Spier noch einmal entscheiden
																												
			}
		
		}
		
		if (vSpieler >= v) {// wenn die Geschwindigkeit ausreichend ist, dann erfolgreich
			
			System.out.println("Herzlichen Glückwunsch! Sie haben die andere Seite erreicht.");
			
			if (player.getSt() > 15) {
				
				player.setSt(15);
			
			}
			player.statusZeigen(); //aktuelle HP und ST anzeigen
		}
	
	}

}
