package projekt;

public class Player {
	
	private int hp; //Health points
	private int st; //Stamina points
	private String nameSpieler; //Character that the player selected
	private String mitspieler; //Who isn't playing. If player selects Allice, then mitspieler is Jason, and viceversa.
	
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
	
	//-----------------------Setters-----------------------
	
	public void setHp(int health) { //this method will be used to set the hp of the player
		hp = health;				//to a new value
	}
	
	public void setSt(int stamina) { //this method will be used to set the stamina of the player
		st = stamina;				 //to a new value
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

}
