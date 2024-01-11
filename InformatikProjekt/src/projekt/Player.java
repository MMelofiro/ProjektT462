package projekt;

/*
 * Player Class
 * Diese Klasse wird verwendet, um alle Daten des Players zu speichern.
 * Hier gibt es einige nützliche Methoden:
 * 		Getter für praktisch jede Variable in dieser Klasse.
 * 		Setter jeder Variable, die geändert werden.
 * 		statusZeigen() Methode. Zeigt die aktuellen hp und st des Spielers an.
 * 		save() und recover() Methoden. Ihr braucht die save() Methode nirgendwo zu schreiben, das habe ich schon gemacht, aber die
 * 		recover() Methode muss am Anfang jedes Minispiels geschrieben werden, so dass, wenn der Spieler verliert hat, und das Minispiel neu startet, die
 * 		recover() Methode aktiviert wird und die aktuellen hp und st durch die in der save() Methode gespeicherten Werte ersetzt werden.
 */

public class Player { //Marcello Melofiro
	
	private int hp; // Trefferpunkte / Lebenspunkte
	private int st; // Staminapunkte / Energiepunkte
	private String nameSpieler; // Charakter, vom Spieler ausgewählt
	private String mitspieler; // Wer nicht gespielt wird. Wenn der Spieler Allice ausgewählt hat, dann ist der Mitspieler Jason, und umgekehrt.
	private boolean gerettet; // Boolean für das Ende
	private boolean schwer; // Wenn true, dann Schach wird gespielt
	
	//-------------Checkpoint Variablen-------------
	private int hpSave; // Speicherplätze für hp
	private int stSave; // Speicherplätze für st
	
	//-----------------------Konstruktor-----------------------
	
	public Player() {
		
		hp = 100; // Anfangswerte
		st = 100;
		gerettet = false; // Stellt gerettet auf false

	}
	
	//-----------------------Getters-----------------------
	
	public int getHp() { // den aktuellen Wert der hp des Spielers erhalten
		return hp;
	}
	
	public int getSt() { // den aktuellen Wert der st des Spielers erhalten
		return st;
	}
	
	public String getSpieler() { // den Namen des Charakters erhalten, den der Spieler ausgewählt hat
		return nameSpieler;
	}
	
	public String getMitspieler() { // den Namen des Charakters erhalten, der gerade nicht gespielt wird
		return mitspieler;
	}
	
	public boolean getGerettet() { // Wert von gerettet erhalten
		return gerettet;
	}
	
	public boolean getSchwer() { // Wert von schwer erhalten
		return schwer;
	}
	
	//-----------------------Setters-----------------------
	
	public void setHp(int health) { // diese Methode wird verwendet, um die HP des 
		hp = health;				// Spielers auf einen neuen Wert zu stellen
		if (hp <= 0) { // Jedes Mal, wenn dieser Setter verwendet ist, wird dieses if prüfen, ob hp <= als 0 ist
			System.out.println(
					"Sie haben verloren. :(\n"
					+ "Sie spielen ab dem letzten Kontrollpunkt.");
		}
	}
	
	public void setSt(int stamina) { // diese Methode wird verwendet, um die ST des 
		st = stamina;				 // Spielers auf einen neuen Wert zu stellen
		if (st <= 0) { // Jedes Mal, wenn dieser Setter verwendet ist, wird dieses if prüfen, ob hp <= als 0 ist
			System.out.println(
					"Sie haben verloren. :(\n"
					+ "Sie spielen ab dem letzten Kontrollpunkt.");
		}
	}
	
	public void setGerettet(boolean gt) { // gerettet Setter
		gerettet = gt;
	}
	
	public void setSchwer(boolean schw) { // schwer Setter
		schwer = schw;
	}
	
	//-----------------------Charakter Auswahl-----------------------
	
	public void charakter(int wahl) { // eine Methode mit einem int als Parameter
		
		if (wahl == 1) { // die int "wahl" ist die Wahl, die der Spieler gemacht hat, 1 ist Jason zu sein
			
			nameSpieler = "Jason"; // Name wird zu Jason gestellt
			setHp(75); // HP wird zu 75 gestellt
			setSt(125); // ST wird zu 125 gestellt
			
			mitspieler = "Allice"; // Name mitspielers wird zu Allice gestellt
			
		} else if (wahl == 2) { // wenn der Spieler "2" wählt 
			
			nameSpieler = "Allice"; // dann Spieler spielt als Allice
			setHp(100); // HP wird zu 100 gestellt
			setSt(100); // ST wird zu 100 gestellt
			
			mitspieler = "Jason"; // Name mitspielers wird zu Jason gestellt
			
		}
		
	}
	
	//-----------------------Schwierigkeitsgrad Auswahl-----------------------
	
	public void schwierigkeit(int wahl) { // eine Methode mit einem int als Parameter
		
		if (wahl == 1) { // die int "wahl" ist die Wahl, die der Spieler gemacht hat
			
			setSchwer(false);
			
			System.out.println("Schwierigkeitsgrad auf Normal eingestellt.");
			
		} else if (wahl == 2) { // wenn Spieler 2 wählt...
			
			setSchwer(true); // ...dann wird er auf Schwer Spielen
			
			System.out.println("Schwierigkeitsgrad auf Schwer eingestellt.");
			
		}
		
	}
	
	//-----------------------Stats Zeigen-----------------------
	
	public void statusZeigen() { // diese Methode wird benutzt, um die aktuellen HP und ST des Spielers zu zeigen
		
		System.out.println("\nLebenspunkte: " + getHp());
		
		System.out.println("Stamina: " + getSt());
		
	}
	
	//--------------------------------------Save und Recover Methoden--------------------------------------
	//Kurz gesagt ist save() ein Checkpoint, und recover() stellt Ihre Daten so wieder her, wie sie im Checkpoint waren.
	
	public void save() { // Speichert die aktuellen Werte von hp und st
		
		hpSave = hp; // hpSave übernimmt die Werte von hp
		stSave = st; // dasselbe mit St
		
	}
	
	public void recover () { // ersetzt hp und st, für hpSave und stSave, die die Werte des letzten Aufrufs der save() Methode haben.
		
		hp = hpSave; // hp übernimmt die Werte von hpSave
		st = stSave; // genau

	}

}
