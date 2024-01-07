package projekt;

public class Spiel01Wand {

	Input input = new Input();
	Player player = new Player();

	public int wand() {
		
		System.out.println("Wand erklimmen");
		
		System.out.print(
				"Das Spiel besteht darin, auf die andere Seite eines Raums zu kommen, der durch eine 5 Meter hohe Wand, die auf der weichen Erde sich befindet, geteilt ist. ");
		
		System.out.println(
				"Die Decke des Raums ist hoch genug, um über die Wand zu springen. Es gibt noch im Raum: ein Seil, ein 3 Meter langer Bambus, und eine Schaufel.");
		
		String[] wand = new String[3];// array fur alle Dinge im raum erzeugen
			wand[0] = "Seil";
			wand[1] = "Bambus";
			wand[2] = "Schaufel";
			
		String n = sc.next();// die Entscheidung von dem Spieler
		int x = 0;
		
		while (!n.equalsIgnoreCase(wand[2])) {// eine while Schleife wird ausgefuhrt wenn falsche Entscheidung getroffen
												// wird.(wenn n unterschied von schaufel ist)
			System.out.println("Sie sind gefallen");
			
			player.setHp(player.getHp() - 10);
			player.setSt(player.getSt() - 10);
			player.status();
			
			if (player.getHp() >= 0 || player.getSt() >= 0) {// Prufen, ob alle HP oder ST verlieren sind
				System.out.println("Versuchen Sie noch einmal");
				n = sc.next();
			} else {
				x++;
				System.out.println("Verlieren");
				break;
			} // Schleife abbrechen
		}
		if (n.equalsIgnoreCase(wand[2])) {// wenn der Spieler Schaufel wahlt, dann fuhrt diese entscheidung aus
			ST = ST - 10;
			if (HP >= 0 && ST > 0) {
				ST = ST + 5; // Der Spieler erhalt ST und HP
				HP = HP + 5;
				System.out.println(HP + "," + ST);
				System.out.println("Erfolgreich!");
			} else {
				System.out.println("Verlieren");
			}
		}
		return x;
	}

}
