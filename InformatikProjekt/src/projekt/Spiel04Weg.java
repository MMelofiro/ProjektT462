package projekt;

public class Spiel04Weg {

	Input input = new Input();

	public void weg(Player player) {
		
		player.recover();
		
		System.out.println("Zweiweg der Entscheidungen");
		input.next(); 
		//Gesprach
		System.out.println("Sie haben die Hälfte des Spiels abgeschlossen. Während Sie in den nächsten Raum gehen, spüren Sie, dass die Anzahl der Spieler deutlich zurückgegangen ist.");
		System.out.println("Sie fragen "+player.getMitspieler()+", ob dies die Arbeit der dahinter stehenden Organisation ist.");
		input.next();
		System.out.print(player.getMitspieler() +" antwortet: Das ist richtig. Die Anzahl der Spieler ist stark reduziert. ");
		System.out.println("Denkst du, dass unter den Spielern auch Leute von dieser Organisation gibt?"); 
		input.next();
		System.out.println("Sie fühlen sich gerechtfertigt. Dies erleichtert der Organisation die Beobachtung und Kontrolle.");
		System.out.println("Sie sagen: Du hast Recht. Dann müssen wir vorsichtig mit anderen Menschen sein.");
		input.next();
		
		//Das Spiel beginnt
		System.out.print("Sie gehen weiter, bis sich die Straße in zwei Wege teilt. Auf der rechten ist eine Gruppe von Menschen zu sehen, ");
		System.out.println("die sich unterhalten, auf der linken ist ein einsamer Park sichtbar, aus dem metallische Geräusche zu hören sind.");
																								
		System.out.println("Wohin möchten Sie gehen?");
		
		int nummer = input.scannerInt("1.Links \n2.Rechts", 2);//Wahlen, welche richtung der spieler gehen will
		
		if (nummer == 1) {// wenn der Spieler links gewahlt hat
			
			System.out.println("Sie finden ein Haus mit Essen und Getränke!");// Fragen, ob er Getranke oder Essen wahlt
			
			System.out.println("Möchten sie trinken oder essen? 1 oder 2?");
			
			int nummer1 = input.scannerInt("1. Trinken \n2. Essen", 2); //entscheiden, entweder HP oder ST nehmen
			
			if (nummer1 == 1) {
				System.out.println("Sie beschließen, Wasser zu trinken, nachdem Sie sichergestellt haben, dass es nicht giftig ist.");
				input.next();
				input.fixNext();
				System.out.println("Nach dem Trinken stellen Sie 10 ST wieder her!");
				player.setSt(player.getSt() + 10); // wenn er fur trinken wahlt, dann erhalt er ST
				
			} else if (nummer1 == 2) {// else erhalt er HP
				System.out.println("Sie beschließen zu essen, nachdem Sie sichergestellt haben, dass es nicht giftig ist.");
				input.next();
				input.fixNext();
				System.out.println(" Nach dem Essen stellen Sie 10  wieder her!");
				player.setHp(player.getHp() + 10);
				
			}
			
		} else if (nummer == 2) { // falls und rechts gewahlt wird
			
			System.out.println("Sie werden von der Gruppe von Menschen angegriffen.");
			
			System.out.println("Möchten Sie flüchten oder sich schützen und weiter gehen?");
			
			int nummer2 = input.scannerInt("1.Flüchten \n2. Sich schützen und weiter gehen", 2);
			
			if (nummer2 == 1) {// falls der Spieler flücht, dann wählt er links und kann noch ST oder HP erhalten
				
				System.out.println("Sie laufen schnell zurück zur Kreuzung und gehen nach links");
				
				System.out.println("Sie finden ein Haus mit Essen und Getranke!");
				System.out.println("Mochten Sie essen oder trinken?");
				int nummer3 = input.scannerInt("1. Trinken \n2. Essen", 2);// die Wahl des Spielers
				
				if (nummer3 == 1) {
					System.out.println("Sie beschließen, Wasser zu trinken, nachdem Sie sichergestellt haben, dass es nicht giftig ist.");
					input.next();
					input.fixNext();
					System.out.println(" Nach dem Trinken stellen Sie 10 ST wieder her!");
					player.setSt(player.getSt() + 10); // wenn er fur trinken wahlt, dann erhalt er ST
					
				} else if (nummer3 == 2) {// else erhalt er HP
					System.out.println("Sie beschließen zu essen, nachdem Sie sichergestellt haben, dass es nicht giftig ist.");
					input.next();
					input.fixNext();
					System.out.println("Nach dem Essen stellen Sie 10 HP wieder her!");
					player.setHp(player.getHp() + 10);
					
				}
				else {//sonst kann er auch die herausforderung uberwinden, aber verliert HP
	                  	player.setHp(player.getHp() - 10);
	                	if (player.getHp()<=0) {
					System.out.println("Sie haben alle Lebenspunkte verloren.");
					weg(player);
				} else System.out.println("Sie sind ihnen erfolgreich entkommen, verlieren jedoch 10 HP.");
			}
				
			}
			
		}
			// Ausgabe der aktuellen HP und ST
			player.statusZeigen();
	}

}
