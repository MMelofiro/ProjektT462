package projekt;

public class Player {
	
	private int hp; //Health points
	private int st; //Stamina points
	private String nameSpieler; //Character that the player selected
	private String mitspieler; //Who isn't playing. If player selects Allice, then mitspieler is Jason, and viceversa.
	private boolean gerettet; //Boolean for the ending
	private boolean schwer; //If true, then Schachspiel wird gespielt
	//create a method to know in which game the player is, so that when he fails in one game, he returns to the last one he played, with his previous stats and decisions saved.
	
	//-----------------------Konstruktor-----------------------
	
	public Player() {
		
		hp = 100; //Initial values
		st = 100;

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
	
	public boolean getGerettet() {
		return gerettet;
	}
	
	public boolean getSchwer() {
		return schwer;
	}
	
	//-----------------------Setters-----------------------
	
	public void setHp(int health) { //this method will be used to set the hp of the player
		hp = health;				//to a new value
		if (hp <= 0) {
			System.out.println("Du hast verloren");
		}
	}
	
	public void setSt(int stamina) { //this method will be used to set the stamina of the player
		st = stamina;				 //to a new value
		if (st <= 0) {
			System.out.println("Du hast verloren");
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
			
			System.out.println("Schwierigkeitsgrad zu Normal gestellt");
			
		} else if (wahl == 2) { //if player chooses 2...
			
			setSchwer(true); //...then he plays hard mode
			
			System.out.println("Schwierigkeitsgrad zu Schwierig gestellt");
			
		}
		
	}
	
	//-----------------------Show Stats-----------------------
	
	public void statusZeigen() {
		
		System.out.println("Lebenspunkte: " + getHp());
		
		System.out.println("Stamina: " + getSt());
		
	}

}
