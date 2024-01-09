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
				System.out.println(" Nach dem Trinken stellen Sie 10 ST wieder her!");
				player.setSt(player.getSt() + 10); // wenn er fur trinken wahlt, dann erhalt er ST
				
			} else if (nummer1 == 2) {// else erhalt er HP
				System.out.println(" Nach dem Essen stellen Sie 10  wieder her!");
				player.setHp(player.getHp() + 10);
				
			}
			
		} else if (nummer == 2) {
			
			System.out.println("Sie werden von der Gruppe von Menschen angegriffen.");// und rechts
			
			System.out.println("Mochten Sie fluchten oder sich schutzen und weiter gehen?");
			
			int nummer2 = input.scannerInt("1.Fluchten \n2. Sich schutzen und weiter gehen", 2);
			
			if (nummer2 == 1) {// falls der Spieler flucht, dann wahlt er links und kann noch ST oder HP
								// erhalten
				System.out.println("Sie laufen schnell zurück zur Kreuzung und gehen nach links");
				
				System.out.println("Sie finden ein Haus mit Essen und Getranke!");
				System.out.println("Mochten Sie essen oder trinken?");
				int nummer3 = input.scannerInt("1. Trinken \n2. Essen", 2);// die Wahl des Spielers
				
				if (nummer3 == 1) {
					System.out.println(" Nach dem Trinken stellen Sie 10 ST wieder her!");

					player.setSt(player.getSt() + 10); // wenn er fur trinken wahlt, dann erhalt er ST
					
				} else if (nummer3 == 2) {// else erhalt er HP
					System.out.println(" Nach dem Essen stellen Sie 10 HP wieder her!");
					player.setHp(player.getHp() + 10);
					
				}
				else {//sonst kann er die herausforderung uberwinden, aber verliert HP
	                  	player.setHp(player.getHp() - 10);
	                	if (player.getHp()<=0) {
					weg(player);
					System.out.println("Sie haben alle Lebenspunkte verloren.");
				} else System.out.println("Sie sind ihnen erfolgreich entkommen, verlieren jedoch 10 HP.");
			}
				
			}
			
		}
			// Ausgabe der aktuellen HP und ST
			player.statusZeigen();
	}

}