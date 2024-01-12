package projekt;

public class Spiel06Plattform { // Emir Sultanov
	
    Input input = new Input(); // Input Object für Eingabe

    public  void PlatformInfo() { // methode für Einführung in Spiel , information für den Spieler
        System.out.println("Herzliche Glückwunsche, sie haben sechste Herausferoderung erreicht.");
        input.next(); // Benutzer Eingabe , dadurch dass er klickt oder etwas eingibt, geht er zu den nächsten Info Printanweisung

        System.out.println("Sie sind in ein großes Raum eingetreten. Sie sehen die andere Seite des Raumes. Um diese Stufe zu überwinden, sollen sie durch die Tür , die auf anderer Seite des Raumes");
        input.next(); // Benutzer Eingabe , dadurch dass er klickt oder etwas eingibt, geht er zu den nächsten Info Printanweisung

        System.out.println(". Zwischen der Seiten gibt es sogennante Brücke aus den Plattformen, unter den Plattformen ist Abgrund, dessen Höhe nicht bekannt ist. Um die andere Seite");
        input.next(); // Benutzer Eingabe , dadurch dass er klickt oder etwas eingibt, geht er zu den nächsten Info Printanweisung

        System.out.println("(des Raumes zu erreichen, müssen sie durch die Plattformen, die aus den geometrischen Figuren besteht, springen.");
    }
    public  void ersteAktion(Player player) { // Methode zur Aktion  mit Parameter Klasse player
        player.recover();  // die (HP) und (ST) des Spielers auffüllt, wie es vorher gespeichert wurde
       
        if (player.getSt() < 20 || player.getHp() < 20) { // Wenn Spieler ST benötigt, wird er mehrere zusätzliche ST bekommen
            System.out.println("Sie spüren eine Welle der Erholung durch Ihren Körper fließen.");
            player.setSt(player.getSt() +35 ); 
            player.setHp(player.getHp() +35 ); 
        }
        else {
            System.out.println("Sie atmen tief durch und fühlen sich  mehrer erfrischt.");
            player.setSt(player.getSt() +15 ); // Ansonsten bekommt er etwas weniger
        }
        
        player.statusZeigen();
        System.out.println("Sie sind nun bereit zum neuen Abenteueren");
        input.next();
        
        System.out.println("Sie sollen die Flächeninhalte dieser Figuren berechnen, um die Stabilität jeder Plattform zu bestimmen.");
        System.out.println("Hinweis: je größer die Fläche ist, desto stabiler ist Plattform");
        input.next();

        System.out.println("Wählen sie die Plattform mit dem größten Flächeinhalt.");
        input.next();

        System.out.println("Die ersten drei Plattformen stehen vor Ihnen in Formen von: 1. Rechteck mit breite = 1.5 m, länge = 2,0m. 2. gleichseitiges Dreieck mit Seite = 2,5 m 3. Kreis mit Radius 1,0 m");
      
        int ant; // eine Variable namens deklariert die später verwendet wird, um die Antwort des Spielers später zu speichern

        do { // Wird solange ausgefuhrt, wenn ans nicht gleich 3 UND Spieler hat noch ST HP

            ant = input.scannerInt(" 1. Rechteck\n2. Dreieck\n3. Kreis", 3); // Zuweisung und Speicherung der Eingabe mit der Fragestellung

            if (ant != 3) { // Wenn die Antwort nicht gleich 3 ist, wird der Spieler aktualisiert.
                player.setHp(player.getHp() - 15);  // Wenn Eingabe des Spielers nicht 3 ist, HP wird um 15 sich verringert
                player.setSt(player.getSt() - 15); //  Wenn Eingabe des Spielers nicht 3 ist, ST wird um 15 sich verringert
                player.statusZeigen(); // Aufruf zur Methode Es wird die Lebenspunkte hp und stamina Ausdauerpunkte gezeigt
                System.out.println("Die Plattform gibt unter Ihnen nach und Sie stürzen in die Tiefe. Aber Sie lassen sich nicht entmutigen und klettern wieder hoch, bereit, es erneut zu versuchen.");


                if (player.getHp() <= 0 || player.getSt() <= 0) { // Wenn der Spieler keine HP oder ST mehr hat, wird eine Meldung ausgegeben.
                    System.out.println("Sie sind stark gestürzt,da die Plattforme nicht stabil war ");
                    ersteAktion(player); // Aufforderung des Spieles ersteAktion nochmal machen vom Anfang
                    break; // Ende der Schleife

                }
            } else {
              
                    System.out.println("Richtig! Sie haben erste Plattform übersprungen. Sie haben zwar einige Ausdauerpunkte verloren. ");
                    player.statusZeigen(); // Aufruf zur Methode Es wird die Lebenspunkte hp und stamina Ausdauerpunkte gezeigt
                }
             
        } while (ant != 3);  // Wird solange ausgefuhrt, wenn ans nicht gleich 3 UND Spieler hat noch ST HP

    }
        public  void mittlereAktion (Player player) {  // Methode zur Aktion  mit Parameter Klasse player
            System.out.println("Sie haben ersten Teil des Brückes überwunden");
            player.recover();
            input.next();
          
            System.out.println("Vor ihnen stehen ein Hexagon (Sechseck), dessen Seiten gleich lang sind. Seite des Hexagons = 5dm und ein gleichschenkliges Trapez, mit den Basen 8 dm und 5 dm. Und höhe 5 dm ");
            System.out.println("Hinweis: je größer die Fläche ist, desto stabiler ist Plattform . Zur Berechnung der Fläche des Hexagons können sie Formel A=3√3/2*a². A- Seitelänge im Quadrat");
            

            int ant; // eine Variable namens deklariert die später verwendet wird, um die Antwort des Spielers später zu speichern

            do {  // Wird solange ausgefuhrt, wenn ans nicht gleich 1 

                ant = input.scannerInt("1. Hexagon\n2. Trapez", 2); // Richtige Antwort ist Hexagon, da der Flächeinhalt der Figur (~65dm²) ist > als A des Trapezes (~32,5dm²)

                if (ant != 1) {  // Wenn die Antwort nicht gleich 1 ist, wird der Spieler aktualisiert.
                    player.setHp(player.getHp() - 15);  // Wenn Eingabe des Spielers nicht 1 ist, HP wird um 15 sich verringert
                    player.setSt(player.getSt() - 15); //  Wenn Eingabe des Spielers nicht 1 ist, ST wird um 15 sich verringert
                    player.statusZeigen(); // Aufruf zur Methode Es wird die Lebenspunkte hp und stamina Ausdauerpunkte gezeigt
                    System.out.println("Probieren Sie es noch einmal.");

                    if (player.getHp() <= 0 || player.getSt() <= 0) { //  dann wird überprüft ob er noch ST und HP hat
                    	System.out.println("Sie sind stark gestürzt,da die Plattforme nicht stabil war ");
                        ersteAktion(player);  // Aufforderung des Spieles ersteAktion nochmal machen vom Anfang
                        mittlereAktion(player); // Das Spiel wird vom Anfang wieder gespielt, wenn HP oder ST <= sind
                        letzzteAktion(player);
                        break;// Prufen, ob alle HP oder ST verlieren sind

                    }
                } else {
                     // Wenn benutzer richtie Ans also 1 Gewählt hat, dann wird überprüft ob er noch ST hat
                        System.out.println("Richtig! Sie haben zweitere Plattform übersprungen. Sie haben zwar einige Ausdauerpunkte verloren.Machen Sie ruhig Pause ");
                        player.statusZeigen(); // Aufruf zur Methode Es wird die Lebenspunkte hp und stamina Ausdauerpunkte gezeigt
                    } 
                
            } while (ant != 1); // Wird solange ausgefuhrt, wenn ans nicht gleich 1
        }
        public  void letzzteAktion (Player player) {  // Methode zur letzen Aktion  mit Parameter Klasse player

        System.out.println("Sie sind fast am Ende des Brückes, es gibt noch eine Plattform Reihe und alles ist vobei");
        input.next();
        
        System.out.println("Plotzlich wurde das Licht im Raum ausgeschaltet, Sie können kaum etwas ansehen");
        input.next();
        
            System.out.println("Vor Ihnen stehen die letzten drei Plattformen: 1. Pentagon (Fünfeck) mit x cm Seite 2. Ellipse mit Radien längere  x+5cm, und mit kurzerem  x-3cm. x sei 3,5 cm ");
            input.next();
            
            System.out.println("Ellipse Fläche kann A=π⋅a⋅b berechnet werden, wobei a die Länge des längsten Radius (Halbachse) und b die Länge des kürzesten Radius (Halbachse) ist");
            input.next();
            
            System.out.println("Fläche des Pentagons ist 2*,*6 cm² (* sind Fehlende Ziffern). Überlegen Sie einfach welche Fläche das Elipse hat und entscheiden Sie sich was ist größere Fläche");
            
            int ant; // eine Variable namens deklariert die später verwendet wird, um die Antwort des Spielers später zu speichern

            do { // Wird solange ausgefuhrt, wenn ans nicht gleich 1 UND Spieler hat noch ST HP

                ant = input.scannerInt("1. Pentagon\n2. Ellipse", 3); // Pentagon 21,46cm², Ellipse 13,35cm² , wobei Pentagon ist richtig, da Fläche des Pentagons > Fläche der Ellipse

                if (ant != 1) {   // Wenn die Antwort nicht gleich 1 ist, wird der Spieler aktualisiert.
                    player.setHp(player.getHp() - 15);  // Wenn Eingabe des Spielers nicht 1 ist, HP wird um 15 sich verringert
                    player.setSt(player.getSt() - 15); //  Wenn Eingabe des Spielers nicht 1 ist, ST wird um 15 sich verringert
                    player.statusZeigen(); // Aufruf zur Methode Es wird die Lebenspunkte hp und stamina Ausdauerpunkte gezeigt
                    System.out.println("Probieren Sie es noch einmal.");
                    

                    if (player.getHp() <= 0 || player.getSt() <= 0) { // Wenn benutzer richtie Ans also 1 Gewählt hat, dann wird überprüft ob er noch ST und HP hat
                    	System.out.println("Sie sind stark gestürzt,da die Plattforme nicht stabil war ");
                        ersteAktion(player);  // Aufforderung des Spieles diese Herausforderung nochmal vom Anfang machen
                        mittlereAktion(player); // Das Spiel wird vom Anfang wieder gespielt, wenn HP oder ST <= sind
                        letzzteAktion(player);
                        break;// Ende der Schleife
                    }

                } else {
                    
                 // Wenn benutzer richtie Ans also 1 Gewählt hat, dann wird überprüft ob er noch ST und HP hat
                	System.out.println("Das Licht wird wieder eingeschaltet, und Sie sehen die Tür auf der anderen Seite des Raums.");
                	
                        System.out.println("Richtig! Sie haben zweite Plattform übersprungen. Sie haben zwar einige Ausdauerpunkte verloren.Machen Sie ruhig Pause");
                        
                        System.out.println("Herzlichen Glückwunsch! Sie haben die Herausforderung erfolgreich gemeistert und die Tür erreicht.");
                        player.statusZeigen(); // Aufruf zur Methode Es wird die Lebenspunkte hp und stamina Ausdauerpunkte gezeigt
                  
                }

            } while (ant != 1); // Wird solange ausgefuhrt, wenn ans nicht gleich 1


        }

}
