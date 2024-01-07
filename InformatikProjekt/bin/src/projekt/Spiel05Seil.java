package projekt;

public class Spiel05Seil { // Phuong Uyen To

	Input input = new Input();

	public void Seilschwingen(Player player) {
		
		player.recover();
		
		System.out.println("Seilschwingen");
		
		double hohe = Math.random() * 100 + 1; // Zufällige Entfernung zwischen 1 und 100 Metern
		hohe = hohe * 100;
		hohe = Math.round(hohe);
		hohe = hohe / 100; // these last 3 lines round hohe to 2 Nachkommastellen.
		
		double g = 9.8; // Gravitationskonstante
		
		System.out.println(
				"Um die andere Seite zu erreichen, müssen Sie das Seil mit der richtigen "
				+ "Geschwindigkeit schwingen. Die Gravitationskonstante ist 9.8m/s^2. Die Höhe ist "
				+ hohe + ". v = 2h/g =");
																								
		// Spielereingabe für die Geschwindigkeit
		
		double v = (2 * hohe) / g; // berechnung die tatsachliche Geschwindigkeit
		v = v * 100;
		v = Math.round(v);
		v = v / 100; // these last 3 lines round v to 2 Nachkommastellen.
		
		double vSpieler = input.scannerDouble(
				"Geben Sie die erforderliche Geschwindigkeit zum Schwingen des Seils ein (in m/s): ");
		
		while (vSpieler < v) { // 2 ergebnisse vergleichen
		
			System.out.println(
					"Die Geschwindigkeit ist nicht ausreichend. Das Seil schwingt nicht weit genug.");
																									
			player.setHp(player.getHp() - 50);
			player.setSt(player.getSt() - 50);
			player.statusZeigen();
			
			if (player.getHp() <= 0 || player.getSt() < 0) {
				
				Seilschwingen(player);
				
				break;// Schleife abbrechen
			
			} else {
			
				System.out.println("Noch einmal versuchen");
				
				vSpieler = input.scannerDouble(
						"Geben Sie die erforderliche Geschwindigkeit zum Schwingen des Seils ein (in m/s): ");// wenn HP und ST bleiben noch ubrig, dann kann der Spier noch einmal
																												// entscheiden
			}
		
		}
		
		if (vSpieler >= v) {// wenn die Geschwindigkeit ausreichend ist, dann
			
			System.out.println("Herzlichen Glückwunsch! Sie haben die andere Seite erreicht.");
			
			if (player.getSt() > 15) {
				
				player.setSt(15);
				player.statusZeigen();
			
			}
			
		}
	
	}

}
