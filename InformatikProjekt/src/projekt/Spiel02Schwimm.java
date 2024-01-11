package projekt;

public class Spiel02Schwimm { // Marcello Melofiro

		Input input = new Input();

		public void schwimm (Player player) {
			
			player.recover(); // Der Spieler erhält den Zustand, der mit der Methode save() vor dem Start dieses Minispiels gespeichert wurde.
			
			player.statusZeigen(); // Bitte deklariert recover() und statusZeigen() am Anfang jedes Minispiels
			
			input.next();
			
			System.out.println(
					"Du gehst durch einen dunklen Flur. Ein Geruch nach Chlor wird immer stärker.");
			
			input.next();
			
			System.out.println(
					"Die Wachen öffnen die Tür.");
			
			input.next();
			
			System.out.println(
					"Du siehst ein großes Schwimmbad. Der Raum hat himmelblaue Wände und einen weiß gekachelten Boden.");
			
			input.next();
			
			System.out.println(
					"Am Ende des Raumes befindet sich eine Tür, zu der du leicht gehen könntest.");
			
			input.next();
			
			System.out.println(
					"Der Geruch nach Chlor ist verschwunden, du hast dich daran gewöhnt.");
			
			input.next();
			
			System.out.println(
					"Man hört das Geräusch des Mikrofons, das aktiviert wird. Es ist der Ansager. Er wird die Anweisungen geben.");
			
			input.next();
			
			System.out.println(
					"\"Herzlichen Glückwunsch zum Bestehen der ersten Herausforderung.\n"
					+ "Die nächste Herausforderung heißt \"Das Schwimmbad\".");
			
			input.next();
			
			System.out.println(
					"Wie Sie sehen können, befindet sich am Ende des Raumes eine verschlossene Tür. "
					+ "Um sie zu öffnen, müssen Sie den richtigen Schlüssel finden, der am Boden des Schwimmbads liegt.");
			
			input.next();
			
			System.out.println(
					"Dazu haben Sie zwei Möglichkeiten. Tauchen Sie mit der Ausrüstung, die sich an jedem Ende des "
					+ "Schwimmbads befindet, oder drehen Sie das Ventil vor dem Schwimmbad.");
			
			input.next();
			
			System.out.println(
					"Diese letzte Aktion kann nur einmal durchgeführt werden, und je nachdem, in welche "
					+ "Richtung Sie drehen, gibt es zwei verschiedene Ergebnisse.");
			
			input.next();
			
			System.out.println(
					"Wenn Sie in die richtige Richtung drehen, wird das Wasser abgelassen und das Schwimmbad wird wasserfrei sein.");
			
			input.next();
			
			System.out.println(
					"Wenn Sie in die falsche Richtung drehen, werden die Wasserleitungen geöffnet, was dazu führt, dass der gesamte "
					+ "Raum in wenigen Minuten unter Wasser steht.");
			
			input.next();
			
			System.out.println(
					"Das sind alle Anweisungen. Das Spiel beginnt.\"");
			
			input.next();
			
			int choice = input.scannerInt("Was machen Sie?\n1. Sauerstoffballon\n2. Tauchermaske und Flossen\n3. Wasserventil", 3);
			
			int choice1aus = 0;
			
			int choice2aus = 0;
			
			while (choice == 1) { // Sauerstoffballon
				
				System.out.println(
						"Du versuchst zu tauchen. Nach einer Minute fällt es dir auf, dass du immer weniger Luft kriegst.");
				
				input.fixNext();
				input.next();
				
				System.out.println("Die Luftstoffballon ist jetzt lehr! Du tauchst aus dem Wasser auf, aber du bist fast erstickt.");
				
				System.out.println("Du verlierst HP und ST.");
				
				input.next();
				
				player.setHp(player.getHp()-30);
				player.setSt(player.getSt()-40);
				player.statusZeigen();
				
				choice = 0;
				
				if (player.getHp() > 0 && player.getSt() > 0) { // Prufen, ob alle HP oder ST verloren sind
					
					System.out.println("\n"
							+ "Noch einmal versuchen");
					
					choice1aus = input.scannerInt("1. Sauerstoffballon\n2. Tauchermaske und Flossen\n3. Wasserventil", 3);
					
					while (choice1aus == 1) {
						
						System.out.println("\n"
								+ "Du hast das schon benutzt.");
						
						input.fixNext();
						input.next();
						
						choice1aus = input.scannerInt("1. Sauerstoffballon\n2. Tauchermaske und Flossen\n3. Wasserventil", 3);
						
					}
					
				} else {
					
					schwimm(player); // die Methode schwimm wird noch einmal ausgeführt (der Spieler muss noch einmal spielen, ab dem letzten Checkpoint)
					
					break; // Schleife abbrechen
					
				} 
																											
			}
			
			if (choice == 2 || choice1aus == 2) { // Tauchermaske flossen
				
				System.out.println("Du ziehst die Tauchermaske und die Flossen an, und tauchst.");
				
				System.out.println("Du verlierst ST.");
				
				player.setSt(player.getSt()-40);
				player.statusZeigen();
				
				input.fixNext();
				input.next();
				
				choice1aus = 0;
				
				if (player.getHp() > 0 && player.getSt() > 0) { // Prufen, ob alle HP oder ST verloren sind
					
					System.out.println(
							"\n"
							+ "Nach einer Weile, du findest einen Schlüssel. Tauchst aus dem Wasser auf, und probierst mit dem "
							+ "Schlüssel. Die Tür öffnet sich nicht.\n"
							+ "\n"
							+ "Was machst du?");
					
					choice2aus = input.scannerInt("1. Wieder tauchen und suchen\n2. Wasserventil drehen", 2);
					
					if (choice2aus == 1) {
						
						System.out.println("Du wirst wieder getaucht.");
						
						System.out.println("Jetzt wirst du müde.");
						
						input.next();
						
						player.setSt(player.getSt()-40);
						player.statusZeigen();
						
						if (player.getHp() > 0 && player.getSt() > 0) { // Prufen, ob alle HP oder ST verloren sind
							
							System.out.println(
									"Du hast einen anderen Schlüssel gefunden. Jetzt probierst "
									+ "du und die Tür öffnet sich.");
							
							input.next();
							
							System.out.println("Du hast es im nächsten Raum geschaft.");
							
							System.out.println("Du erhälst +10 HP");
							
							player.setHp(player.getHp() + 10);
							
							player.statusZeigen();
							
						} else {
							
							schwimm(player); // die Methode schwimm wird noch einmal ausgeführt (der Spieler muss noch einmal spielen, ab dem letzten Checkpoint)

						}
																												
					}
					
					
				} else {
					
					schwimm(player); // die Methode schwimm wird noch einmal ausgeführt (der Spieler muss noch einmal spielen, ab dem letzten Checkpoint)
					
				} 
																							
			}
			
			if (choice == 3 || choice1aus == 3 || choice2aus == 2) {
				
				System.out.println(
						"Das Wasserventil kann nur ein Mal gedreht werden. Du musst richtig entscheiden.\n"
						+ "In eine Richtung wird das Wasser abgelassen; in die andere wird der gesamte "
						+ "Raum schnell überflutet.");
				
				input.fixNext();
				input.next();
				
				choice2aus = input.scannerInt("\nWas Entscheiden Sie?\n1. Nach links drehen\n2. Nach rechts drehen", 2);
				
				if (choice2aus == 2) {
					
					System.out.println("Das Wasserventil ist schwer zu drehen, aber sie drehen es nach rechts.");
					player.setSt(player.getSt()-10);
					player.statusZeigen();
					
					if (player.getHp() > 0 && player.getSt() > 0) { // Prufen, ob alle HP oder ST verloren sind
						
						System.out.println(
								"\nFünf Sekunden sind vergangen und sie hören ein Geräusch, das immer lauter wird.");
						
						input.next();
						
						System.out.println("\nMit dem Blick auf das Schwimmbad fixiert, merkst du, dass der Wasserstand abnimmt.");
						
						input.next();
						
						System.out.println("Die Wasser ist komplett abgelassen, und ihr findet den Schlüssel.");
						
						input.next();
						
						System.out.println("Sie haben es zu dem nächsten Raum geschafft!");
						
						input.next();
																												
						player.setHp(player.getHp() + 10);
						player.statusZeigen();
						
						input.next();
						
					} else {
						
						schwimm(player); // die Methode schwimm wird noch einmal ausgeführt (der Spieler muss noch einmal spielen, ab dem letzten Checkpoint)

					}
					
				} if (choice2aus == 1) { //links
					
					System.out.println(
							"Das Wasserventil ist schwer zu drehen, aber Sie drehen es nach links."
							+ "\nDu verlierst ST.");
					
					input.fixNext();
					input.next();
					
					player.setSt(player.getSt()-10);
					player.statusZeigen();
					
					if (player.getHp() > 0 && player.getSt() > 0) { // Prufen, ob alle HP oder ST verloren sind
						
						System.out.println(
								"\nFünf Sekunden sind vergangen und sie hören nichts.");
						
						input.next();
						
						System.out.println(
								"\nMit dem Blick auf das Schwimmbad fixiert, merkst du, dass der Wasserstand zunimmt.");
						
						input.next();
						
						System.out.println("Alle sind sofort auf der Suche nach dem Schlüssel.");
						
						input.next();
						
						System.out.println(
								"Du suchst nach der Tauchermaske aber du findest es nicht, trotzdem tauchst du in das Wasser ein."
								+ "\nDu verlierst ST.");
						
						input.next();
						
						player.setSt(player.getSt() - 20);
						player.statusZeigen();
						statusCheck(player);
						
						input.next();
						
						System.out.println(
								"Du hast einen Schlüssel gefunden, aber du warst so lang im Wasser, dass du bist "
								+ "fast erstickt."
								+ "\nDu verlierst HP.");
						
						input.next();
																												
						
						player.setHp(player.getHp() - 30);
						player.statusZeigen();
						statusCheck(player);
						
						input.next();
						
						System.out.println(
								"Der Schlüssel dreht aber die Tür öffnet sich nicht. Du Kriegst Luft und tauchst "
								+ "wieder ein.");
						
						input.next();

						System.out.println("Das Wasser geht immer höher und der Druck wird schwerer."
								+ "\nDu wirst müde.");
						
						input.next();
						
						player.setSt(player.getSt() - 50);
						player.statusZeigen();
						statusCheck(player);
						
						input.next();

						System.out.println("Du hast einen anderen Schlüssel gefunden. Du schwimmst so schnell wie du kannst nach "
								+ "oben, und versuchst nochmal.");
						
						input.next();
						
						System.out.println("Die Tür hat sich geöffnet!"
								+ "\nDu bist im nächstem Raum erlaubt.");
						
						input.next();
						
						player.setHp(player.getHp() + 10);
						player.statusZeigen();
						
						input.next();
						
					} else {
						
						schwimm(player); // die Methode schwimm wird noch einmal ausgeführt (der Spieler muss noch einmal spielen, ab dem letzten Checkpoint)

					}
					
				}
																										
			}
			
		}
		
		public void statusCheck (Player player) {
			
			if (player.getHp() < 1 || player.getSt() < 1) {
				
				schwimm(player);
				
			}
			
		}

}
