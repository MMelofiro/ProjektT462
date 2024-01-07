package projekt;

public class Spiel04Weg {

	Input input = new Input();

	public void weg(Player player) {
		
		player.recover();
		
		System.out.println("Zweiweg der Entscheidungen");
		
		System.out.println(
				"Sie befinden sich an einer Kreuzung, an der es zwei Wege gibt. Auf der rechten ist eine Gruppe von Menschen zu sehen, die sich unterhalten, auf der linken ist ein einsamer Park sichtbar, aus dem metallische Geräusche zu hören sind.");
																								
		System.out.println("Wohin mochten Sie gehen?");
		
		int nummer = input.scannerInt("1.links \n2. rechts", 2);
		
		if (nummer == 1) {// wenn der Spieler hat links gewahlt
			
			System.out.println("Sie finden ein Haus mit Essen und Getranke!");// Fragen, ob er Getranke oder Essen wahlt
			
			System.out.println("Mochten sie trinken oder essen? 1 oder 2?");
			
			int nummer1 = input.scannerInt("1. Trinken \n2. Essen", 2);
			
			if (nummer1 == 1) {
				
				player.setSt(player.getSt() + 10); // wenn er fur trinken wahlt, dann erhalt er ST
				
			} else if (nummer1 == 2) {// else erhalt er HP
				
				player.setHp(player.getHp() + 10);
				
			}
			
		} else if (nummer == 2) {
			
			System.out.println("Sie werden von der Gruppe von Menschen angegriffen.");// und rechts
			
			System.out.println("Flucht oder sich schutzen?");
			
			int nummer2 = input.scannerInt("1.Flucht \n2. Sich schutzen", 2);
			
			if (nummer2 == 1) {// falls der Spieler flucht, dann wahlt er links und kann noch ST oder HP
								// erhalten
				System.out.println("Sie laufen schnell zurück zur Kreuzung und wählen links");
				
				System.out.println("Sie finden ein Haus mit Essen und Getranke!");
				
				int nummer3 = input.scannerInt("1. Trinken \n2. Essen", 2);// die Wahl des Spielers
				
				if (nummer3 == 1) {
					
					player.setSt(player.getSt() + 10); // wenn er fur trinken wahlt, dann erhalt er ST
					
				} else if (nummer3 == 2) {// else erhalt er HP
					
					player.setHp(player.getHp() + 10);
					
				}
				
			}
			// Ausgabe der aktuellen HP und ST
			player.statusZeigen();
			
		}
		
	}

}
