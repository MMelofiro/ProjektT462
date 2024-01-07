package projekt;

/*
 * Player Class
 * This class is used to save all data from the player.
 * There are some useful methodes here:
 * 		getters of basically every variable in the contructor.
 * 		setters of every variable that will be changed.
 * 		statusZeigen() method. Used to show the current hp and st of the player.
 * 		save() and recover() methodes. You don't need to write the save() method anywhere, I've already done that, but the
 * 		recover() method must be written at the start of every minigame, so that if the player looses, when game restarts, the
 * 		recover() method activates, and replaces current hp and st with the saved in the save() method.
 */

public class Player { //Marcello Melofiro
	
	private int hp; //Health points
	private int st; //Stamina points
	private String nameSpieler; //Character that the player selected
	private String mitspieler; //Who isn't playing. If player selects Allice, then mitspieler is Jason, and viceversa.
	private boolean gerettet; //Boolean for the ending
	private boolean schwer; //If true, then Schachspiel wird gespielt
	
	//-------------Checkpoint variables-------------
	private int hpSave;
	private int stSave;
	
	//-----------------------Konstruktor-----------------------
	
	public Player() {
		
		hp = 100; //Initial values
		st = 100;
		gerettet = false; //Sets gerettet to false

	}
	
	//-----------------------Getters-----------------------
	
	public int getHp() { //get the actual value of hp of the player
		return hp;
	}
	
	public int getSt() { //get the actual value of stamina of the player
		return st;
	}
	
	public String getSpieler() { //get the name of the character the player selected
		return nameSpieler;
	}
	
	public String getMitspieler() { //get name of character that is currently not played
		return mitspieler;
	}
	
	public boolean getGerettet() { //get value of gerettet
		return gerettet;
	}
	
	public boolean getSchwer() { //get value of schwer
		return schwer;
	}
	
	//-----------------------Setters-----------------------
	
	public void setHp(int health) { //this method will be used to set the hp of the player
		hp = health;				//to a new value
		if (hp <= 0) { //Everytime this setter is used, this "if" will check if hp is <= than 0
			System.out.println(
					"Sie haben verloren. :(\n"
					+ "Sie spielen ab dem letzten Kontrollpunkt.");
		}
	}
	
	public void setSt(int stamina) { //this method will be used to set the stamina of the player
		st = stamina;				 //to a new value
		if (st <= 0) { //Everytime this setter is used, this "if" will check if st is <= than 0
			System.out.println(
					"Sie haben verloren. :(\n"
					+ "Sie spielen ab dem letzten Kontrollpunkt.");
		}
	}
	
	public void setGerettet(boolean gt) {
		gerettet = gt;
	}
	
	public void setSchwer(boolean schw) {
		schwer = schw;
	}
	
	//-----------------------Player selection-----------------------
	
	public void charakter(int wahl) { //a method with the parameter of an int
		
		if (wahl == 1) { //the int wahl is the choice that the player made, 1 being to be Jason
			
			nameSpieler = "Jason"; //name sets to Jason
			setHp(75); //hp sets to 75
			setSt(125); //st sets to 125
			
			mitspieler = "Allice"; //name from the mitspieler sets to Allice
			
		} else if (wahl == 2) { //if player chooses 2
			
			nameSpieler = "Allice"; //then player plays as Allice
			setHp(100); //hp sets to 100
			setSt(100); //st sets to 100
			
			mitspieler = "Jason"; //mitspieler sets to Jason
			
		}
		
	}
	
	//-----------------------Difficulty selection-----------------------
	
	public void schwierigkeit(int wahl) { //a method with the parameter of an int
		
		if (wahl == 1) { //the int wahl is the choice that the player made
			
			setSchwer(false);
			
			System.out.println("Schwierigkeitsgrad auf Normal eingestellt.");
			
		} else if (wahl == 2) { //if player chooses 2...
			
			setSchwer(true); //...then he plays hard mode
			
			System.out.println("Schwierigkeitsgrad auf Schwer eingestellt.");
			
		}
		
	}
	
	//-----------------------Show Stats-----------------------
	
	public void statusZeigen() { //this method is used to show the current hp and st of the player
		
		System.out.println("\nLebenspunkte: " + getHp());
		
		System.out.println("Stamina: " + getSt());
		
	}
	
	//--------------------------------------Save and Recover methodes--------------------------------------
	//Basically save() is a checkpoint, and recover() recovers your data as it was in the checkpoint.
	
	public void save() { //Saves current values of hp and st
		
		hpSave = hp; // hpSave sets to the values of hp
		stSave = st; // same with stamina
		
	}
	
	public void recover () { // replaces hp and st, for hpSave, and stSave, which have the values as the last moment save() method was used.
		
		hp = hpSave; // hp sets to the values of hpSave
		st = stSave; // yes

	}

}
