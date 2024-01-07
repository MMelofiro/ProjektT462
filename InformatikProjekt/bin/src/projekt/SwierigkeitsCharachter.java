package projekt;

public class SwierigkeitsCharachter { // Marcello Melofiro
	
	Input input = new Input();
	
	public void difficulty(Player player) {
		
		input.next();

		System.out.println("\nSchwierigkeitsgrad: ");
		
		player.schwierigkeit( input.scannerInt("1. Normal\n2. Schwer", 2) );
		
	}

}
