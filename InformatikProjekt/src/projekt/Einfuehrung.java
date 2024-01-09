package projekt;

public class Einfuehrung { // Marcello Melofiro
	
	Input input = new Input();
	
	public void intro() {
		
		System.out.println("Es ist 7 Uhr morgens");
		
		input.next();
		
		System.out.println("Der Wecker klingelt");
		
		input.next();
		
		System.out.println("1.Aufstehen\n2.Den Wecker schlummern lassen\n");

		input.scannerInt("Tippe \"1\" um aufzustehen\n"
				+ "Tippe \"2\", um den Wecker zu schlummern", 2);
		
		System.out.println("Du kannst nicht den Wecker schlummern. Man muss arbeiten!");
		
		input.fixNext();
		input.next();

		System.out.println("Müde wachst du auf, um den Wecker auszuschalten.");
		
		input.next();
		
		System.out.println("Aus Versehen hast du den Wecker verschlummert. Es wäre eine Verschwendung, ihn aufzuschieben und keine zehn Minuten mehr zu schlafen.");
		
		input.next();
		
		System.out.println("Du entscheidest dich zu schlafen.");
		
		input.next();
		
		System.out.println("Du fängst an zu träumen...");
		
		input.next();
		
		System.out.println("...Du bist in einem Raum mit schwarz-weiß kariertem Boden...");
		
		input.next();
		
		System.out.println("...Eine Person liegt auf dem Boden...");
		
		input.next();
		
		System.out.println("...Du gehst auf sie zu, kannst du aber sie nicht erkennen...");
		
		input.next();
		
		System.out.println("...Als du näher kommst, beginnt der Raum zu überschwemmen...");
		
		input.next();
		
		System.out.println("...Du versuchst, die Person schneller zu erreichen... ....");
		
		input.next();
		
		System.out.println("...Eine bekannte Stimme ist aus einem Radio zu hören...");
		
		input.next();
		
		System.out.println("...Du kommst zu der Person, die dort liegt...");
		
		input.next();
		
		input.next();
		
		input.next();
		
		System.out.println("Dein Telefon klingelt...");
		
		input.next();
		
		System.out.println("Du stehst schnell auf, es ist deine Kollegin, Allice.");
		
		input.next();
		
		System.out.println("Allice: Jason, der Direktor vom Geheimdienst hat mich angerufen. Sie haben einen sehr großen Fall.");
		
		input.next();
		
		System.out.println("Jason: Häh?");
		
		input.next();
		
		System.out.println("Allice: Ich hoffe, du bist nicht gerade aufgestanden, sonst kommst du 15 Minuten zu spät ins Büro >:(");
		
		input.next();
		
		System.out.println("Du bist wieder eingeschlafen.");
		
		input.next();
		
		System.out.println("Und so fanden sich Jason und Allice, ehemalige Mitglieder des Geheimdienstes, wieder in ihrem letzten großen Fall, den sie übernehmen würden: \"Das Labyrinth\". ");
		
		input.next();
		
		System.out.println("Es handelte sich dabei um einen Hindernislauf, bei dem der Gewinner einen lebensverändernden Preis in Höhe von mehreren Millionen Dollar gewinnen sollte.");
		
		input.next();
		
		System.out.println("Der Preis: Das Leben derjenigen Teilnehmer, die es nicht bis zum Ende geschafft haben.");
		
		input.next();
		
		System.out.println("Dein Ziel als Spion ist es, sich als Teilnehmer in das Spiel zu infiltrieren, herauszufinden, wer dafür verantwortlich ist, und einen Plan zu erstellen, um diese Personen gefangen zu nehmen.");
		
		input.next();
		
		System.out.println("Das Spiel beginnt");
		
		input.next();
		
	}

}
