package projekt;

/*Hauptklasse Klasse
 * 		Die Instanzen der anderen Klassen werden erzeugt und in der main Methode verwendet.
 * 		Wenn möglich, keine andere Methoden werden in dieser Klasse erzeugt
 * 		Der Name der Instanzen werden mit einem Kleinbuchstaben beginnen.
 * 
 *	Struktur
 * 		Main Methode
 *			Einführung
 *			Charakter auswählen
 *			Schwierigkeitsgrad auswählen
 *			Alle Spiele
 *			Enden
 *			save() Methoden vor und nach jedem Minispiel
 */

public class Hauptklasse { // Marcello Melofiro
	
	public static void main(String[] args) {
		
		Player player = new Player();
		
		Einfuehrung einfuehrung = new Einfuehrung(); // Einführung Instanz
		CharacterSelection charak = new CharacterSelection(); // Charakter auswählen
		SwierigkeitsCharachter schwierig = new SwierigkeitsCharachter(); // Schwierigkeitsgrad
		Spiel01Wand spiel01 = new Spiel01Wand(); // Spiel 01
		Spiel02Schwimm spiel02 = new Spiel02Schwimm(); // Spiel 02
		Spiel03Polar spiel03 = new Spiel03Polar(); // Spiel 03
		Spiel04Weg weg = new Spiel04Weg(); // Spiel 04
		Spiel05Seil spiel05 = new Spiel05Seil(); // Spiel 05
		Retten retten = new Retten(); //Spiel Retten 
		Spiel06Plattform spiel06 = new Spiel06Plattform(); // Spiel06
		Spiel07Schach spiel07 = new Spiel07Schach(); // Spiel07
			char[][] schachbrett = new char[9][9]; // 2d Array der char enthält wird erzeugt und in der Klasse Schachspiel07 benutzt
		Ende ende = new Ende(); // Ende
		
		//Einführung Marcello Melofiro
		einfuehrung.intro();

		// Charakter Auswahl Marcello Melofiro
		charak.charakterAuswaehlen(player);
		
		// Schwierigkeitsgrad Marcello Melofiro
		schwierig.difficulty(player);
			player.save(); // speichert hp- und st-Werte des Starts (des ausgewählten Charakters)
		
		// Spiel 01 Phuong Uyen To
		spiel01.wand(player);
			player.save(); // Speichert die Hp- und St-Werte so, wie sie sind, wenn der Spieler dieses Minispiel beendet het.
			
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
			
		if (player.getSchwer() == true) { // Wenn Schwierigkeitsgrad ist Schwer, dann wird dieses Minispiel gespielt
			
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
		
		if (player.getGerettet() == true) { // Wenn Player den Charakter in der Retten Klasse gerettet hat, dann bekommt er dieses Ende
			
			// Ende 2 Phuong Uyen To
			ende.ende2(player);
			
		} else { // wenn nicht, dann dieses
			
			// Ende 1 Phuong Uyen To
			ende.ende1(player);
			
		}

	}

}
