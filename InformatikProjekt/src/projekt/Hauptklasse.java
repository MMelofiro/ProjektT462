package projekt;

/*Hauptklasse Class
 * How is this class used?
 * 	Instances/Objects of the other classes, will be created and used in the main method.
 * 	If possible, no other methods will be created in this class.
 * 	Declare the instances starting with lowercases.
 * 
 * What is inside this class?
 * 	Main method
 *		introduction (method called)
 *		character selection (method called)
 *		difficulty selection (method called)
 *		All the games  (method called)
 *		Ending  (method called)
 */

public class Hauptklasse {

	public static void main(String[] args) {

		Einfuehrung einfuehrung = new Einfuehrung(); // introduction instance
		CharacterSelection selection = new CharacterSelection(); // Difficulty level and character selection
		SchwierigkeitsCharakter schwierigkeit = new SchwierigkeitsCharakter();

		einfuehrung.intro();

		selection.charakterAuswaehlen();
		schwierigkeit.difficulty();

	}

}
