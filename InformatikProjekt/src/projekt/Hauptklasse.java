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
		Spiel03Polar spiel03 = new Spiel03Polar(); // Spiel03
		Spiel04Weg weg = new Spiel04Weg();
		Spiel05Seil spiel05 = new Spiel05Seil();
		Retten retten = new Retten(); //Spiel Retten
		Spiel06Plattform spiel06 = new Spiel06Plattform(); //Spiel06
		Spiel07Schach spiel07 = new Spiel07Schach(); //Spiel07
			char[][] schachbrett = new char[9][9]; // 2d Array der char enthält wird erzeugt und in der Klasse Schachspiel07 benutzt
		Ende ende = new Ende(); // Ende
		
		//Intro Marcello Melofiro
		einfuehrung.intro();

		// Character selection Marcello Melofiro
		charak.charakterAuswaehlen(player);
		
		// Difficulty Marcello Melofiro
		schwierig.difficulty(player);
			player.save(); // saves hp and st values of the start, if player looses in game 
		
		// Spiel 01 Phuong Uyen To
		spiel01.wand(player);
			player.save(); // Saves hp and st values as they are when the player just ends this minigame.
			
		//Spiel 02 Marcello Melofiro
		spiel02.schwimm(player);
			player.save();
			
		// Spiel 03 Emir Sultanov
		spiel03.SpielInfo();	
		spiel03.einzigeAktion(player);
			player.save();
			
		// Spiel 04 Phuong Uyen To
		weg.weg(player);
			player.save();
			
		// Spiel 05 Phuong Uyen To
		spiel05.Seilschwingen(player);
			player.save();
			
		// Spiel Retten Phuong Uyen To
		retten.retten(player);
			player.save();
			
		// Spiel 06 Emir Sultanov
		spiel06.PlatformInfo(); // Aufruf der Methode PlatformInfo, alles unten gilt für object spiel06 Emir
		spiel06.ersteAktion(player); // Aufruf der ersten Aktion
			player.save(); // Die Werten von HP und ST werden behalten
			
		spiel06.mittlereAktion(player); // Aufruf der mittleren Aktion
			player.save(); // Die Werten von HP und ST werden behalten
			
		spiel06.letzzteAktion(player); // Aufruf der letzten Aktion
			player.save();
			
		if (player.getSchwer() == true) {
			
			// Spiel 07 Emir Sultanov
			spiel07.SchachspielInfo(); // Im Prinzip sind alle untere Zeile , die nicht "player.save();" Aufrufen der Methoden des Objectes spieol07
			player.save();
			
			spiel07.initializeChessboard(schachbrett);
			spiel07.SchachspielAktion(player, schachbrett);
			player.save();
			
			spiel07.SchachspielAktion2(player, schachbrett);
			spiel07.erneuerungSchachbrett(schachbrett);
			player.save();
			
		}
		
		if (player.getGerettet() == true) {
			
			// Ende 2 Phuong Uyen To
			ende.ende2(player);
			
		} else {
			
			// Ende 1 Phuong Uyen To
			ende.ende1(player);
			
		}

	}

}
