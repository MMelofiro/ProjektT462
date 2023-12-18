package projekt;

/*
 * I still have to comment this, a lot, but it works :DD
 * A method for loosing is still needed, probably
 */

public class Spiel01Wand {

	Input input = new Input();

	public boolean wand(Player player) {
		System.out.println("Wand erklimmen");

		System.out.print(
				"Das Spiel besteht darin, auf die andere Seite eines Raums zu kommen, der durch eine 5 Meter hohe Wand, die auf der weichen Erde sich befindet, geteilt ist. ");

		System.out.println(
				"Die Decke des Raums ist hoch genug, um über die Wand zu springen. Es gibt noch im Raum: ein Seil, ein 3 Meter langer Bambus, und eine Schaufel.");

		int nummer = input.scannerInt("1. Seil\n2. Bambus\n3. Schaufel", 3);

		while (nummer != 3) {// eine while Schleife wird ausgefuhrt wenn falsche Entscheidung getroffen
								// wird.(wenn n unterschied von schaufel ist)
			System.out.println("Sie sind gefallen");
			player.setHp(player.getHp() - 10);
			player.setSt(player.getSt() - 10);
			player.statusZeigen();

			if (player.getHp() > 0 && player.getSt() > 0) {// Prufen, ob alle HP oder ST verlieren sind
				System.out.println("Noch einmal versuchen");
				nummer = input.scannerInt("1. Seil\n2. Bambus\n3. Schaufel", 3);
			} else {
				player.setVerloren(true);
				System.out.println("Sie haben verloren.");
				break;
			} // Schleife abbrechen
		}

		if (nummer == 3) {// wenn der Spieler Schaufel wahlt, dann fuhrt diese entscheidung aus
			player.setSt(player.getSt() - 10);
			if (player.getHp() > 0 && player.getSt() > 0) {
				player.setSt(player.getSt() + 5); // Der Spieler erhalt ST und HP
				player.setHp(player.getHp() + 5);
				player.statusZeigen();
				System.out.println("Erfolgreich!");
			} else {
				player.setVerloren(true);
				System.out.println("Sie haben verloren");
			}
		}

		return player.getVerloren();
	}

}
