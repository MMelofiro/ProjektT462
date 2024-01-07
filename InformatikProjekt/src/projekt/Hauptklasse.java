package projekt;

/*Hauptklasse Class
 *	How is this class used?
 * 		Instances/Objects of the other classes, will be created and used in the main method.
 * 		If possible, no other methods will be created in this class.
 * 		Declare the instances starting with lowercases.
 * 
 *	What is inside this class?
 * 		Main method
 *			introduction (method called)
 *			character selection (method called)
 *			difficulty selection (method called)
 *			All the games  (method called)
 *			Ending  (method called)
 *			save methodes before and after each minigame
 */

public class Hauptklasse { // Marcello Melofiro
	
	public static void main(String[] args) {
		
		Player player = new Player();
		
		Einfuehrung einfuehrung = new Einfuehrung(); // Introduction instance
		CharacterSelection charak = new CharacterSelection(); // Charakter selection
		SwierigkeitsCharachter schwierig = new SwierigkeitsCharachter(); // Difficulty
		Spiel01Wand spiel01 = new Spiel01Wand(); // Spiel 01
		Spiel02Schwimm spiel02 = new Spiel02Schwimm(); // Spiel 02
		//Spiel03 instance
		Spiel04Weg weg = new Spiel04Weg();
		Spiel05Seil spiel05 = new Spiel05Seil();
		//Spiel06 instance
		//Spiel07 instance
		Ende ende = new Ende();
		
		//Intro
		einfuehrung.intro();

		// Character selection
		charak.charakterAuswaehlen(player);
		
		// Difficulty
		schwierig.difficulty(player);
			player.save(); // saves hp and st values of the start, if player looses in game 
		
		// Spiel 01 Phuong Uyen To
		spiel01.wand(player);
			player.save(); // Saves hp and st values as they are when the player just ends this minigame.
			
		//Spiel 02 Marcello Melofiro
		spiel02.schwimm(player);
			player.save();
			
		// Spiel 03 Emir Sultanov
			player.save();
			
		// Spiel 04 Phuong Uyen To
		weg.weg(player);
			player.save();
			
		// Spiel 05 Phuong Uyen To
		spiel05.Seilschwingen(player);
			player.save();
			
		// Spiel 06 Emir Sultanov
			player.save();
			
		if (player.getSchwer() == true) {
			
			// Spiel 07 Emir Sultanov
				player.save();
			
		}
		
		if (player.getGerettet() == true) {
			
			// Ende 2 Phuong Uyen To
			ende.ende2();
			
		} else {
			
			// Ende 1 Phuong Uyen To
			ende.ende1();
			
		}

	}

}
