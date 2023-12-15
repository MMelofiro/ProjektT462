package projekt;

public class Hauptklasse {
	
	public static void main(String[] args) {
		
		Einfuehrung einfuehrung = new Einfuehrung(); //introduction instance
		SchwierigCharakter charak = new SchwierigCharakter(); // Difficulty level and charakter selection
		
		einfuehrung.intro();

		charak.charakterAuswaehlen();
		charak.schwierigkeitsgrad();

	}

}
